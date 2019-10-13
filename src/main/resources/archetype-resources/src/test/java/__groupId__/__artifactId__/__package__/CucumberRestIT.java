package ${groupId}.${artifactId}.${package};

import cucumber.api.CucumberOptions;
import ${groupId}.${artifactId}.utils.BaseTest;


/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 */
@CucumberOptions(plugin = {
                "json:target/CucumberRestIT.json",
                "html:target/CucumberRestIT"
        }, features =
        {
                "src/test/resources/features/$package/cucumber_rest_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.specs")
public class CucumberRestIT extends BaseTest {

}
