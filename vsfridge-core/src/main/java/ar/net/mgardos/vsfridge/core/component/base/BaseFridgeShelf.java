package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeShelf;
import ar.net.mgardos.vsfridge.core.component.Sensor;
import ar.net.mgardos.vsfridge.core.component.Sensors;

public class BaseFridgeShelf implements FridgeShelf {
	private Sensors sensors;

	public BaseFridgeShelf() {
		sensors = new BaseSensors();
	}

	public BaseFridgeShelf(Integer quantity) {
		sensors = new BaseSensors(quantity);
	}

	@Override
	public Boolean hasCapacityForSensors() {
		return sensors.hasCapacity();
	}

	@Override
	public Boolean hasSensors() {
		return sensors.hasSensors();
	}

	@Override
	public void addSensor(Sensor sensor) {
		sensors.addSensor(sensor);
	}
}
