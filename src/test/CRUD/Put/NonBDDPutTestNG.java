package Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPutTestNG {


    RequestSpecification rs;
    ValidatableResponse vr;
    Response rp;
    String token = "f469955e7417563";

    @Test
    public void updatefullbooking()
    {


        String payload= "    {\n" +
                "        \"firstname\" : \"Abhilash\",\n" +
                "        \"lastname\" : \"Vemula\",\n" +
                "        \"totalprice\" : 111,\n" +
                "        \"depositpaid\" : true,\n" +
                "        \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\" : \"Breakfast\"\n" +
                "    }";


        rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/710");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        rp=rs.when().put();

        vr=rp.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Abhilash"));
        vr.body("lastname",Matchers.equalTo("Vemula"));

}

}
