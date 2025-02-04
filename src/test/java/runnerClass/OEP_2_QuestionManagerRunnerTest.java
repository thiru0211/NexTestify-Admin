package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\2_OEP_QuestionManager.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@Test",
		plugin = {"pretty",
			"html:target/cucumber/Question Manager_cucumberhtml-report.html",
			"json:target/cucumber/Question Manager_cucumber.json"
				})
public class OEP_2_QuestionManagerRunnerTest {

	
}
