package ${groupId}.${artifactId}.runners;

import io.cucumber.testng.CucumberOptions;
import ${groupId}.${artifactId}.utils.BaseTest;


/**
 * This is the runner class responsible of running the included *.feature files in the project.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * Also check out the {@link BaseTest} class, there you can create TestNG hooks and more :)
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
