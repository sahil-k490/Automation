package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/appFeature/Compare.feature"},
		glue = {"stepDefinitions", "appHooks"},
		plugin = {"pretty"				
		}
		)

public class Runner {

}
