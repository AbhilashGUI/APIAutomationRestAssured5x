package Misc;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Payloadusingmap {

    RequestSpecification req;
    Response res;
    ValidatableResponse vrs;

    @Test
    public void postreq() {


        Map<String, Object> JsonBodyUsingMap= new HashMap<>();
        JsonBodyUsingMap.put("firstname","jim");
        JsonBodyUsingMap.put("lastname","Brown");
        JsonBodyUsingMap.put("totalprice",111);
        JsonBodyUsingMap.put("depositpaid",true);


        Map<String, Object> Mappingbookingdates=new HashMap<>();
        Mappingbookingdates.put("checkin","2018-01-20");
        Mappingbookingdates.put("checkout","2019-01-20");
        JsonBodyUsingMap.put("bookingdates",Mappingbookingdates);
        JsonBodyUsingMap.put("additionalneeds","Breakfast");
        System.out.println(JsonBodyUsingMap);


        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(JsonBodyUsingMap).log().all();

        res = req.when().post();

        Integer bookingId = res.then().extract().path("bookingid");

        vrs = res.then().log().all();
        vrs.statusCode(200);
        System.out.println("Booking id-->"+bookingId);
    }
}