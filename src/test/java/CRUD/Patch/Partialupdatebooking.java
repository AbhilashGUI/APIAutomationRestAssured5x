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
    RequestSpecification rs;
    Response rp;
    ValidatableResponse vr;
    String token="0ba82f9247950a9";


    @Test
    public void partialupdate()
    {

        String payload= "{\n" +
                "    \"firstname\" : \"Shreyansh\",\n" +
                "    \"lastname\" : \"Sree\"\n" +
                "}";

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/4844");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        rp=rs.when().patch();

        vr=rp.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Shreyansh"));
        vr.body("lastname", Matchers.equalTo("Sree"));







    }



}