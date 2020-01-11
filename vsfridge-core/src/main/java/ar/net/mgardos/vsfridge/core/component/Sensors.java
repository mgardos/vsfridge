package ar.net.mgardos.vsfridge.core.component;

public interface Sensors {
	String SENSORS_NOT_SUPPORTED = "Shelves are not supported by this fridge model.";

	default void addSensor(Sensor sensor) {
		throw new RuntimeException(SENSORS_NOT_SUPPORTED);
	}

	default Boolean hasSensors() {
		return false;
	}

	/**
	 * Total number of sensors added to this container.
	 *
	 * @return total number of sensors added
	 */
	default Integer size() {
		return 0;
	}

	/**
	 * Maximum number of sensors this container can hold.
	 *
	 * @return max number of sensors that can be added
	 */
	default Integer capacity() {
		return 0;
	}

	default Boolean hasCapacity() {
		return capacity() - size() > 0;
	}
}
