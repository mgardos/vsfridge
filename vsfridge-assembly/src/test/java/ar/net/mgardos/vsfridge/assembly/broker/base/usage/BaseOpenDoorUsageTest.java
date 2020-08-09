package ar.net.mgardos.vsfridge.assembly.broker.base.usage;

import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static ar.net.mgardos.vsfridge.assembly.broker.base.usage.BaseOpenDoorUsage.INVALID_FRIDGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

class BaseOpenDoorUsageTest {
	private static final String DOOR_ID = "ABC123";

	private BaseOpenDoorUsage<String> openDoorUsage;

	@Mock
	private SmartFridge fridge;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		openDoorUsage = new BaseOpenDoorUsage<>(DOOR_ID);
	}

	@Test
	void testApplyToWhenFridgeNullThenException() {
		final SmartFridge fridge = null;

		assertThatThrownBy(() -> openDoorUsage.applyTo(fridge)).isInstanceOf(IllegalArgumentException.class)
		                                                       .hasMessage(INVALID_FRIDGE);
	}

	@Test
	void testApplyToWhenFridgeAndDoorExistsThenOpen() {
		openDoorUsage.applyTo(fridge);

		verify(fridge).open(eq(DOOR_ID));
	}
}