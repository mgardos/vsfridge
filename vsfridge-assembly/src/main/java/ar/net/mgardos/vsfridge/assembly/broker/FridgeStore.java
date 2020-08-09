package ar.net.mgardos.vsfridge.assembly.broker;

import ar.net.mgardos.vsfridge.core.component.SmartFridge;

public interface FridgeStore {
	/**
	 * Allows the retrieval of a Fridge that was previously set aside.
	 *
	 * @param fridgeId the identifier used for retrieving the Fridge.
	 * @param <F> the type of the identifier used for finding the Fridge.
	 * @return the Fridge if it is available in the store.
	 */
	<F> SmartFridge reclaim(F fridgeId);

	void setAside(SmartFridge fridge);
}
