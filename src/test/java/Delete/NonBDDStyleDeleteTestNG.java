package Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleDeleteTestNG {

    RequestSpecification req;
    Response res;
    ValidatableResponse vr;
    String token = "a4604bae716da06";

    @Test
    public void deletetoken() {
        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/2274");
        req.contentType(ContentType.JSON);
        req.cookie("token", token);


        res = req.when().delete();

        vr = res.then().log().all();
        vr.statusCode(201);


    }
}

