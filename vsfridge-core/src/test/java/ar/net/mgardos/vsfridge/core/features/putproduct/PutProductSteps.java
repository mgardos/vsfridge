package ar.net.mgardos.vsfridge.core.features.putproduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PutProductSteps {
	@Given("^the use case (CU_AR|CU_CR) (?:executed successfully|is invoked)$")
	public void invokeUseCase(String useCaseCode) {

	}

	@When("^the user puts (?:a|another) product inside the fridge$")
	public void putProductInsideFridge() {

	}

	@Then("^the fridge detects an object was put inside$")
	public void detectObjectInside() {

	}

	@And("^the fridge records product detection is needed$")
	public void scheduleProductDetection() {

	}

	@Then("^the user closes the fridge door$")
	public void closeFridgeDoor() {

	}
}
