package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\3_OEP_StudyMaterial.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@TC_20",
		plugin = {"pretty",
			"html:target/cucumber/Study Material_cucumberhtml-report.html",
			"json:target/cucumber/Study Material_cucumber.json"
				})
public class OEP_3_StudyMaterialRunnerTest {

	
}
