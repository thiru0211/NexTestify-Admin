package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\FeatureFiles\\7_OEP_Subject.feature",
glue = "stepDefinition",
monochrome = true,
//dryRun = true,
//tags="@Test",
plugin = {"pretty",
		"html:target/cucumber/Candidate_cucumberhtml-report.html",
		"json:target/cucumber/Candidate_cucumber.json",
		"rerun:target/failedScenarios/Candidate_Failed.txt"
		})

public class OEP_7_SubjectRunnerTest {

}
