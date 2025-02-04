package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\5_OEP_ADMIN.feature",
glue = "stepDefinition",
monochrome = true,
//dryRun = true,
//tags="@TC_44",
plugin = {"pretty",
		"html:target/cucumber/Admin_cucumberhtml-report.html",
		"json:target/cucumber/Admin_cucumber.json"
		})

public class OEP_5_AdminRunnerTest {

}
