package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Deletebookingbyfetchingprerequisites {

    String token;
    Integer bookingId;
    RequestSpecification req;
    Response res;
    ValidatableResponse var;

    @BeforeTest
    public void getoken()
    {
        String authpayload= "{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";

        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(authpayload);

        res=req.when().post();

        var=res.then();
        var.statusCode(200);
        token=res.then().log().all().extract().path("token");
        System.out.println(token);
    }
    @BeforeTest
    public void getbookingid()
    {
        String postpayload="{\n" +
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

        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(postpayload);

        res=req.when().post();

        var=res.then();
        var.statusCode(200);
        bookingId=res.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);

    }

    @Test
    public void deletbooking()
    {
        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/"+bookingId);
        req.cookie("token",token);

        res=req.when().delete();

        var=res.then().log().all();
        var.statusCode(201);


    }
}