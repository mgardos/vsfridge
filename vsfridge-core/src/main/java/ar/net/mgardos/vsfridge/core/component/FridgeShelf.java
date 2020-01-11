package ar.net.mgardos.vsfridge.core.component;

public interface FridgeShelf {
	default Boolean hasCapacityForSensors() {
		return false;
	}

	default Boolean hasSensors() {
		return false;
	}

	default void addSensor(Sensor sensor) {}
}
