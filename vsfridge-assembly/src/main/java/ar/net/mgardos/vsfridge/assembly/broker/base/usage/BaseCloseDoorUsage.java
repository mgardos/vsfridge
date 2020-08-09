package ar.net.mgardos.vsfridge.assembly.broker.base.usage;

import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;

import java.util.Optional;

/**
 * Use the fridge to close one of its doors.
 *
 * @param <D> the type of the door identifier.
 */
public class BaseCloseDoorUsage<D> implements FridgeUsage {
	static final String INVALID_FRIDGE = "Unable to close the door of an invalid fridge.";

	private final D doorId;

	public BaseCloseDoorUsage(final D doorId) {
		this.doorId = doorId;
	}

	@Override
	public void applyTo(SmartFridge fridge) {
		Optional.ofNullable(fridge)
				.orElseThrow(() -> new IllegalArgumentException(INVALID_FRIDGE))
				.close(doorId);
	}
}
