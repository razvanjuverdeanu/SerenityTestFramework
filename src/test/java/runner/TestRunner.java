package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/java/resources/test.feature"}, glue = {"stepsDefinition"},
        plugin = {"pretty", "html:target/cucumber", "junit:target/junit-results.xml", "summary"}
)

public class TestRunner {

}
