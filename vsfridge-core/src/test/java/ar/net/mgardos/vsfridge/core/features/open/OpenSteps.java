package ar.net.mgardos.vsfridge.core.features.open;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeDoors;
import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import ar.net.mgardos.vsfridge.core.component.base.BaseFridgeDoor;
import ar.net.mgardos.vsfridge.core.component.base.BaseFridgeDoors;
import ar.net.mgardos.vsfridge.core.component.base.BaseSmartFridge;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Optional;

public class OpenSteps {
	private SmartFridge smartFridge;
	private FridgeDoor door1;
	private FridgeDoor door2;
	private FridgeDoor door3;

	@Given("^the fridge is turn on$")
	public void createFridgePlugAndTurnOn() throws Exception {
		door1 = new BaseFridgeDoor();
		door2 = new BaseFridgeDoor();
		door3 = new BaseFridgeDoor();

		FridgeDoors doors = new BaseFridgeDoors(1, 1, 1);
		doors.addDoor(door1);
		doors.addDoor(door2);
		doors.addDoor(door3);

		smartFridge = new BaseSmartFridge(doors);
		smartFridge.plugIn();
		smartFridge.turnOn();
	}

	@And("(^the fridge door is closed$|^the user closes the fridge door$)")
	public void checkFridgeDoorsAllClosed() {
		Optional.ofNullable(smartFridge)
				.filter(fridge -> fridge.isTurnedOn().equals(true))
				.filter(fridge -> fridge.isOpened().equals(false))
				.orElseThrow();
	}

	@When("^the user opens a fridge door$")
	public void openFridgeDoor() {
		door2.open();

		Optional.ofNullable(smartFridge)
				.filter(fridge -> fridge.isOpened().equals(true))
				.orElseThrow();
	}

	@Then("^the fridge increments the counter for door opened$")
	public void incrementFridgeDoorOpenedCounter() {

	}

	@And("^the fridge starts the timer for door opened$")
	public void startFridgeDoorOpenedTimer() {

	}

	@When("^the user puts a product inside the fridge$")
	public void putProductInsideFridge() {

	}

	@When("^the user takes a product from inside the fridge$")
	public void takeProductFromInsideFridge() {

	}

	@Then("^the use case (CU_CR|CU_PP|CU_TP) is invoked$")
	public void invokeUseCase(String useCaseCode) {

	}
}
