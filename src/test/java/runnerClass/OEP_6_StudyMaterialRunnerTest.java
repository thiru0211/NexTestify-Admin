package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\6_OEP_StudyMaterial.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@TC_27",
		plugin = {"pretty",
			"html:target/cucumber/Study Material_cucumberhtml-report.html",
			"json:target/cucumber/Study Material_cucumber.json",
			"rerun:target/failedScenarios/StudyMaterial_Failed.txt"
				})
public class OEP_6_StudyMaterialRunnerTest {

}
