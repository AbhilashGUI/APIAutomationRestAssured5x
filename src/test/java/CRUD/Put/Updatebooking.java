package CRUD.Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Updatebooking {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token="f71492e89dd5e7b";

    @Test
    public void fullupdate()
    {
        String payload="{\n" +
                "    \"firstname\" : \"Amith\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 175,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-03-19\",\n" +
                "        \"checkout\" : \"2024-06-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/1596");
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payload);


        res=req.when().put();

        var=res.then().log().all();
        var.statusCode(200);
        var.body("firstname",Matchers.equalTo("Amith"));
        var.body("lastname",Matchers.equalTo("Kumar"));






    }

}
