package com.privalia.${artifactId}.${package};

import com.privalia.qa.cucumber.testng.CucumberRunner;
import com.privalia.qa.utils.BaseGTest;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;

/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 */

@CucumberOptions(format = "json:target/CucumberRestIT.json", features =
        {
                "src/test/resources/features/$artifactId/$package/cucumber_rest_test.feature"
        },
        glue = "classpath:com/privalia/$artifactId/specs")
public class CucumberRestIT extends BaseGTest {

    @Test(enabled = true)
    public void runSmokeTests() throws Exception {
        new CucumberRunner(this.getClass()).runCukes();
    }

}
