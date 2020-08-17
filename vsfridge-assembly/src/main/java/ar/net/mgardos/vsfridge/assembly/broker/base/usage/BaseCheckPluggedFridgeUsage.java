package ar.net.mgardos.vsfridge.assembly.broker.base.usage;

import ar.net.mgardos.vsfridge.assembly.broker.base.state.BaseFridgeStateBuilder;
import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;

import java.util.Optional;

public class BaseCheckPluggedFridgeUsage implements FridgeUsage {
	static final String INVALID_FRIDGE = "Unable to check if plugged an invalid fridge.";

	@Override
	public FridgeState applyTo(SmartFridge fridge) {
		Optional.ofNullable(fridge)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_FRIDGE));

		final BaseFridgeStateBuilder fridgeStatusBuilder = new BaseFridgeStateBuilder();
		if (fridge.isPlugged()) {
			fridgeStatusBuilder.recordIsPlugged();
		}

		return fridgeStatusBuilder.build();
	}
}
