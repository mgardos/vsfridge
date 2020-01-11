package ar.net.mgardos.vsfridge.core.component;

import ar.net.mgardos.vsfridge.core.Product;

public interface Sensor {
	/**
	 * Observes a fridge component to capture the events it produces.
	 *
	 * @param product A fridge component capable of producing events
	 */
	default void sense(Product product) {}

	default void enable() {}

	default void disable() {}
}
