package ar.net.mgardos.vsfridge.assembly.broker.base.usage;

import ar.net.mgardos.vsfridge.assembly.broker.base.state.BaseFridgeStateBuilder;
import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;

import java.util.Optional;

/**
 * Use the fridge to open one of its doors.
 *
 * @param <D> the type of the door identifier.
 */
public class BaseOpenDoorUsage<D> implements FridgeUsage {
	static final String INVALID_FRIDGE = "Unable to open the door of an invalid fridge.";

	private final D doorId;

	public BaseOpenDoorUsage(final D doorId) {
		this.doorId = doorId;
	}

	@Override
	public FridgeState applyTo(final SmartFridge fridge) {
		Optional.ofNullable(fridge)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_FRIDGE))
		        .open(doorId);

		return new BaseFridgeStateBuilder().recordOpen()
		                                   .build();
	}
}
