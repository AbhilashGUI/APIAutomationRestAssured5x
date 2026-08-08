package CRUD.Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Getbookings {


    //given(), when(), then() are the builder pattern
   @Test
            public void Getbookings()
   {

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/4");

        Response rp= rs.when().get();

        ValidatableResponse vr= rp.then().log().all().statusCode(200);


       RequestSpecification rs2 = RestAssured.given();
       rs.baseUri("https://restful-booker.herokuapp.com");
       rs.basePath("/booking/16");

       Response rp2= rs.when().get();

       ValidatableResponse vr2= rp2.then().log().all().statusCode(200);


   }
}