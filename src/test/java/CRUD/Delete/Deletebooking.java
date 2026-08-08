package CRUD.Delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Deletebooking {

    RequestSpecification rs;
    Response rp;
    ValidatableResponse vr;
    String token="57948afd8262b3c";

     @Test
    public void deletebooking()
     {
         rs= RestAssured.given();
         rs.baseUri("https://restful-booker.herokuapp.com");
         rs.basePath("/booking/2303");
         rs.cookie("token",token);

         rp=rs.when().delete();

         vr=rp.then().log().all();
         vr.statusCode(201);

     }
}