package ar.net.mgardos.vsfridge.emu;

import ar.net.mgardos.vsfridge.core.Product;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeModel;

public interface FridgeController<T> {
	/**
	 * Checks if the Fridge identified by fridgeId is already plugged.
	 *
	 * @param fridgeId identifier for the Fridge
	 * @return true if the Fridge is already plugged (actually exists and is ready) or
	 *         false if the Fridge is not plugged (so it does not exists)
	 */
	boolean isPlugged(T fridgeId);

	/**
	 * Puts a Fridge to work by plugging it.
	 *
	 * @param model specifies the features of the Fridge.
	 * @return an identifier of the Fridge that is plugged and ready to turn on.
	 */
	T plug(FridgeModel model);

	void unplug(T fridgeId);
	boolean isTurnedOn(T fridgeId);
	void turnOn(T fridgeId);
	void turnOff(T fridgeId);
	void put(Product product);
	void take(Product product);
}
