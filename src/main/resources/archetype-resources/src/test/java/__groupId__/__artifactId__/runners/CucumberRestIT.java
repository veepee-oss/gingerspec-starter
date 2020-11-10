package ${groupId}.${artifactId}.runners;

import cucumber.api.CucumberOptions;
import ${groupId}.${artifactId}.utils.BaseTest;


/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * You can specify more than one feature file, or even a folder containing
 * features
 */
@CucumberOptions(plugin = {
                "json:target/CucumberRestIT.json",
                "html:target/CucumberRestIT",
                "junit:target/CucumberRestIT.xml"
        }, features =
        {
                "src/test/resources/features/cucumber_rest_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.glue")
public class CucumberRestIT extends BaseTest {

}
