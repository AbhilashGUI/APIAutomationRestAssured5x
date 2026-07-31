package Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyleTestNG {

    RequestSpecification rs;
    Response rp;
    ValidatableResponse vr;
    String token = "9cf26414cf48cea";

    @Test
    public void partialupdate() {
        String payload = "{\n" +
                "    \"firstname\": \"Abhilash\",\n" +
                "    \"lastname\": \"Sharma\"\n" +
                "}";


        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/999");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        rp=rs.when().patch();

        vr=rp.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Abhilash"));
        vr.body("lastname", Matchers.equalTo("Sharma"));

    }
}