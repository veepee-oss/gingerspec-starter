package ${groupId}.${artifactId}.${package};

import com.privalia.qa.cucumber.testng.CucumberRunner;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;
import ${groupId}.${artifactId}.utils.BaseTest;



/**
 * This is an example on how to call an specific feature to be executed.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 */
@CucumberOptions(format = "json:target/CucumberBackendIT.json", features =
        {
                "src/test/resources/features/$package/cucumber_backend_test.feature"
        },
        glue = "classpath:${groupId}.${artifactId}.${package}.specs")
public class CucumberBackendIT extends BaseTest {

    @Test(enabled = true)
    public void runSmokeTests() throws Exception {
        new CucumberRunner(this.getClass()).runCukes();
    }

}
