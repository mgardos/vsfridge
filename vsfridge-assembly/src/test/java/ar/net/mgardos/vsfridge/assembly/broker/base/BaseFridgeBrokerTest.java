package ar.net.mgardos.vsfridge.assembly.broker.base;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeStore;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeAssembler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ar.net.mgardos.vsfridge.assembly.broker.base.BaseFridgeBroker.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class BaseFridgeBrokerTest {
	private BaseFridgeBroker fridgeBroker;

	@BeforeEach
	void setUp() {
		fridgeBroker = new BaseFridgeBroker();
	}

	@Test
	void testRegisterFridgeAssemblerWhenAssemblerNullThenException() {
		final FridgeAssembler assembler = null;

		assertThatThrownBy(() -> fridgeBroker.registerFridgeAssembler(assembler)).isInstanceOf(IllegalArgumentException.class)
		                                                                         .hasMessage(INVALID_ASSEMBLER);
	}

	@Test
	void testRegisterFridgeAssemblerWhenAssemblerThenRegister() {
		final FridgeAssembler assembler = mock(FridgeAssembler.class);

		fridgeBroker.registerFridgeAssembler(assembler);
	}

	@Test
	void testRegisterFridgeStoreWhenStoreNullThenException() {
		final FridgeStore store = null;

		assertThatThrownBy(() -> fridgeBroker.registerFridgeStore(store)).isInstanceOf(IllegalArgumentException.class)
		                                                                 .hasMessage(INVALID_STORE);
	}

	@Test
	void testRegisterFridgeStoreWhenStoreThenRegister() {
		final FridgeStore store = mock(FridgeStore.class);

		fridgeBroker.registerFridgeStore(store);
	}

	@Test
	void testUseFridgeWhenFridgeIdNullThenException() {
		final String fridgeId = null;
		final FridgeUsage usage = mock(FridgeUsage.class);

		assertThatThrownBy(() -> fridgeBroker.useFridge(fridgeId, usage)).isInstanceOf(IllegalArgumentException.class)
		                                                                 .hasMessage(INVALID_FRIDGE_ID);
	}

	@Test
	void testUseFridgeWhenFridgeAndUsageNullThenException() {
		final String fridgeId = "abc123";
		final FridgeUsage usage = null;

		assertThatThrownBy(() -> fridgeBroker.useFridge(fridgeId, usage)).isInstanceOf(IllegalArgumentException.class)
		                                                                 .hasMessage(INVALID_FRIDGE_USAGE);
	}

	@Test
	void testUseFridgeWhenStoreNullThenException() {
		final String fridgeId = "abc123";
		final FridgeUsage usage = mock(FridgeUsage.class);

		assertThatThrownBy(() -> fridgeBroker.useFridge(fridgeId, usage)).isInstanceOf(IllegalStateException.class)
		                                                                 .hasMessage(UNABLE_TO_LOOK_FOR_FRIDGE);
	}

	@Test
	void testUseFridgeWhenFridgeIdNotInStoreThen() {
		final String fridgeId = "abc123";
		final FridgeUsage usage = mock(FridgeUsage.class);

		final FridgeStore store = mock(FridgeStore.class);
		fridgeBroker.registerFridgeStore(store);

		FridgeUsage usageResult = fridgeBroker.useFridge(fridgeId, usage);

		assertThat(usageResult).isNotNull();
		verify(store, times(1)).reclaim(eq(fridgeId));
		verify(usage, times(1)).applyTo(isNull());
	}

	@Test
	void testUseFridge() {
	}
}