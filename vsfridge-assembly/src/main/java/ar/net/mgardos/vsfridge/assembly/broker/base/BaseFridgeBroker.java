package ar.net.mgardos.vsfridge.assembly.broker.base;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeBroker;
import ar.net.mgardos.vsfridge.assembly.broker.FridgeStore;
import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeAssembler;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeModel;

import java.util.Optional;

public class BaseFridgeBroker implements FridgeBroker {
	private FridgeAssembler fridgeAssembler;
	private FridgeStore fridgeStore;

	static final String INVALID_ASSEMBLER = "Provided assembler is not valid.";
	static final String INVALID_STORE = "Provided store is not valid";
	static final String INVALID_FRIDGE_ID = "Provided id for looking up a fridge is invalid.";
	static final String INVALID_FRIDGE_USAGE = "Provided usage is invalid.";
	static final String UNABLE_TO_LOOK_FOR_FRIDGE = "Unable to look for fridge, invalid store.";
	static final String INVALID_FRIDGE_MODEL = "Provided fridge model is invalid.";
	static final String UNABLE_TO_CREATE_FRIDGE = "Unable to create fridge, invalid assembler.";

	@Override
	public void registerFridgeAssembler(final FridgeAssembler assembler) {
		fridgeAssembler = Optional.ofNullable(assembler)
		                          .orElseThrow(() -> new IllegalArgumentException(INVALID_ASSEMBLER));
	}

	@Override
	public void registerFridgeStore(final FridgeStore store) {
		fridgeStore = Optional.ofNullable(store)
		                      .orElseThrow(() -> new IllegalArgumentException(INVALID_STORE));
	}

	@Override
	public <String> FridgeState useFridge(final String fridgeId, final FridgeUsage usage) {
		Optional.ofNullable(fridgeId)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_FRIDGE_ID));
		Optional.ofNullable(usage)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_FRIDGE_USAGE));

		SmartFridge fridge = Optional.ofNullable(fridgeStore)
		                             .orElseThrow(() -> new IllegalStateException(UNABLE_TO_LOOK_FOR_FRIDGE))
		                             .reclaim(fridgeId);

		return usage.applyTo(fridge);
	}

	@Override
	public <String> String makeFridge(FridgeModel model) {
		Optional.ofNullable(model)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_FRIDGE_MODEL));
		Optional.ofNullable(fridgeAssembler)
		        .orElseThrow(() -> new IllegalStateException(UNABLE_TO_CREATE_FRIDGE));

		final SmartFridge fridge = fridgeAssembler.makeFridge(model);
		final String fridgeId = fridgeStore.<String>setAside(fridge);

		return fridgeId;
	}

	@Override
	public <F> void discardFridge(F fridgeId) {

	}
}
