package  TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Partialupdatebyfetchingprerequisites {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token;
    int bookingid;

    @BeforeTest
    public void gettoken() {
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
        token = res.then().log().all().extract().path("token");
        System.out.println("Token generation is successful :"+token);

    }

    @BeforeTest
    public void getbookingid()
    {
        String bookingpayload="{\n" +
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
        req.body(bookingpayload);

        res=req.when().post();

        var=res.then();
        var.statusCode(200);
        bookingid=res.then().log().all().extract().path("bookingid");
        System.out.println("Booking id got generated :"+bookingid);

    }

    @Test
    public void partialupdate()
    {
        String partialpayload="{\n" +
                "    \"firstname\" : \"Mukesh\",\n" +
                "    \"lastname\" : \"Ambani\"\n" +
                "}\n";

        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/"+bookingid);
        req.cookie("token",token);
        req.contentType(ContentType.JSON);
        req.body(partialpayload);

        res=req.when().patch();

        var=res.then();
        var.statusCode(200);
        var.body("firstname",Matchers.equalTo("Mukesh"));
        var.body("lastname",Matchers.equalTo("Ambani"));



    }
}