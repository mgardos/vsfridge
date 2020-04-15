package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.component.Plugable;
import ar.net.mgardos.vsfridge.core.component.Sensor;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class BaseCompositeFridgeDoorObservableSensor<T> implements Sensor<Plugable<T>> {
    private List<Observable<Boolean>> observableSensors;

    @Override
    public void sense(Plugable<T> sensor) {
        Observable<Boolean> o = Observable.generate(emitter -> {
            emitter.onNext(false);
        });

        observableSensors.add(o);
    }

    @Override
    public void enable() {
        Observable.combineLatest(observableSensors, objects -> {
            return Arrays.stream(objects)
                         .reduce(true, (isOpened, object) -> isOpened, (isOpened1, isOpened2) -> isOpened1 & isOpened2 );
        });
    }

    @Override
    public void disable() {

    }
}
