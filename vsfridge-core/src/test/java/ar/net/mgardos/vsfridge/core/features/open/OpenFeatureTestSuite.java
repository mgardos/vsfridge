package ar.net.mgardos.vsfridge.core.features.open;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/open_fridge_door.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.open"},
		plugin={"pretty"}, monochrome = true)
public class OpenFeatureTestSuite {
}
