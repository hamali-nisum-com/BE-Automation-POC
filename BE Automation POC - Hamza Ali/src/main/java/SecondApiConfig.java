import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.BeforeClass;

public class SecondApiConfig {

@BeforeClass
    public static void setup() {


        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.football-data.org")
                .setBasePath("/v4")
                .setContentType("application/json")
                .addHeader("X-Auth-Token", "4d0920652030460194e87e5a97001531")
                .addHeader("X-Responnse-Control",  "minified")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).build();
    }
}