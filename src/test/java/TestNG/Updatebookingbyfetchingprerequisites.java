package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Updatebookingbyfetchingprerequisites {

    String token;
    Integer bookingId;
    RequestSpecification req;
    Response res;
    ValidatableResponse var;

    @BeforeTest
    public void gettoken() {
        System.out.println("--Get token--");
        String authpayload = "{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";

        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(authpayload);

        res = req.when().post();

        var = res.then();
        var.statusCode(200);
        var.body("token", Matchers.notNullValue());

        token = res.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }
    @BeforeTest
    public void getbookingid()
    {
        System.out.println("--Get bookingid--");
        String payload="{\n" +
                "    \"firstname\" : \"Abhilash\",\n" +
                "    \"lastname\" : \"Sharma\",\n" +
                "    \"totalprice\" : 142,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-03-19\",\n" +
                "        \"checkout\" : \"2024-06-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(payload);

        res=req.when().post();

        var= res.then().log().all();
        var.statusCode(200);
        bookingId=res.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);

    }
    @Test
    public void updatebooking()
    {
        System.out.println("--Update booking--");
        String updatepayload="{\n" +
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
        req.basePath("/booking/"+bookingId);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(updatepayload).log().all();

        res=req.when().put();

        var= res.then().log().all();
        var.statusCode(200);
        var.body("firstname",Matchers.equalTo("Amith"));
        var.body("lastname",Matchers.equalTo("Kumar"));
        String firstName=res.then().log().all().extract().path("firstname");
        assertThat(firstName).isNotNull().isNotBlank().isNotEmpty();

    }
}