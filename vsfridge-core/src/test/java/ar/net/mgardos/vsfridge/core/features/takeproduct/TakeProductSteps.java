package ar.net.mgardos.vsfridge.core.features.takeproduct;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TakeProductSteps {
	@Given("^the use case (CU_AR|CU_CR) (?:executed successfully|is invoked)$")
	public void invokeUseCase(String useCaseCode) {

	}

	@When("^the user takes (?:a|another) product from inside the fridge$")
	public void putProductInsideFridge() {

	}

	@Then("^the fridge detects an object was taken from inside$")
	public void detectObjectInside() {

	}

	@And("^the fridge records object detection is needed$")
	public void scheduleProductDetection() {

	}

	@Then("^the user closes the fridge door$")
	public void closeFridgeDoor() {

	}
}
