import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:results/cucumber", "junit:results/cucumber.xml"},
        features = "src/test/resources/features"
)
public class Runner {
}
