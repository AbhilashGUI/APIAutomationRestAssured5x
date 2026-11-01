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
    public void createtoken2()
    {
        String payload2="{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";

        RequestSpecification req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(payload2);


        Response rp=req.when().post();

        ValidatableResponse vr=rp.then();
        String token=rp.asString();
        System.out.println("Token "+token);
        vr.statusCode(200);





    }

   }