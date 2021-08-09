package ${groupId}.${artifactId}.utils;


import com.privalia.qa.utils.BaseGTest;
import com.privalia.qa.utils.ThreadProperty;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Use this class to define your own TestNG hooks. For more info on TestNG hooks check:
 * https://testng.org/doc/documentation-main.html#annotations
 */
abstract public class BaseTest extends BaseGTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(ITestContext context) {
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context) {
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method) {
    }

    @AfterClass()
    public void afterClass() {
    }

    /* Set parallel = true to allow parallel test execution */
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}