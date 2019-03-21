package ${groupId}.${artifactId}.specs;

import com.privalia.qa.specs.*;
import cucumber.api.java.en.Given;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Extending the {@link BaseGSpec} class from the bdt-lib allow us to
 * define custom step definitions for our project and at the same time
 * make use of the properties of the {@link CommonG} object
 */
public class CustomStepsDefinition extends BaseGSpec {

    GivenGSpec commonspecGiven;
    WhenGSpec commonspecWhen;
    ThenGSpec commonspecThen;
    BigDataGSpec commonspecBigData;
    SeleniumGSpec commonspecSelenium;

    /**
     * Example how to inherit the needed objects from bdt-lib
     * @param spec
     */
    public CustomStepsDefinition(CommonG spec) {

        /**
         * the CommonG object with "atomic" methods and interface to utils files
         */
        this.commonspec = spec;

        /**
         * common given gherkin steps: ssh, rest, etc
         */
        commonspecGiven = new GivenGSpec(this.commonspec);

        /**
         * common when gherkin steps: ssh, rest, etc
         */
        commonspecWhen = new WhenGSpec(this.commonspec);

        /**
         * common then gherkin steps: ssh, rest, etc
         */
        commonspecThen = new ThenGSpec(this.commonspec);

        /**
         * common BigData gherkin steps: Cassandra, MongoDB, elasticsearch, etc
         */
        commonspecBigData = new BigDataGSpec(this.commonspec);

        /**
         * new Selenium steps
         */
        commonspecSelenium = new SeleniumGSpec(this.commonspec);

    }

    /**
     * Step example. You can define your own steps that can be used in the feature files in case
     * you have a very specific use case that is not covered in the library
     */
    @Given("^I want to go to disneyland$")
    public void mytest() {
        RemoteWebDriver d = this.commonspec.getDriver();
        d.get("https://www.disney.com");
    }


}
