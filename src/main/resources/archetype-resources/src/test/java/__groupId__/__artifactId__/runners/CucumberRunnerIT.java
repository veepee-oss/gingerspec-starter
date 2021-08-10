package ${groupId}.${artifactId}.runners;

import io.cucumber.testng.CucumberOptions;
import com.privalia.qa.utils.BaseGTest;


/**
 * This is the runner class responsible of running the included *.feature files in the project.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * Here you can also create your own TestNG hooks or even configure parallel tests execution.
 * For more info on these topics check:
 * https://testng.org/doc/documentation-main.html#annotations
 * https://cucumber.io/docs/guides/parallel-execution/#testng
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
public class CucumberRunnerIT extends BaseGTest {


}
