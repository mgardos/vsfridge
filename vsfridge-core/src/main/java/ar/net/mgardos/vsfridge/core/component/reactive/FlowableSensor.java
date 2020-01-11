package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.Product;
import ar.net.mgardos.vsfridge.core.component.Sensor;
import ar.net.mgardos.vsfridge.core.event.FridgeEvent;
import ar.net.mgardos.vsfridge.core.event.FridgeEventConsumer;
import io.reactivex.Observable;

public class FlowableSensor implements Sensor {
	Observable source = Observable.create(emitter -> {
		emitter.onNext(null);
	});

	@Override
	public void sense(Product product) {

	}
}
