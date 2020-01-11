package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.Sensor;
import ar.net.mgardos.vsfridge.core.component.Sensors;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class BaseSensors implements Sensors {
	private Sensor sensors[];

	static final String INVALID_SENSORS_QUANTITY = "Quantity for sensors is invalid.";
	static final String UNABLE_TO_ADD_SENSOR = "Provided sensor can't be added, it is invalid.";
	static final String CAPACITY_REACHED = "The capacity has been reached already, no more doors can be added.";

	public BaseSensors() {
		sensors = new Sensor[1];
	}

	public BaseSensors(Integer quantity) {
		Objects.requireNonNull(quantity, INVALID_SENSORS_QUANTITY);
		Optional.of(Integer.valueOf(0).compareTo(quantity))
		        .filter(value -> value <= 0)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_SENSORS_QUANTITY));

		sensors = new Sensor[quantity];
	}

	@Override
	public Boolean hasSensors() {
		return size() > 0;
	}

	@Override
	public Integer size() {
		Long quantity = Optional.of(sensors)
		                        .map(Arrays::stream)
		                        .get()
		                        .filter(Objects::nonNull)
		                        .count();

		return quantity.intValue();
	}

	@Override
	public Integer capacity() {
		return sensors.length;
	}

	@Override
	public void addSensor(Sensor sensor) {
		Objects.requireNonNull(sensor, UNABLE_TO_ADD_SENSOR);
		Optional.of(hasCapacity())
		        .filter(capacity -> capacity.equals(true))
		        .orElseThrow(() -> new RuntimeException(CAPACITY_REACHED));

		int index = 0;
		while (Objects.nonNull(sensors[index])) {
			index++;
		}
		sensors[index] = sensor;
	}
}
