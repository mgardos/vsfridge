package ar.net.mgardos.vsfridge.core.features.close;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/close_fridge_door.feature"},
		glue = {"ar.net.mgardos.vsfridge.core.features.close"},
		plugin={"pretty"}, monochrome = true)
public class CloseFeatureTestSuite {
}
