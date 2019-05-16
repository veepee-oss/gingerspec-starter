package ${groupId}.${artifactId}.${package};

import cucumber.api.CucumberOptions;
import org.testng.annotations.Factory;
import com.privalia.qa.data.BrowsersDataProvider;
import ${groupId}.${artifactId}.utils.BaseTest;


/**
 * This is an example of how to use custom glue files with custom steps for our application.
 * Step files can also extend {@link BaseTest} to fully access all its methods/properties
 *
 * Notice that for Selenium related runner classes, is necessary the non-default constructor
 * shown below
 */
@CucumberOptions(features =
        {
                "src/test/resources/features/$package/cucumber_selenium_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.specs")
public class CucumberSeleniumIT extends BaseTest {

    @Factory(dataProviderClass = BrowsersDataProvider.class, dataProvider = "availableUniqueBrowsers")
    public CucumberSeleniumIT(String browser) {
        this.browser = browser;
    }

}
