import static io.restassured.RestAssured.*;

import org.example.Endpoints;
import org.example.TestConfig;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
public class AllRequest extends TestConfig {



    String gameBodyJson = "{\n" +
            "  \"category\": \"Platform\",\n" +
            "  \"name\": \"Hamza\",\n" +
            "  \"rating\": \"Mature\",\n" +
            "  \"releaseDate\": \"2012-05-04\",\n" +
            "  \"reviewScore\": 85\n" +
            "}";
@Test
    public void getVideoGamesRequest () {
        given()
                .when().get(Endpoints.getallVideo)
                .then();

    }

    @Test

    public void postVideoGamesRequest () {

      given()
              .body(gameBodyJson)
              .when().post(Endpoints.getallVideo)
              .then();


      }
 @Test
      public void putVideoGameRequest() {
       given()
               .body(gameBodyJson)
               .when()
               .put("videogame/3")
               .then();



      }
    @Test
    public void deleteVideoGameRequest() {
        given()
                .accept("text/plain")
                .when()
                .delete("videogame/3")
                .then();
    }
@Test
    public void pathParameter() {
       given().pathParam("videoGameId", 9)
    .when()
               .get(Endpoints.singleVideo)
               .then();

    }




    }

