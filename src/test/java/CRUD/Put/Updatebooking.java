package CRUD.Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Updatebooking {

    RequestSpecification rs;
    Response rp;
    ValidatableResponse vr;
    String token="ffa9048ba359c7c";

    @Test

    public void Fullupdate()
    {

        String payload= "{\n" +
                "    \"firstname\" : \"Amith\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 175,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-03-19\",\n" +
                "        \"checkout\" : \"2024-06-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/1359");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload);

        rp=rs.when().put();

        vr=rp.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Amith"));
        vr.body("lastname",Matchers.equalTo("Kumar"));







    }
}