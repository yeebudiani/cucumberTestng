package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "./src/test/resources/awesomecucumber",
        glue = {"awesomecucumber"},
        plugin = {"pretty","html:target/cucumber/cucumber.html","summary"}
        //snippets = CAMELCASE
        // monochrome = true,
        // dryRun = true,
        // tags=""
)

public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
