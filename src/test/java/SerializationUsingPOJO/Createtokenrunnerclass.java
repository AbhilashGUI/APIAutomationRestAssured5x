package SerializationUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Createtokenrunnerclass {
    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token;

    @Test
    public void createtoken()
    {
        Createtoken createtoken=new Createtoken();
        createtoken.setUsername("admin");
        createtoken.setPassword("password123");

        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(createtoken);

        res=req.when().post();

        var=res.then().log().all();
        var.statusCode(200);
        token=res.then().extract().path("token");
        System.out.println("Token > "+token);
    }
}
