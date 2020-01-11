package ar.net.mgardos.vsfridge.core.component.base;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static ar.net.mgardos.vsfridge.core.component.base.BaseSensors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseSensorsTest {
	private BaseSensors sensors;

	@BeforeEach
	void setUp() {
	}

	@Test
	public void testCreateDefaultSensors() {
		sensors = new BaseSensors();

		assertThat(sensors.capacity()).isEqualTo(1);
		assertThat(sensors.hasCapacity()).isTrue();
		assertThat(sensors.size()).isEqualTo(0);
		assertThat(sensors.hasSensors()).isFalse();
	}

	@Test
	public void testCreateSensorsWithNoSensors() {
		sensors = new BaseSensors(0);

		assertThat(sensors.capacity()).isEqualTo(0);
		assertThat(sensors.hasCapacity()).isFalse();
		assertThat(sensors.size()).isEqualTo(0);
		assertThat(sensors.hasSensors()).isFalse();
	}

	@Test
	public void testCreateSensorsWithInvalidQuantity() {
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThatThrownBy(() -> new BaseSensors(null)).isInstanceOf(NullPointerException.class)
		          .hasMessage(INVALID_SENSORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseSensors(-1)).isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(INVALID_SENSORS_QUANTITY);
		assertions.assertAll();
	}

	@Test
	public void testAddSensorWithInvalidSensor() {
		sensors = new BaseSensors();

		assertThatThrownBy(() -> sensors.addSensor(null)).isInstanceOf(NullPointerException.class)
		                                                 .hasMessage(UNABLE_TO_ADD_SENSOR);
	}

	@Test
	public void testAddSensorWhenNoCapacity() {
		sensors = new BaseSensors(0);

		assertThatThrownBy(() -> sensors.addSensor(new BaseSensor())).isInstanceOf(RuntimeException.class)
		                                                             .hasMessage(CAPACITY_REACHED);
	}

	@Test
	public void testAddOneSensor() {
		sensors = new BaseSensors(3);

		sensors.addSensor(new BaseSensor());

		assertThat(sensors.capacity()).isEqualTo(3);
		assertThat(sensors.hasCapacity()).isTrue();
		assertThat(sensors.size()).isEqualTo(1);
		assertThat(sensors.hasSensors()).isTrue();
	}

	@Test
	void testAddSeveralSensorsToReachCapacity() {
		sensors = new BaseSensors(2);

		sensors.addSensor(new BaseSensor());
		sensors.addSensor(new BaseSensor());

		assertThat(sensors.hasSensors()).isTrue();
		assertThat(sensors.size()).isEqualTo(sensors.capacity());
		assertThat(sensors.hasCapacity()).isFalse();
	}

	@Test
	void testAddMoreSensorsThanCapacity() {
		sensors = new BaseSensors(1);

		sensors.addSensor(new BaseSensor());

		assertThatThrownBy(() -> sensors.addSensor(new BaseSensor())).isInstanceOf(RuntimeException.class)
		                                                             .hasMessage(BaseFridgeShelves.CAPACITY_REACHED);
	}
}