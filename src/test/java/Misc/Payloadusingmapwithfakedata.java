package Misc;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Payloadusingmapwithfakedata {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    Integer bookingId;

    @Test
    public void postrequsingmap2()
    {
        Map<String, Object> jsonpayloadfakedata=new LinkedHashMap<>();
        Faker faker= new Faker();
        jsonpayloadfakedata.put("firstname",faker.name().firstName());
        jsonpayloadfakedata.put("lastname",faker.name().lastName());
        jsonpayloadfakedata.put("totalprice",faker.random().nextInt(100));
        jsonpayloadfakedata.put("depositpaid",faker.random().nextBoolean());


        Map<String,Object> Bookingdates= new LinkedHashMap<>();
        Bookingdates.put("checkin","2024-03-19");
        Bookingdates.put("checkout","2024-06-20");
        jsonpayloadfakedata.put("bookingdates",Bookingdates);
        jsonpayloadfakedata.put("additionalneeds","Lunch");


        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(jsonpayloadfakedata).log().all();

        res=req.when().post();

        var= res.then().log().all();
        var.statusCode(200);
        bookingId=res.then().extract().path("bookingid");
        System.out.println(bookingId);


    }
}