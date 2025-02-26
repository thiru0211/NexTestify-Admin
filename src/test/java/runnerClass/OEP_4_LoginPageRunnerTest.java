package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\FeatureFiles\\4_OEP_Login.feature",
glue = "stepDefinition",
monochrome = true,
//dryRun = true,
//tags="@TC_02",
plugin = {"pretty",
		"html:target/cucumber/Login Page_cucumberhtml-report.html",
		"json:target/cucumber/Login Page_cucumber.json",
		"rerun:target/failedScenarios/Login_Failed.txt"
		})
public class OEP_4_LoginPageRunnerTest {

	
}
