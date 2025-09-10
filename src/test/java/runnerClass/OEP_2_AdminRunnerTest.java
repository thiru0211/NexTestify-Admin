package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\FeatureFiles\\2_OEP_ADMIN.feature",
glue = "stepDefinition",
monochrome = true,
//dryRun = true,
//tags="@TC_02",
plugin = {"pretty",
		"html:target/cucumber/Admin_cucumberhtml-report.html",
		"json:target/cucumber/Admin_cucumber.json",
		"rerun:target/failedScenarios/Admin_Failed.txt"
		})

public class OEP_2_AdminRunnerTest {

}
