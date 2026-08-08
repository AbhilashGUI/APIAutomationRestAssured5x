package CRUD.Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Createbooking {


    @Test
    public void createbooking()
    {

        String payload3= "{\n" +
                "    \"firstname\" : \"Abhilash\",\n" +
                "    \"lastname\" : \"Sharma\",\n" +
                "    \"totalprice\" : 142,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-03-19\",\n" +
                "        \"checkout\" : \"2024-06-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload3);

        Response rp= rs.when().post();

        ValidatableResponse vr= rp.then();
        String bookingdetails= rp.asString();
        System.out.println(bookingdetails);
        vr.statusCode(200);



    }
}
