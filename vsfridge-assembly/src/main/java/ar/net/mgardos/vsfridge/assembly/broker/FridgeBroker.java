package ar.net.mgardos.vsfridge.assembly.broker;

import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeAssembler;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeModel;

/**
 * Coordinates the access to the fridge features.
 */
public interface FridgeBroker {
	/**
	 * Provides the broker with an assembler capable of mounting fridges.
	 *
	 * @param assembler that builds Fridges with specific features.
	 */
	void registerFridgeAssembler(FridgeAssembler assembler);

	/**
	 * Provides the broker with a store for caching and finding already created fridges.
	 *
	 * @param store that keeps created Fridges available for use.
	 */
	void registerFridgeStore(FridgeStore store);

	/**
	 * Make use of the Fridge, like turning it on, opening the door and putting food in it.
	 *
	 * @param fridgeId the identifier of the fridge to be used.
	 * @param usage the use of Fridge to be done.
	 * @param <F> the type of identifier of the Fridge.
	 * @return the state of the Fridge after the usage is applied to it.
	 */
	<F> FridgeState useFridge(F fridgeId, FridgeUsage usage);

	/**
	 * Make use of a new Fridge, it is created, initialized and then the specified use is applied to it.
	 *
	 * @param model specifies the features of the Fridge.
	 * @param <F> the type of identifier of the Fridge.
	 * @return the identifier of the Fridge created and used.
	 */
	<F> F makeFridge(FridgeModel model);

	/**
	 * Dismisses the Fridge so it is not longer available.
	 *
	 * @param fridgeId the identifier of the fridge to be dismissed.
	 * @param <F> the type of identifier of the Fridge.
	 */
	<F> void discardFridge(F fridgeId);
}
