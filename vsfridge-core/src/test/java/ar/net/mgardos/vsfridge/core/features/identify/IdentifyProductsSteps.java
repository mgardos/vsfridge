package ar.net.mgardos.vsfridge.core.features.identify;

import cucumber.api.java.en.*;

public class IdentifyProductsSteps {
	@Given("^the fridge door is closed$")
	public void closeFridgeDoor() {

	}

	@And("^the fridge records product detection is needed$")
	public void scheduleProductDetection() {

	}

	@When("^the fridge starts product detection$")
	public void startProductDetection() {

	}

	@Then("^the fridge notifies the user product detection is started$")
	public void notifyProductDetectionStarted() {

	}

	@And("^the fridge scans the products inside$")
	public void scanProductsInside() {

	}

	@Then("^the fridge identifies (?:all|some) products as groceries$")
	public void identifyProducts() {

	}

	@But("^other products are left unidentified$")
	public void leaveProductsUnidentified() {

	}

	@Then("^the fridge records the groceries detected$")
	public void recordDetectedGroceries() {

	}

	@And("^stores pictures of unidentified products for manual identification$")
	public void storeUnidentifiedProducts() {

	}

	@Then("^the user opens the fridge door$")
	public void openFridgeDoor() {

	}

	@And("^the fridge stops the product detection$")
	public void stopProductDetection() {

	}

	@And("^the use case CU_AR is invoked$")
	public void invokeUseCase() {

	}

	@Then("^the fridge does not identify groceries inside$")
	public void emptyFridge() {

	}

	@And("^the fridge records no groceries inside$")
	public void recordEmptyFridge() {

	}
}
