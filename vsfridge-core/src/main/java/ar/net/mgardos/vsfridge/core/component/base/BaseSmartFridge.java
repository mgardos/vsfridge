package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Implementation of a Smart Fridge with basic features that enables, by extension, the creation of more complex or
 * advanced fridges.
 */
public class BaseSmartFridge implements SmartFridge {
	static final String INVALID_DOORS_ARRANGE = "The provided doors arrangement for the fridge is invalid.";
	static final String INVALID_DOOR = "The provided door for the fridge is invalid.";
	static final String ASSEMBLE_DOOR_NOT_ALLOWED = "A door cannot be added when fridge turned on.";
	static final String INVALID_SHELVES_ARRANGE = "The provided shelves arrangement for the fridge is invalid.";
	static final String INVALID_SHELF = "The provided shelf for the fridge is invalid.";
	static final String NOT_READY_FOR_SENSORS = "The fridge is not initialized to hold any sensors.";
	static final String INVALID_SENSOR = "The provided sensor for the fridge is invalid.";

	private Boolean isPlugged;
	private Boolean isTurnOn;
	private FridgeDoors doors;
	private FridgeShelves shelves;

	/**
	 * Creates a fully functional smart fridge with one center door and two shelves.
	 *
	 * @throws SmartFridgeBuildException
	 */
	public BaseSmartFridge() throws SmartFridgeBuildException {
		isPlugged = false;
		isTurnOn = false;
		doors = new BaseFridgeDoors();
		shelves = new BaseFridgeShelves();

		assembleDoor(new BaseFridgeDoor());
		assembleShelf(new BaseFridgeShelf());
		assembleShelf(new BaseFridgeShelf());
	}

	/**
	 * Creates a smart fridge that accepts doors as per the provided arrangement.
	 *
	 * @param doors the arrangement of doors that defines the doors of the fridge with their corresponding layout.
	 * @throws SmartFridgeBuildException
	 */
	public BaseSmartFridge(FridgeDoors doors) throws SmartFridgeBuildException {
		Optional.ofNullable(doors)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_DOORS_ARRANGE));

		isPlugged = false;
		isTurnOn = false;
		this.doors = doors;
		shelves = new BaseFridgeShelves();

		assembleShelf(new BaseFridgeShelf());
		assembleShelf(new BaseFridgeShelf());
	}

	/**
	 * Creates a smart fridge that accepts shelves as per the provided arrangement.
	 *
	 * @param shelves the arrangement of shelves that defines the shelves of the fridge.
	 * @throws SmartFridgeBuildException
	 */
	public BaseSmartFridge(FridgeShelves shelves) throws SmartFridgeBuildException {
		Optional.ofNullable(shelves)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_SHELVES_ARRANGE));

		isPlugged = false;
		isTurnOn = false;
		doors = new BaseFridgeDoors();
		this.shelves = shelves;

		assembleDoor(new BaseFridgeDoor());
	}

	/**
	 * Creates a smart fridge that accepts doors and shelves as per the provided arrangements.
	 *
	 * @param doors the arrangement of doors that defines the doors of the fridge with their corresponding layout.
	 * @param shelves the arrangement of shelves that defines the shelves of the fridge.
	 * @throws SmartFridgeBuildException
	 */
	public BaseSmartFridge(FridgeDoors doors, FridgeShelves shelves) throws SmartFridgeBuildException {
		Optional.ofNullable(doors)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_DOORS_ARRANGE));
		Optional.ofNullable(shelves)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_SHELVES_ARRANGE));

		isPlugged = false;
		isTurnOn = false;
		this.doors = doors;
		this.shelves = shelves;
	}

	@Override
	public Boolean isPlugged() {
		return isPlugged;
	}

	@Override
	public void plugIn() {
		isPlugged = true;
	}

	@Override
	public void unplug() {
		isTurnOn = false;
		isPlugged = false;
	}

	@Override
	public Boolean isTurnedOn() {
		return isTurnOn;
	}

	@Override
	public void turnOn() {
		isTurnOn = Optional.of(isPlugged)
		                   .filter(plugged -> plugged.equals(true))
		                   .orElse(false);
	}

	@Override
	public void turnOff() {
		isTurnOn = false;
	}

    @Override
    public Boolean isOpened() {
		Boolean hasOpenedDoors = StreamSupport.stream(doors.spliterator(), false)
											  .filter(doors -> doors.isOpened())
											  .count() > 0;
        return isTurnedOn() && hasDoors() && hasOpenedDoors;
    }

    public Boolean hasDoors() {
		return doors.hasDoors();
	}

	public void assembleDoor(FridgeDoor fridgeDoor) throws SmartFridgeBuildException {
		Optional.of(isTurnOn)
		        .filter(turnOn -> turnOn.equals(false))
		        .orElseThrow(() -> new SmartFridgeBuildException(ASSEMBLE_DOOR_NOT_ALLOWED));
		FridgeDoor door = Optional.ofNullable(fridgeDoor)
		                          .orElseThrow(() -> new IllegalArgumentException(INVALID_DOOR));

		try {
			doors.addDoor(door);
		} catch (Exception e) {
			throw new SmartFridgeBuildException(e);
		}
	}

	public Boolean hasShelves() {
		return shelves.hasShelves();
	}

	public void assembleShelf(FridgeShelf fridgeShelf) throws SmartFridgeBuildException {
		Optional.ofNullable(fridgeShelf)
		        .orElseThrow(() -> new IllegalArgumentException(INVALID_SHELF));

		try {
			shelves.addShelf(fridgeShelf);
		} catch (Exception e) {
			throw new SmartFridgeBuildException(e);
		}
	}
}
