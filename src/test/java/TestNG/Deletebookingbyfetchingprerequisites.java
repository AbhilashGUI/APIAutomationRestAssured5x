package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Deletebookingbyfetchingprerequisites {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    String token;
    int bookingid;

    @BeforeTest
    public void createtoken()
    {

        String authpayload="{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";
        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(authpayload);

        res=req.when().post();

        var=res.then();
        var.statusCode(200);
        token=res.then().extract().path("token");
        System.out.println("Token > :"+token);

    }

    @BeforeTest
    public void createbooking() {

        String bookingpayload = "{\n" +
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
        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(bookingpayload);

        res = req.when().post();

        var = res.then();
        var.statusCode(200);
        bookingid = res.then().extract().path("bookingid");
        System.out.println("Booking id >" + bookingid);
    }

    @Test
    public void deletetoken()
    {
        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/"+bookingid);
        req.cookie("token",token);

        res=req.when().delete();

        var=res.then().statusCode(201);

    }

    @Test
    public void fetchthedeletedbooking()
    {
        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/"+bookingid);
        System.out.println("Deleted booking is not found: "+bookingid);
        res=req.when().get();

        var=res.then();
        var.statusCode(404);
    }

}
