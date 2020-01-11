package ar.net.mgardos.vsfridge.core.features.open;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenSteps {
	@Given("^the fridge is turn on$")
	public void turnOnFridge() {

	}

	@And("(^the fridge door is closed$|^the user closes the fridge door$)")
	public void closeFridgeDoor() {

	}

	@When("^the user opens the fridge door$")
	public void openFridgeDoor() {

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
