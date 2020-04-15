package ar.net.mgardos.vsfridge.core.component;

public interface Sensor<T> {
	/**
	 * Observes a component or a property to capture the events it produces or changes on its state.
	 *
	 * @param object the type of the component or property observed.
	 */
	default void sense(T object) {}

	/**
	 * Enables the sensor so it starts observing.
	 */
	default void enable() {}

	/**
	 * Pause or ends the observation the sensor is performing.
	 */
	default void disable() {}
}
