package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeDoors;
import ar.net.mgardos.vsfridge.core.component.FridgeShelves;
import ar.net.mgardos.vsfridge.core.component.SmartFridgeBuildException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ar.net.mgardos.vsfridge.core.component.base.BaseSmartFridge.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseSmartFridgeTest {
	private BaseSmartFridge smartFridge;

	@Test
	public void testCreateFridgeUnpluggedAndTurnedOff() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
	}

	@Test
	public void testFridgeTurnedOffAfterPluggedIn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();

		assertThat(smartFridge.isPlugged()).isTrue();
		assertThat(smartFridge.isTurnedOn()).isFalse();
	}

	@Test
	public void testFridgeTurnedOnAfterTurnOn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();
		smartFridge.turnOn();

		assertThat(smartFridge.isPlugged()).isTrue();
		assertThat(smartFridge.isTurnedOn()).isTrue();
	}

	@Test
	public void testFridgeTurnedOffAfterTurnOff() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();
		smartFridge.turnOn();
		smartFridge.turnOff();

		assertThat(smartFridge.isPlugged()).isTrue();
		assertThat(smartFridge.isTurnedOn()).isFalse();
	}

	@Test
	public void testFridgeUnplugAfterPlugIn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();
		Boolean pluggedBeforeUnplug = smartFridge.isPlugged();
		smartFridge.unplug();

		assertThat(pluggedBeforeUnplug).isTrue();
		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
	}

	@Test
	public void testFridgeNotTurnedOnBeforePlugIn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.turnOn();

		assertThat(smartFridge.isTurnedOn()).isFalse();
	}

	@Test
	public void testNewFridgeHasDoors() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThat(smartFridge.hasDoors()).isTrue();
	}

	@Test
	public void testAssembleDoorWithInvalidDoor() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThatThrownBy(() -> smartFridge.assembleDoor(null))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(BaseSmartFridge.INVALID_DOOR);
	}

	@Test
	public void testAssembleDoorNotAllowedWhenFridgeTurnedOn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();
		smartFridge.turnOn();

		assertThatThrownBy(() -> smartFridge.assembleDoor(new BaseFridgeDoor()))
				.isInstanceOf(SmartFridgeBuildException.class)
				.hasMessage(ASSEMBLE_DOOR_NOT_ALLOWED);
	}

	@Test
	public void testAssembleDoorJustFails() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();
		smartFridge.turnOn();

		assertThatThrownBy(() -> smartFridge.assembleDoor(new BaseFridgeDoor()))
				.isInstanceOf(SmartFridgeBuildException.class);
	}

	@Test
	public void testNewFridgeWithInvalidCustomDoors() {
		FridgeDoors doors = null;

		assertThatThrownBy(() -> new BaseSmartFridge(doors)).isInstanceOf(IllegalArgumentException.class)
		                                                   .hasMessage(INVALID_DOORS_ARRANGE);
	}

	@Test
	public void testNewFridgeWithCustomDoors() throws Exception {
		FridgeDoors doors = new BaseFridgeDoors(1, 1, 1);
		smartFridge = new BaseSmartFridge(doors);

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasDoors()).isFalse();
	}

	@Test
	public void testAssembleTwoDoors() throws Exception {
		FridgeDoors doors = new BaseFridgeDoors(1, 1, 1);
		smartFridge = new BaseSmartFridge(doors);
		smartFridge.assembleDoor(new BaseFridgeDoor());
		smartFridge.assembleDoor(new BaseFridgeDoor());

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasDoors()).isTrue();
	}

	@Test
	public void testAssembleMoreDoorsThanSupported() throws Exception {
		FridgeDoors doors = new BaseFridgeDoors(0, 0, 1);
		smartFridge = new BaseSmartFridge(doors);
		smartFridge.assembleDoor(new BaseFridgeDoor());

		assertThatThrownBy(() -> smartFridge.assembleDoor(new BaseFridgeDoor()))
				.isInstanceOf(SmartFridgeBuildException.class);
	}

	@Test
	public void testNewFridgeHasShelves() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThat(smartFridge.hasShelves()).isTrue();
	}

	@Test
	public void testNewFridgeWithInvalidCustomShelves() {
		BaseFridgeShelves shelves = null;

		assertThatThrownBy(() -> new BaseSmartFridge(shelves)).isInstanceOf(IllegalArgumentException.class)
		                                                      .hasMessage(INVALID_SHELVES_ARRANGE);
	}

	@Test
	public void testFridgeAssembledWithInvalidShelf() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThatThrownBy(() -> smartFridge.assembleShelf(null))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(BaseSmartFridge.INVALID_SHELF);
	}

	@Test
	public void testAssembledShelvesJustFails() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThatThrownBy(() -> smartFridge.assembleShelf(new BaseFridgeShelf()))
				.isInstanceOf(SmartFridgeBuildException.class);
	}

	@Test
	public void testNewFridgeWithCustomShelves() throws Exception {
		FridgeShelves shelves = new BaseFridgeShelves(1);
		smartFridge = new BaseSmartFridge(shelves);

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasShelves()).isFalse();
	}

	@Test
	public void testAssembledMoreShelvesThanSupported() throws Exception {
		FridgeShelves shelves = new BaseFridgeShelves(3);
		smartFridge = new BaseSmartFridge(shelves);
		smartFridge.assembleShelf(new BaseFridgeShelf());
		smartFridge.assembleShelf(new BaseFridgeShelf());
		smartFridge.assembleShelf(new BaseFridgeShelf());

		assertThatThrownBy(() -> smartFridge.assembleShelf(new BaseFridgeShelf()))
				.isInstanceOf(SmartFridgeBuildException.class);
	}

	@Test
	public void testAssembledTwoShelves() throws Exception {
		FridgeShelves shelves = new BaseFridgeShelves(2);
		smartFridge = new BaseSmartFridge(shelves);
		smartFridge.assembleShelf(new BaseFridgeShelf());
		smartFridge.assembleShelf(new BaseFridgeShelf());

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasShelves()).isTrue();
	}

	@Test
	public void testNewFridgeWithDefaultDoorsAndCustomShelves() throws Exception {
		FridgeShelves shelves = new BaseFridgeShelves(1);
		smartFridge = new BaseSmartFridge(shelves);

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasDoors()).isTrue();
		assertThat(smartFridge.hasShelves()).isFalse();
	}

	@Test
	public void testNewFridgeWithCustomDoorsAndDefaultShelves() throws Exception {
		FridgeDoors doors = new BaseFridgeDoors(1, 0, 1);
		smartFridge = new BaseSmartFridge(doors);

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasDoors()).isFalse();
		assertThat(smartFridge.hasShelves()).isTrue();
	}

	@Test
	public void testNewFridgeWithCustomDoorsAndShelves() throws Exception {
		FridgeDoors doors = new BaseFridgeDoors(1, 0, 1);
		FridgeShelves shelves = new BaseFridgeShelves(1);
		smartFridge = new BaseSmartFridge(doors, shelves);

		assertThat(smartFridge.isPlugged()).isFalse();
		assertThat(smartFridge.isTurnedOn()).isFalse();
		assertThat(smartFridge.hasDoors()).isFalse();
		assertThat(smartFridge.hasShelves()).isFalse();
	}

	@Test
	public void testNewFridgeWithInvalidCustomDoorsAndValidCustomShelves() {
		FridgeShelves shelves = new BaseFridgeShelves(1);

		assertThatThrownBy(() -> new BaseSmartFridge(null, shelves))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(INVALID_DOORS_ARRANGE);
	}

	@Test
	public void testNewFridgeWithValidCustomDoorsAndInvalidCustomShelves() {
		FridgeDoors doors = new BaseFridgeDoors(1, 0, 0);

		assertThatThrownBy(() -> new BaseSmartFridge(doors, null))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(INVALID_SHELVES_ARRANGE);
	}

	@Test
	public void testNewFridgeInformClosedDoors() throws Exception {
		smartFridge = new BaseSmartFridge();

		assertThat(smartFridge.isOpened()).isFalse();
	}

	@Test
	public void testFridgeInformClosedDoorsBeforeTurnOn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();

		assertThat(smartFridge.isOpened()).isFalse();
	}

	@Test
	public void testFridgeInformClosedDoorsAfterTurnOn() throws Exception {
		smartFridge = new BaseSmartFridge();
		smartFridge.plugIn();
		smartFridge.turnOn();

		assertThat(smartFridge.isOpened()).isFalse();
	}

	@Test
	public void testFridgeInformClosedDoors() throws Exception {
		FridgeDoor door1 = new BaseFridgeDoor();
		FridgeDoor door2 = new BaseFridgeDoor();

		FridgeDoors doors = new BaseFridgeDoors(1, 0, 1);
		smartFridge = new BaseSmartFridge(doors);
		smartFridge.assembleDoor(door1);
		smartFridge.assembleDoor(door2);

		smartFridge.plugIn();
		smartFridge.turnOn();

		assertThat(smartFridge.isOpened()).isFalse();
		assertThat(door1.isOpened()).isFalse();
		assertThat(door2.isOpened()).isFalse();
	}

	@Test
	public void testFridgeInformOpenedDoorsAfterTurnOn() throws Exception {
		FridgeDoor door1 = new BaseFridgeDoor();
		door1.open();
		FridgeDoor door2 = new BaseFridgeDoor();

		FridgeDoors doors = new BaseFridgeDoors(1, 0, 1);
		smartFridge = new BaseSmartFridge(doors);
		smartFridge.assembleDoor(door1);
		smartFridge.assembleDoor(door2);

		smartFridge.plugIn();
		smartFridge.turnOn();

		assertThat(smartFridge.isOpened()).isTrue();
		assertThat(door1.isOpened()).isTrue();
		assertThat(door2.isOpened()).isFalse();
	}
}