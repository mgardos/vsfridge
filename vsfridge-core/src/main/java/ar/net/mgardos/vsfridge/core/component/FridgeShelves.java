package ar.net.mgardos.vsfridge.core.component;

public interface FridgeShelves {
	String SHELVES_NOT_SUPPORTED = "Shelves are not supported by this fridge model.";

	default void addShelf(FridgeShelf shelf) {
		throw new RuntimeException(SHELVES_NOT_SUPPORTED);
	}

	default Boolean hasShelves() {
		return false;
	}

	/**
	 * Total number of shelves added to this container.
	 *
	 * @return total number of shelves added
	 */
	default Integer size() {
		return 0;
	}

	/**
	 * Maximum number of shelves this container can hold.
	 *
	 * @return max number of shelves that can be added
	 */
	default Integer capacity() {
		return 0;
	}

	default Boolean hasCapacity() {
		return capacity() - size() > 0;
	}
}
