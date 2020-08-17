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

	/**
	 * Return a Fridge to the store, so it can be retrieved later when needed.
	 *
	 * @param fridge instance to put in the store.
	 * @param <F> the type of the identifier of the Fridge.
	 * @return the identifier of the Fridge, so it can be retrieved later.
	 */
	<F> F setAside(SmartFridge fridge);

	/**
	 * Discards the Fridge so it is not longer available.
	 *
	 * @param fridgeId identifies the Fridge to disassemble.
	 * @param <F> the type of the identifier of the Fridge.
	 */
	<F> void disassemble(F fridgeId);
}
