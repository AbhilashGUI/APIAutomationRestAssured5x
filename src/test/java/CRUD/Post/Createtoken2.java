package CRUD.Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Createtoken2 {


    //BDD Style
    @Test
    public void  createtoken2()
    {

        String payload2="{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";

       //Represents the request configuration
        RequestSpecification rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload2);

       //Represents actual response received from API
        Response rp=rs.when().post();


       //Used to perform assertions/ Validations on response
        ValidatableResponse vr= rp.then();
        String token= rp.asString();
        System.out.println("Token "+token);
        vr.statusCode(200);



    }
}