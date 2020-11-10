package ${groupId}.${artifactId}.runners;

import cucumber.api.CucumberOptions;
import org.testng.annotations.Factory;
import com.privalia.qa.data.BrowsersDataProvider;
import ${groupId}.${artifactId}.utils.BaseTest;


/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * Notice that this class contains an special constructor. This constructor
 * is necessary if you want to execute your selenium features against a selenium
 * Gird/Node. For more information on how to do this, check the instructions here:
 * https://github.com/vpTechOSS/gingerspec/wiki/Running-Selenium-tests
 *
 */
@CucumberOptions(plugin = {
                "json:target/CucumberSeleniumIT.json",
                "html:target/CucumberSeleniumIT",
                "junit:target/CucumberSeleniumIT.xml"
        }, features =
        {
                "src/test/resources/features/cucumber_selenium_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.glue")
public class CucumberSeleniumIT extends BaseTest {

    @Factory(dataProviderClass = BrowsersDataProvider.class, dataProvider = "availableUniqueBrowsers")
    public CucumberSeleniumIT(String browser) {
        this.browser = browser;
    }

}
