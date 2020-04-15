package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.Product;
import ar.net.mgardos.vsfridge.core.component.Sensor;
import ar.net.mgardos.vsfridge.core.event.FridgeEvent;
import ar.net.mgardos.vsfridge.core.event.FridgeEventConsumer;
import io.reactivex.Observable;

public class FlowableSensor<T> implements Sensor<T> {
	Observable source = Observable.create(emitter -> {
		emitter.onNext(null);
	});

	@Override
	public void sense(T product) {

	}
}
