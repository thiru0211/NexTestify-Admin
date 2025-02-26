package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\2_OEP_QuestionManager.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@TC_75",
		plugin = {"pretty",
			"html:target/cucumber/Question Manager_cucumberhtml-report.html",
			"json:target/cucumber/Question Manager_cucumber.json",
			"rerun:target/failedScenarios/QuestionManager_Failed.txt"
				})
public class OEP_2_QuestionManagerRunnerTest {

	
}
