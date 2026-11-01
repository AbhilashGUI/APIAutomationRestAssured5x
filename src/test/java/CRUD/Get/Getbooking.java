package CRUD.Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Getbooking {


    @Test
    public void getbooking()
    {
        RequestSpecification req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/618");

        Response res=req.when().get();

        ValidatableResponse var=res.then().log().all();
        String Bookingfetch=res.asString();
        System.out.println("Booking check"+Bookingfetch);
        var.statusCode(200);
    }
}
