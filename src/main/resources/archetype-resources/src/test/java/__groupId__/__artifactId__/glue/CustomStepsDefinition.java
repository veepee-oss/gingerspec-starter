package ${groupId}.${artifactId}.glue;

import com.privalia.qa.specs.*;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Glue code of your applications. Use this class to create your own
 * step definitions or cucumber hooks. For more info check:
 * https://cucumber.io/docs/cucumber/step-definitions/
 * https://cucumber.io/docs/cucumber/api/#hooks
 *
 * For more info on how to create your own steps, you can check:
 * https://github.com/veepee-oss/gingerspec/wiki/Creating-your-own-steps
 */
public class CustomStepsDefinition extends BaseGSpec {

    SeleniumGSpec seleniumGSpec;
    RestSpec restSpec;

    /**
     * Example of how to inherit the needed objects from GingerSpec.
     * @param spec the CommonGSpec class
     */
    public CustomStepsDefinition(CommonG spec) {

        this.commonspec = spec;

        /* Access all functions for working with selenium */
        seleniumGSpec = new SeleniumGSpec(this.commonspec);

        /* Access all functions for working with REST services */
        restSpec = new RestSpec(this.commonspec);
    }

    /**
     * This is an example of how to create your own selenium steps. For more info check
     * https://github.com/veepee-oss/gingerspec/wiki/Creating-your-own-steps#selenium-example
     * @throws Throwable    Throwable
     */
    @Given("^Fill the form and click the submit button$")
    public void myCustomSeleniumStep() throws InterruptedException {
        /* Get access to the selenium driver instance like this */
        WebDriver driver = this.commonspec.getDriver();

        /* Use regular selenium functions and APIs */
        driver.get("http://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("John");
        driver.findElement(By.id("userEmail")).sendKeys("john.smith@email.com");

        /* You can mix your own java code with the GingerSpec functions from SeleniumGSpec ;) */
        seleniumGSpec.scrollUntilElementVisibleByLocator("down","id","submit",null);
        driver.findElement(By.id("submit")).click();
    }

    /**
     * This is an example of how to create your own REST steps. You can directly use
     * REST-Assured for this (https://rest-assured.io/). For more information, check
     * https://github.com/veepee-oss/gingerspec/wiki/Creating-your-own-steps#rest-api-example
     */
    @Given("^I verify that a successful response with a valid body is returned$")
    public void myCustomRestStep() {
        RestAssured.given().contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com:443/posts")
                .then()
                .statusCode(200);
    }
}