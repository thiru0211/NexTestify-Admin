package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="target/failedScenarios/*.txt",
glue = "stepDefinition",
monochrome = true,
plugin = {"pretty",
		"html:target/cucumber/Admin_cucumberhtml-report.html",
		"json:target/cucumber/Admin_cucumber.json"
		})

public class OEP_9_RerunFailedScenarios {

}
