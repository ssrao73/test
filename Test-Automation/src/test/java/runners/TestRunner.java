package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/functionalTests",

        glue = {"stepDefinitions"},

        monochrome = true,

        strict = true

)
public class TestRunner {
}
