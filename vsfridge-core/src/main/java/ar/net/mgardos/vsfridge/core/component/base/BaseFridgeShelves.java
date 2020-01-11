package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeShelf;
import ar.net.mgardos.vsfridge.core.component.FridgeShelves;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class BaseFridgeShelves implements FridgeShelves {
	private FridgeShelf[] shelves;

	static final String INVALID_SHELVES_QUANTITY = "Quantity of shelves is invalid.";
	static final String CAPACITY_REACHED = "The capacity has been reached already, no more doors can be added.";
	static final String UNABLE_TO_ADD_SHELF = "Provided door can't be added, it is invalid.";

	public BaseFridgeShelves() {
		shelves = new FridgeShelf[2];
	}

	public BaseFridgeShelves(Integer quantity) {
		Objects.requireNonNull(quantity, INVALID_SHELVES_QUANTITY);
		Optional.of(quantity)
		        .filter(q -> q >= 0)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_SHELVES_QUANTITY));

		shelves = new FridgeShelf[quantity];
	}

	@Override
	public void addShelf(FridgeShelf shelf) {
		Objects.requireNonNull(shelf, UNABLE_TO_ADD_SHELF);
		Optional.of(hasCapacity())
		        .filter(capacity -> capacity.equals(true))
		        .orElseThrow(() -> new RuntimeException(CAPACITY_REACHED));

		int index = 0;
		while (Objects.nonNull(shelves[index])) {
			index++;
		}
		shelves[index] = shelf;
	}

	@Override
	public Boolean hasShelves() {
		Boolean withShelves = Optional.ofNullable(shelves).isPresent();
		withShelves = withShelves && Arrays.stream(shelves).anyMatch(Objects::nonNull);

		return withShelves;
	}

	@Override
	public Integer size() {
		Long size = Optional.ofNullable(shelves)
		                    .map(Arrays::stream)
		                    .get()
		                    .filter(Objects::nonNull)
		                    .count();

		return size.intValue();
	}

	@Override
	public Integer capacity() {
		return Optional.ofNullable(shelves)
		               .map(s -> s.length).orElse(0);
	}
}
