package ${groupId}.${artifactId}.runners;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * This is an example of a simple TestNG test. For more information, you can check
 * https://testng.org/doc/
 */
public class TestRunnerIT {

    /**
     * Use rest-assured directly to test your Rest API. More info at
     * https://rest-assured.io/
     */
    @Test
    public void exampleTest() {
        RestAssured.given().contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com:443/posts")
                .then()
                .statusCode(200);
    }

    /**
     * Use directly assertj as assertion library
     * https://assertj.github.io/doc/
     */
    @Test
    public void anotherExampleTest() {
        String text = "GingerSpec";
        Assertions.assertThat(text).isEqualTo("GingerSpec");
    }
}
