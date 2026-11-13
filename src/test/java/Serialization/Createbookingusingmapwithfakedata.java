package Serialization;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Createbookingusingmapwithfakedata {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    int bookingid;

    @Test
    public void postrequsingrandomdata()
    {

        Map<String,Object> Jsonpayloadusingfakedata=new LinkedHashMap<>();
        Faker faker=new Faker();
        Jsonpayloadusingfakedata.put("firstname",faker.name().firstName());
        Jsonpayloadusingfakedata.put("lastname",faker.name().lastName());
        Jsonpayloadusingfakedata.put("totalprice",faker.random().nextInt(100));
        Jsonpayloadusingfakedata.put("depositpaid",faker.random().nextBoolean());

        Map<String,Object> Bookingdatesusingmap=new LinkedHashMap<>();
        Bookingdatesusingmap.put("checkin","2024-03-19");
        Bookingdatesusingmap.put("checkout","2024-06-20");
        Jsonpayloadusingfakedata.put("bookingdates",Bookingdatesusingmap);
        Jsonpayloadusingfakedata.put("additionalneeds","brunch");

         req=RestAssured.given();
         req.baseUri("https://restful-booker.herokuapp.com");
         req.basePath("/booking");
         req.contentType(ContentType.JSON);
         req.body(Jsonpayloadusingfakedata);

         res=req.when().post();

         var=res.then().log().all();
         var.statusCode(200);
         bookingid=res.then().extract().path("bookingid");
         System.out.println("Bookingid> "+bookingid);


    }
}