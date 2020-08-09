package ar.net.mgardos.vsfridge.assembly.broker.base.usage;

import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static ar.net.mgardos.vsfridge.assembly.broker.base.usage.BaseCloseDoorUsage.INVALID_FRIDGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

class BaseCloseDoorUsageTest {
	private static final String DOOR_ID = "ABC123";

	private BaseCloseDoorUsage<String> closeDoorUsage;

	@Mock
	private SmartFridge fridge;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		closeDoorUsage = new BaseCloseDoorUsage<>(DOOR_ID);
	}

	@Test
	void testApplyToWhenFridgeNullThenException() {
		final SmartFridge fridge = null;

		assertThatThrownBy(() -> closeDoorUsage.applyTo(fridge)).isInstanceOf(IllegalArgumentException.class)
		                                                        .hasMessage(INVALID_FRIDGE);
	}

	@Test
	void testApplyToWhenFridgeAndDoorExistsThenClose() {
		closeDoorUsage.applyTo(fridge);

		verify(fridge).close(eq(DOOR_ID));
	}
}