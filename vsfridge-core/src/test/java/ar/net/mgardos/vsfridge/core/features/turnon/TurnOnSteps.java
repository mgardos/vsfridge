package ar.net.mgardos.vsfridge.core.features.turnon;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeDoors;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import ar.net.mgardos.vsfridge.core.component.base.BaseFridgeDoor;
import ar.net.mgardos.vsfridge.core.component.base.BaseFridgeDoors;
import ar.net.mgardos.vsfridge.core.component.base.BaseSmartFridge;
import io.cucumber.java.en.*;

import java.util.Optional;

public class TurnOnSteps {
	private SmartFridge smartFridge;
	private FridgeDoor door1;
	private FridgeDoor door2;

	@Given("^the fridge is plugged to the electrical currency$")
	public void createFridgeAndCheckIfPlugged() throws Exception {
		door1 = new BaseFridgeDoor();
		door2 = new BaseFridgeDoor();

		FridgeDoors doors = new BaseFridgeDoors(1, 1, 0);
		doors.addDoor(door1);
		doors.addDoor(door2);

		smartFridge = new BaseSmartFridge(doors);
		smartFridge.plugIn();

		Optional.of(smartFridge.isPlugged())
				.filter(plugged -> plugged.equals(true))
				.orElseThrow();
	}

	@And("^the fridge is turned off$")
	public void checkFridgeTurnOff() {
		Optional.ofNullable(smartFridge)
				.filter(fridge -> fridge.isTurnedOn().equals(false))
				.orElseThrow();
	}

	@When("^the user turns on the fridge$")
	public void turnOnFridge() {
		Optional.ofNullable(smartFridge)
				.orElseThrow()
				.turnOn();
	}

	@Then("^the fridge initializes$")
	public void initializeFridge() {

	}

	@And("^the fridge is ready$")
	public void checkAnyFridgeDoorIsClosed() {
		Optional.ofNullable(smartFridge)
				.filter(fridge -> fridge.isOpened().equals(false))
				.orElseThrow();
	}

	@But("^the fridge detects its door opened$")
	public void openFridgeDoor() {
		door2.open();
	}

	@Then("^the use case CU_CR is invoked$")
	public void invokeUseCase() {
		Optional.ofNullable(smartFridge)
				.filter(fridge -> fridge.isOpened())
				.orElseThrow();
	}
}
