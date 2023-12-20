package org.example;
import static io.restassured.RestAssured.*;
import org.junit.Test;

public class FirstTest extends TestConfig{
@Test
            public void EndpointMethod () {
        get(Endpoints.getallVideo).then().log().all();


    }

    }
