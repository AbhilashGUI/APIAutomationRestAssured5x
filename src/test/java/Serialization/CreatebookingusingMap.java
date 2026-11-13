package Serialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreatebookingusingMap {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    int bookingid;

    @Test
    public void postrequsingmap()
    {
        Map<String,Object> jsonpayloadusingmap=new LinkedHashMap<>();
        jsonpayloadusingmap.put("firstname","Abhilash");
        jsonpayloadusingmap.put("lastname","Sharma");
        jsonpayloadusingmap.put("totalprice",256);
        jsonpayloadusingmap.put("depositpaid",true);

        Map<String,Object> Bookingdates=new LinkedHashMap<>();
        Bookingdates.put("checkin","2024-03-19");
        Bookingdates.put("checkout","2024-06-20");
        jsonpayloadusingmap.put("bookingdates",Bookingdates);
        jsonpayloadusingmap.put("additionalneeds","Breakfast");


        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(jsonpayloadusingmap);

        res=req.when().post();

        var=res.then().log().all();
        var.statusCode(200);
        bookingid=res.then().extract().path("bookingid");
        System.out.println("Booking id :"+bookingid);



    }
}