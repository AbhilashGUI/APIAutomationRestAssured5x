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

public class Payloadusingmap1 {

    RequestSpecification req;
    Response res;
    ValidatableResponse vrs;

    @Test
    public void postreq()
    {

        Map<String,Object> Jsonbodyasmap= new LinkedHashMap<>();
        Faker faker=new Faker();
        Jsonbodyasmap.put("firstname",faker.name().firstName());
        Jsonbodyasmap.put("lastname",faker.name().lastName());
        Jsonbodyasmap.put("totalprice",faker.random().nextInt(100));
        Jsonbodyasmap.put("depositpaid",faker.random().nextBoolean());


        Map<String,Object> Mapbookingdates=new LinkedHashMap<>();
        Mapbookingdates.put("checkin","2020-01-01");
        Mapbookingdates.put("checkout","2020-03-03");
        Jsonbodyasmap.put("bookingdates",Mapbookingdates);
        Jsonbodyasmap.put("additionalbenefits","lunch");
        System.out.println(Jsonbodyasmap);

        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(Jsonbodyasmap).log().all();

        res=req.when().post();

        vrs=res.then().log().all();
        vrs.statusCode(200);


    }


}
