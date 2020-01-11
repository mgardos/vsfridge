package ar.net.mgardos.vsfridge.core.features.putproduct;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/put_product.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.putproduct"},
		plugin={"pretty"}, monochrome = true)
public class PutProductFeatureTestSuite {
}
