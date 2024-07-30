package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/Features", // Path to feature files
	    glue = "StepDefinitions", // Package where step definitions are located
	    plugin = {"pretty", "html:target/cucumber-reports"}, // Report format
	    monochrome = true, // Make console output readable
	    tags = "@PracticeTestAutomation")
public class TestRunner {

}
