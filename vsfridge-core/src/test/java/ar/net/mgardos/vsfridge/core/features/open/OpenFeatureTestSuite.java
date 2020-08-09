package ar.net.mgardos.vsfridge.core.features.open;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/open_fridge_door.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.open"},
		plugin={"pretty"}, monochrome = true)
public class OpenFeatureTestSuite {
}
