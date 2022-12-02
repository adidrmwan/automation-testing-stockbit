import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        strict = true,
        plugin = {"json:build/cucumber.json", "pretty", "html:build/result"},
        features = "src/test/resources/features",
        glue = {"test.automation"},
        tags = {""}
)
public class CucumberRunner {
}
