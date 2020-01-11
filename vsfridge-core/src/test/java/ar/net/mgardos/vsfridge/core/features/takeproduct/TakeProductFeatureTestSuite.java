package ar.net.mgardos.vsfridge.core.features.takeproduct;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/take_product.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.takeproduct"},
		plugin={"pretty"}, monochrome = true)
public class TakeProductFeatureTestSuite {
}
