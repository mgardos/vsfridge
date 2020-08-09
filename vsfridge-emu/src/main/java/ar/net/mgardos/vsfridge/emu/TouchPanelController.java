package ar.net.mgardos.vsfridge.emu;

import ar.net.mgardos.vsfridge.core.Food;

import java.util.List;

public interface TouchPanelController {
	/**
	 * Gets all the food inside the Fridge.
	 *
	 * @return all the food inside the Fridge
	 */
	List<Food> viewAllFood();
	List<Food> findFood();
}
