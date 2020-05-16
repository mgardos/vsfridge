package ar.net.mgardos.vsfridge.core.component;

public interface Sensor<T> {
	String ERROR_MSG_TEMPLATE = "The sensor is not capable of %s.";

	/**
	 * Observes a component or a property to capture the events it produces or changes on its state.
	 *
	 * @param object the type of the component or property observed.
	 */
	default void sense(T object) {
		throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "sensing."));
	}

	/**
	 * Enables the sensor so it starts observing.
	 */
	default void enable() {
		throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "becoming enabled."));
	}

	/**
	 * Pause or ends the observation the sensor is performing.
	 */
	default void disable() {
		throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "disabling."));
	}
}
