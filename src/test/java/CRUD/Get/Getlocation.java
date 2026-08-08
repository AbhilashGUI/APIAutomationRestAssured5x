package CRUD.Get;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Getlocation {

    @Test
    public void Getlocation()
    {

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/500023")

                .when()
                .get()

                .then()
                .log().all().statusCode(200);

    }
}