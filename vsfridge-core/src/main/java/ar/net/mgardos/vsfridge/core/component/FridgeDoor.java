package ar.net.mgardos.vsfridge.core.component;

public interface FridgeDoor {
	default Boolean isOpened() {
		return false;
	}

	default void open() {}
	default void close() {}

	default Long timeElapsed() {
		return 0L;
	}

	default Integer timesOpened() {
		return 0;
	}
}
