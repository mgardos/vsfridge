package ar.net.mgardos.vsfridge.core.component;

public interface FridgeDoors extends Iterable<FridgeDoor> {
	String DOORS_NOT_SUPPORTED = "Doors are not supported by this fridge model.";

	default void addDoor(FridgeDoor door) {
		throw new RuntimeException(DOORS_NOT_SUPPORTED);
	}

	default Boolean hasDoors() {
		return false;
	}

	/**
	 * Total number of doors added to this container.
	 *
	 * @return total number of doors added
	 */
	default Integer size() {
		return 0;
	}

	/**
	 * Maximum number of doors this container can hold.
	 *
	 * @return max number of doors that can be added
	 */
	default Integer capacity() {
		return 0;
	}

	default Boolean hasCapacity() {
		return capacity() - size() > 0;
	}
}
