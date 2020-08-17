package ar.net.mgardos.vsfridge.assembly.broker.usage;

import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;

public interface FridgeUsage {
	/**
	 * Applies the usage to the provided Fridge.
	 *
	 * @param fridge the full-fleshed instance to which the usage is applied.
	 * @return
	 */
	FridgeState applyTo(SmartFridge fridge);
}
