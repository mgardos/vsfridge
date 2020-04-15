package ar.net.mgardos.vsfridge.core.features.takeproduct;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/take_product.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.takeproduct"},
		plugin={"pretty"}, monochrome = true)
public class TakeProductFeatureTestSuite {
}
