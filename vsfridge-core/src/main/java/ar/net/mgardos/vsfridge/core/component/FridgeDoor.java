package ar.net.mgardos.vsfridge.core.component;

public interface FridgeDoor {
	default Boolean isOpened() {
		return false;
	}

	default void open() {
		throw new RuntimeException("The door is not ready to be opened.");
	}

	default void close() {
		throw new RuntimeException("The door is not ready to be closed.");
	}

	default Long timeElapsed() {
		return 0L;
	}

	default Integer timesOpened() {
		return 0;
	}
}
