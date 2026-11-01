package CRUD.Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Partialupdatebooking
{
    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token="d561063692f323c";


    @Test
    public void partialupdate()
    {

        String payload= "{\n" +
                "    \"firstname\" : \"Shreyansh\",\n" +
                "    \"lastname\" : \"Sree\"\n" +
                "}";

        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/618");
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payload).log().all();

        res=req.when().patch();

        var=res.then().log().all();
        var.statusCode(200);
        var.body("firstname", Matchers.equalTo("Shreyansh"));
        var.body("lastname", Matchers.equalTo("Sree"));







    }



}