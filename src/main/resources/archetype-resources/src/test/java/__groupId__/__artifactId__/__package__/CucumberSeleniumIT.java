package ${groupId}.${artifactId}.${package};

import com.privalia.qa.cucumber.testng.CucumberRunner;
import com.privalia.qa.data.BrowsersDataProvider;
import ${groupId}.${artifactId}.utils.BaseTest;

import cucumber.api.CucumberOptions;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * This is an example of how to use custom glue files with custom steps for our application.
 * Step files can also extend {@link BaseTest} to fully access all its methods/properties
 *
 * Notice that for Selenium related runner classes, is necessary the non-default constructor
 * shown below
 */
@CucumberOptions(format = "json:target/CucumberSeleniumIT.json", features =
        {
                "src/test/resources/features/$package/cucumber_selenium_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.${package}.specs")
public class CucumberSeleniumIT extends BaseTest {

    @Factory(dataProviderClass = BrowsersDataProvider.class, dataProvider = "availableUniqueBrowsers")
    public CucumberSeleniumIT(String browser) {
        this.browser = browser;
    }

    @Test(enabled = true)
    public void runSmokeTests() throws Exception {
        new CucumberRunner(this.getClass()).runCukes();
    }
}
