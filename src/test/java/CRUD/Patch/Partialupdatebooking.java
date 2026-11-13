package CRUD.Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Partialupdatebooking {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token="21be38f48d2ebb0";
    @Test
    public void minorupdate() {
        String payload="{\n" +
                "    \"firstname\" : \"Rohith\",\n" +
                "    \"lastname\" : \"Sharma\"\n" +
                "}\n";



        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/2295");
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payload);


        res=req.when().patch();

        var=res.then();
        var.statusCode(200);
        var.body("firstname",Matchers.equalTo("Rohith"));
        var.body("lastname",Matchers.equalTo("Sharma"));




    }



}