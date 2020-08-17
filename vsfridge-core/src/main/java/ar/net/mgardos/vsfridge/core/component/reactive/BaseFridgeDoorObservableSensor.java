package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.component.Plugable;
import io.reactivex.Emitter;
import io.reactivex.Observable;
import lombok.Getter;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class BaseFridgeDoorObservableSensor extends BaseFridgeDoorObserverSensor implements Plugable {
    @Getter
    private Observable<Boolean> isOpenedObservable;

    private Emitter<Boolean> producer;

    public BaseFridgeDoorObservableSensor() {
        super();

        isOpenedObservable = createIsOpenedObservable();
    }

    public BaseFridgeDoorObservableSensor(Long timeInterval, TimeUnit timeUnit) {
        super(timeInterval, timeUnit);

        isOpenedObservable = createIsOpenedObservable();
    }

    private Observable<Boolean> createIsOpenedObservable() {
        return Observable.generate(emitter -> {
            producer = emitter;
            Optional.of(previousIsOpened)
                    .filter(wasOpened -> wasOpened.equals(fridgeDoor.isOpened()))
                    .orElseGet(() -> {
                        emitter.onNext(fridgeDoor.isOpened());
                        return fridgeDoor.isOpened();
                    });
        });
    }

    @Override
    public void disable() {
        producer.onComplete();
        super.disable();
    }
}
