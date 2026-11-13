package Serialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateAuthusingMap {
    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token;

    @Test
    public void createtoken()
    {
        Map<String,Object> payloadusingmap=new LinkedHashMap<>();
        payloadusingmap.put("username","admin");
        payloadusingmap.put("password","password123");

        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(payloadusingmap);

        res=req.when().post();

        var=res.then().log().all();
        var.statusCode(200);
        token=res.then().extract().path("token");
        System.out.println("token > "+token);






    }
}
