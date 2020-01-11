package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeShelf;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ar.net.mgardos.vsfridge.core.component.base.BaseSensors.INVALID_SENSORS_QUANTITY;
import static ar.net.mgardos.vsfridge.core.component.base.BaseSensors.UNABLE_TO_ADD_SENSOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseFridgeShelfTest {
	private FridgeShelf fridgeShelf;

	@BeforeEach
	void setUp() {
	}

	@Test
	public void testCreateDefaultShelf() {
		fridgeShelf = new BaseFridgeShelf();

		assertThat(fridgeShelf.hasSensors()).isFalse();
		assertThat(fridgeShelf.hasCapacityForSensors()).isTrue();
	}

	@Test
	public void testCreateShelfForNoSensors() {
		fridgeShelf = new BaseFridgeShelf(0);

		assertThat(fridgeShelf.hasCapacityForSensors()).isFalse();
		assertThat(fridgeShelf.hasSensors()).isFalse();
	}

	@Test
	public void testCreateShelfWithInvalidQuantity() {
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThatThrownBy(() -> new BaseFridgeShelf(null)).isInstanceOf(NullPointerException.class)
		          .hasMessage(INVALID_SENSORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeShelf(-1)).isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(INVALID_SENSORS_QUANTITY);
		assertions.assertAll();
	}

	@Test
	public void testAddSensorWithInvalidSensor() {
		fridgeShelf = new BaseFridgeShelf(1);

		assertThatThrownBy(() -> fridgeShelf.addSensor(null)).isInstanceOf(NullPointerException.class)
		                                                     .hasMessage(UNABLE_TO_ADD_SENSOR);
	}
}