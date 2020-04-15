package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.Sensor;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseFridgeDoorObserverSensor implements Sensor<FridgeDoor>, Observer<Long> {
    protected FridgeDoor fridgeDoor;
    protected Boolean previousIsOpened;
    private Long snapshotTime;
    private TimeUnit snapshotTimeUnit;
    private Observable<Long> timer;
    private Disposable subscription;

    static final String INVALID_SENSOR = "Unable to start sensing invalid door.";
    static final String ALREADY_SENSING = "Sensor is already sensing the provided door.";
    static final String SENSOR_NOT_INITIALIZED = "Uninitialized sensor cannot be enabled. Start sensing first before enabling the sensor.";
    static final String SENSOR_NOT_ENABLED = "Sensor cannot be disabled, it should be enabled first.";
    static final String ALREADY_ACCEPTING_STATUS = "Sensor already accepting door status.";

    /**
     * By default, this sensor takes snapshots of the door every second.
     */
    public BaseFridgeDoorObserverSensor() {
        snapshotTime = 1L;
        snapshotTimeUnit = TimeUnit.SECONDS;
    }

    /**
     * Defines the interval between snapshots.
     *
     * @param timeInterval the number of units of time to wait until the snapshot is taken.
     * @param timeUnit the unit of time for the interval.
     */
    public BaseFridgeDoorObserverSensor(Long timeInterval, TimeUnit timeUnit) {
        snapshotTime = Optional.ofNullable(timeInterval)
                               .filter(interval -> interval > 0)
                               .orElseThrow(() -> new IllegalArgumentException("Time interval must be greater than 0."));
        snapshotTimeUnit = Optional.ofNullable(timeUnit)
                                   .orElseThrow(() -> new IllegalArgumentException("Time unit for time interval must be valid"));
    }

    @Override
    public void sense(FridgeDoor door) {
        Optional.ofNullable(door)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_SENSOR));
        Optional.ofNullable(fridgeDoor)
                .ifPresent(fd -> {throw new IllegalStateException(ALREADY_SENSING);});

        fridgeDoor = door;
        previousIsOpened = door.isOpened();
        timer = Observable.interval(snapshotTime, snapshotTimeUnit);
    }

    @Override
    public void enable() {
        Optional.ofNullable(subscription)
                .ifPresent(sub -> {throw new IllegalStateException(ALREADY_ACCEPTING_STATUS);});
        Optional.ofNullable(timer)
                .orElseThrow(() -> new IllegalStateException(SENSOR_NOT_INITIALIZED))
                .subscribeWith(this);
    }

    @Override
    public void disable() {
        Optional.ofNullable(subscription)
                .filter(observer -> Boolean.FALSE.equals(observer.isDisposed()))
                .ifPresentOrElse(observer -> {
                    onComplete();
                    observer.dispose();
                }, () -> {
                    subscription = null;
                    throw new IllegalStateException(SENSOR_NOT_ENABLED);
                });
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        subscription = disposable;
    }

    @Override
    public void onNext(Long value) {
        previousIsOpened = Optional.of(previousIsOpened)
                                   .filter(wasOpened -> wasOpened.equals(fridgeDoor.isOpened()))
                                   .orElse(fridgeDoor.isOpened());
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("The door sensor failed to execute.", throwable);
    }

    @Override
    public void onComplete() {
        log.warn("Sensor stopped accepting door status.");
    }
}
