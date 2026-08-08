package CRUD.Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Getbooking {

    @Test

    public void Getbooking()
    {

        RequestSpecification rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/751");

        Response rp=rs.when().get();

        ValidatableResponse vr=rp.then().log().all().statusCode(200);
    }

}
