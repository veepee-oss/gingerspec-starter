package ${groupId}.${artifactId}.runners;

import io.cucumber.testng.CucumberOptions;
import ${groupId}.${artifactId}.utils.BaseTest;


/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * Check out the utils.BaseTest class, there you can create TestNG hooks
 * and more :)
 */
@CucumberOptions(plugin = {
                "json:target/CucumberRunnerIT.json",
                "html:target/CucumberRunnerIT.html",
                "junit:target/CucumberRunnerIT.xml"
        }, features =
        {
                "src/test/resources/features"
        },
        glue = "classpath:${groupId}.${artifactId}.glue")
public class CucumberRunnerIT extends BaseTest {


}
