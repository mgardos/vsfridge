package ar.net.mgardos.vsfridge.core.features.identify;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/identify_products.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.identify"},
		plugin={"pretty"}, monochrome = true)
public class IdentifyProductsFeatureTestSuite {
}
