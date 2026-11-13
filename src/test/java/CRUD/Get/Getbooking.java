package CRUD.Get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
      req.basePath("/booking/2295");

      Response res=req.when().get();

      ValidatableResponse var=res.then();
      String fetchbooking=res.asString();
      System.out.println(fetchbooking);
      var.statusCode(404);
    }
}
