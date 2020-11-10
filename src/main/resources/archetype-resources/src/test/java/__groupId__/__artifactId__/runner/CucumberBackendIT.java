package ${groupId}.${artifactId}.runner;

import cucumber.api.CucumberOptions;
import ${groupId}.${artifactId}.hooks.BaseTest;


/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * You can specify more than one feature file, or even a folder containing
 * features
 */
@CucumberOptions(plugin = {
                "json:target/CucumberBackendIT.json",
                "html:target/CucumberBackendIT",
                "junit:target/CucumberBackendIT.xml"
        }, features =
        {
                "src/test/resources/features/cucumber_backend_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.glue")
public class CucumberBackendIT extends BaseTest {


}
