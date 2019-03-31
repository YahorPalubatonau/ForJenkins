import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import pageObjects.AbstractPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        tags={"@Egor"})
public abstract class RunnerTest extends AbstractPage {


}