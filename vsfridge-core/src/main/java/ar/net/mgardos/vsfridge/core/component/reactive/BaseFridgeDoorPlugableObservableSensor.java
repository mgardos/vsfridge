package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.component.Plugable;
import io.reactivex.Observable;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class BaseFridgeDoorPlugableObservableSensor extends BaseFridgeDoorObserverSensor implements Plugable {
    private Observable<Boolean> isOpenedObservable;

    public BaseFridgeDoorPlugableObservableSensor() {
        super();

        isOpenedObservable = createIsOpenedObservable();
    }

    public BaseFridgeDoorPlugableObservableSensor(Long timeInterval, TimeUnit timeUnit) {
        super(timeInterval, timeUnit);

        isOpenedObservable = createIsOpenedObservable();
    }

    private Observable<Boolean> createIsOpenedObservable() {
        return Observable.generate(emitter -> {
            Optional.of(previousIsOpened)
                    .filter(wasOpened -> wasOpened.equals(fridgeDoor.isOpened()))
                    .orElseGet(() -> {
                        emitter.onNext(fridgeDoor.isOpened());
                        return fridgeDoor.isOpened();
                    });
        });
    }
}
