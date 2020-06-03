package ${groupId}.${artifactId}.specs;

import com.privalia.qa.specs.*;
import com.privalia.qa.utils.ThreadProperty;
import cucumber.api.java.en.Given;

/**
 * Extending the {@link BaseGSpec} class from the gingerspec allow us to
 * define custom step definitions for our project and at the same time
 * make use of the properties of the {@link CommonG} object
 *
 * Check out the javadoc for a full description of all the methods in each class:
 * https://privaliatech.github.io/gingerspec/com/privalia/qa/specs/package-summary.html
 */
public class CustomStepsDefinition extends BaseGSpec {

    SeleniumGSpec seleniumGSpec;
    RestSpec restSpec;
    SqlDatabaseGSpec sqlDatabaseGSpec;
    BigDataGSpec bigDataGSpec;
    FileParserGSpec fileParserGSpec;
    KafkaGSpec kafkaGSpec;
    SoapServiceGSpec soapServiceGSpec;
    SshGSpec sshGSpec;
    UtilsGSpec utilsGSpec;

    /**
     * Example of how to inherit the needed objects from gingerspec
     * @param spec
     */
    public CustomStepsDefinition(CommonG spec) {

        this.commonspec = spec;

        /* Access all functions for working with selenium */
        seleniumGSpec = new SeleniumGSpec(this.commonspec);

        /* Access all functions for working with REST services */
        restSpec = new RestSpec(this.commonspec);

        /* Access all functions for working with relational databases */
        sqlDatabaseGSpec = new SqlDatabaseGSpec(this.commonspec);

        /* Access all functions for working with Big data functionality */
        bigDataGSpec = new BigDataGSpec(this.commonspec);

        /* Access all functions for handling and parsing text files */
        fileParserGSpec = new FileParserGSpec(this.commonspec);

        /* Access all functions for working with kafka */
        kafkaGSpec = new KafkaGSpec(this.commonspec);

        /* Access all functions for working with SOAP web services */
        soapServiceGSpec = new SoapServiceGSpec(this.commonspec);

        /* Access all functions for running bash commands and establishing SSH connections */
        sshGSpec = new SshGSpec(this.commonspec);

        /* Access all other useful functions/operations */
        utilsGSpec = new UtilsGSpec(this.commonspec);

    }


    /**
     * This is an example of a custom step. You can merge several gingerspec steps into a
     * higher-level step just by calling the underlying functions.
     *
     * To help you with this, execute your tests with -DSHOW_STACK_INFO. This will provide you with information
     * about what functions of gingerspec are being called and with what arguments
     *
     * Check all the available methods/steps in the corresponding javadoc class
     * https://privaliatech.github.io/gingerspec/com/privalia/qa/specs/SeleniumGSpec.html
     *
     * @throws Throwable    Throwable
     */
    @Given("^Fill the form and click the submit button$")
    public void fillTheFormAndClickSubmitButton() throws Throwable {
        seleniumGSpec.iGoToUrl("http://demoqa.com/text-box");
        seleniumGSpec.seleniumTypeByLocator("John", "id", "userName", null);
        seleniumGSpec.seleniumTypeByLocator("john.smith@email.com", "id", "userEmail", null);
        seleniumGSpec.seleniumTypeByLocator("123 fake address", "id", "currentAddress", null);
        seleniumGSpec.scrollUntilElementVisibleByLocator("down","id","submit",null);
        seleniumGSpec.seleniumClickByLocator("id","submit",null);
        seleniumGSpec.assertSeleniumNElementExists(" at least",1,"id","output");
    }

    /**
     * This is an example of a custom step. You can merge several gingerspec steps into a
     * higher-level step just by calling the underlying functions.
     *
     * to access variables !{myvar} use this.commonspec.getVariable("!{myvar}")
     * to access variables ${myvar} use this.commonspec.getVariable("${myvar}")
     * to access variables @{myvar} use this.commonspec.getVariable("@{myvar}")
     * to access variables #{myvar} use this.commonspec.getVariable("#{myvar}")
     *
     * @throws Throwable    Throwable
     */
    @Given("^I verify that a successful response with a valid body is returned$")
    public void iVerifyThatASuccessfulResponseWithAValidBodyIsReturned() throws Throwable {
        restSpec.setupApp("securely","jsonplaceholder.typicode.com:443");
        restSpec.sendRequestNoDataTable("GET","/posts",null,null,null);
        restSpec.assertResponseStatusLength(200,null);
        restSpec.saveElementEnvironment(null,"$.[0].userId","USER_ID");
        utilsGSpec.checkValue(ThreadProperty.get("USER_ID"),"matches","1");
    }
}