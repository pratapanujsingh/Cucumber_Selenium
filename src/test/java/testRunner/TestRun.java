package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//features/",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:target/report.html", "pretty", "junit:target/report.xml",
                "pretty", "json:target/report.json"},
        tags= "@SmokeTest"
)



public class TestRun {
}
