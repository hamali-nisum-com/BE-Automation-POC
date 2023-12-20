import org.example.Endpoints;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.matcher.DetailedCookieMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.hamcrest.Matcher;
import org.junit.BeforeClass;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class SecondApiTest extends SecondApiConfig{

    @Test

    public void queryParam() {
        given().queryParam("areas", 2076)
                .when().get("/areas");

    }

    @Test
    public void assertionOnDataFound() {
        given()
                .when()
                .get("teams/57").then()
                .body("founded", equalTo (1886));

    }

    @Test
    public void assertionOnTeamDataFound() {
        given()
                .when()
                .get("competitions/2021/teams").then()
                .body("teams.id[0]", equalTo (57));

    }

    @Test
    public void getAllData () {

        String responseBody = get("teams/57").asString();
        System.out.println(responseBody);
    }
    @Test
    public void getAllDatausingGivenWhenThenn () {
   Response response =     given()
                .when()
                .get("teams/57").then().contentType(ContentType.JSON).extract().response();
        String jsonResponseasString = response.asString();
        System.out.println(jsonResponseasString);
    }
    @Test
    public void extractAllTeamNames () {
Response response =
        given()
                .when()
                .get("competitions/2021/teams").then().extract().response();

        List <String> teamNames = response.path("teams.name");

   for (String team: teamNames) {
       System.out.println(team);

   }


    }
}
