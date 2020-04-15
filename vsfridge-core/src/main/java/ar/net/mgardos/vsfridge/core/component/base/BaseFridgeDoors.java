package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeDoors;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

public class BaseFridgeDoors implements FridgeDoors {
	private FridgeDoor[] doorsLeft;
	private FridgeDoor[] doorsCenter;
	private FridgeDoor[] doorsRight;

	static final String INVALID_DOORS_QUANTITY = "One or more quantities for left, center or right doors is invalid.";
	static final String UNABLE_TO_ADD_DOOR = "Provided door can't be added, it is invalid.";
	static final String CAPACITY_REACHED = "The capacity has been reached already, no more doors can be added.";

	public BaseFridgeDoors() {
		this(0, 1, 0);
	}

	public BaseFridgeDoors(Integer doorsLeft, Integer doorsCenter, Integer doorsRight) {
		Objects.requireNonNull(doorsLeft, INVALID_DOORS_QUANTITY);
		Objects.requireNonNull(doorsCenter, INVALID_DOORS_QUANTITY);
		Objects.requireNonNull(doorsRight, INVALID_DOORS_QUANTITY);

		boolean invalidDoorsCount = IntStream.of(doorsLeft, doorsCenter, doorsRight)
		                                     .allMatch(count -> count == 0);
		invalidDoorsCount = invalidDoorsCount || IntStream.of(doorsLeft, doorsCenter, doorsRight)
		                                                   .anyMatch(count -> count < 0);

		Optional.of(invalidDoorsCount)
		        .filter(invalid -> invalid.equals(false))
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_DOORS_QUANTITY));

		this.doorsLeft = new FridgeDoor[doorsLeft];
		this.doorsCenter = new FridgeDoor[doorsCenter];
		this.doorsRight = new FridgeDoor[doorsRight];
	}

	/**
	 * Doors are added from left to right, top to bottom. When capacity is reached, no more doors can be added.
	 *
	 * @param door the next door to be added.
	 */
	@Override
	public void addDoor(FridgeDoor door) {
		Objects.requireNonNull(door, UNABLE_TO_ADD_DOOR);
		Optional.of(hasCapacity())
		        .filter(capacity -> capacity.equals(true))
		        .orElseThrow(() -> new RuntimeException(CAPACITY_REACHED));

		Optional<FridgeDoor[]> fridgeDoors = Stream.of(doorsLeft, doorsCenter, doorsRight)
		                                           .filter(Objects::nonNull)
		                                           .filter(doors -> Arrays.stream(doors).filter(Objects::isNull).count() > 0)
		                                           .findFirst();
		int index = 0;
		while (Objects.nonNull(fridgeDoors.get()[index])) {
			index++;
		}
		fridgeDoors.get()[index] = door;
	}

	@Override
	public Boolean hasDoors() {
		return size() > 0;
	}

	@Override
	public Integer size() {
		return IntStream.of(doorsSize(doorsLeft), doorsSize(doorsCenter), doorsSize(doorsRight)).sum();
	}

	@Override
	public Integer capacity() {
		return IntStream.of(doorsCenter.length, doorsLeft.length, doorsRight.length).sum();
	}

	private Integer doorsSize(FridgeDoor[] doors) {
		Long quantity = Optional.ofNullable(doors)
		                        .map(Arrays::stream)
		                        .get()
		                        .filter(Objects::nonNull)
		                        .count();

		return quantity.intValue();
	}

	@Override
	public Iterator<FridgeDoor> iterator() {
		return new BaseFridgeDoorsIterator(buildDoorsArray());
	}

	@Override
	public void forEach(Consumer<? super FridgeDoor> action) {

	}

	@Override
	public Spliterator<FridgeDoor> spliterator() {
		return new BaseFridgeDoorsSpliterator(buildDoorsArray());
	}

	private FridgeDoor[] buildDoorsArray() {
		Stream<FridgeDoor> fridgeDoorStream = Stream.concat(Arrays.stream(doorsLeft), Arrays.stream(doorsCenter));
		fridgeDoorStream = Stream.concat(fridgeDoorStream, Arrays.stream(doorsRight));
		fridgeDoorStream = fridgeDoorStream.filter(Objects::nonNull);
		List<FridgeDoor> doors = fridgeDoorStream.collect(Collectors.toList());

		return doors.toArray(new FridgeDoor[doors.size()]);
	}
}
