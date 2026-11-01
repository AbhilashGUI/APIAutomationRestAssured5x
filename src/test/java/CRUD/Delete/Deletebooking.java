package CRUD.Delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Deletebooking {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token="d561063692f323c";

     @Test
    public void deletebooking()
     {
         req= RestAssured.given();
         req.baseUri("https://restful-booker.herokuapp.com");
         req.basePath("/booking/618");
         req.cookie("token",token);

         res=req.when().delete();

         var=res.then().log().all();
         var.statusCode(201);

     }
}