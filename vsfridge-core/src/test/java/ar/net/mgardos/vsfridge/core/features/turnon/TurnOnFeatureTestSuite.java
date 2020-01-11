package ar.net.mgardos.vsfridge.core.features.turnon;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/turn_on_fridge.feature"},
    glue = {"ar.net.mgardos.vsfridge.core.features.turnon"},
    plugin={"pretty"}, monochrome = true)
public class TurnOnFeatureTestSuite {}
