package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestNG03 {

    String Token;
    Integer boookingId;
    RequestSpecification req;
    Response res;
    ValidatableResponse vr;

    //Just fetching the pre-requisites
@Test
public void gettokenandbookingId() {


    String payload="{\n" +
            "\"firstname\" : \"Virat\",\n" +
            "    \"lastname\" : \"Kohli\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-07-10\",\n" +
            "        \"checkout\" : \"2024-04-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    req= RestAssured.given();
    req.baseUri("https://restful-booker.herokuapp.com");
    req.basePath("/booking");
    req.contentType(ContentType.JSON);
    req.body(payload).log().all();


    res=req.when().post();


    vr= res.then().log().all();
    vr.statusCode(200);
    System.out.println(boookingId);

    String Authpayload="{\n" +
            "    \"username\":\"admin\",\n" +
            "    \"password\":\"password123\"\n" +
            "\n" +
            "}";
    req= RestAssured.given();
    req.baseUri("https://restful-booker.herokuapp.com");
    req.basePath("/auth");
    req.contentType(ContentType.JSON);
    req.body(Authpayload).log().all();


    res=req.when().post();


    vr= res.then().log().all();
    vr.statusCode(200);
    System.out.println(Token);

}
}