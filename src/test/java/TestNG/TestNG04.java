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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestNG04 {

    String token;
    Integer bookingId;
    RequestSpecification req;
    Response res;
    ValidatableResponse vr;

    @BeforeTest
    public void gettoken() {
        System.out.println("--Get token--");
        String paylod = "{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";
        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("auth");
        req.contentType(ContentType.JSON);
        req.body(paylod);

        res = req.when().post();

        vr = res.then();

        //Using the RA assertions
        vr.body("token", Matchers.notNullValue());

        //TestNG assertions
        token = res.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getbookingId() {
        System.out.println("--Get bookingId--");

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(payload);

        res = req.when().post();

        vr = res.then();
        String Responsestring = res.asString();
        System.out.println(Responsestring);
        vr.statusCode(200);
        bookingId = res.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);
    }

    @Test
    public void updatebooking()
    {
        System.out.println("--Update booking--");
        String payload=" {\n" +
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
        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com/");
        req.basePath("booking/"+bookingId);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payload).log().all();

        res=req.when().put();

        vr=res.then().log().all();
        vr.statusCode(200);
        vr.body("firstname",Matchers.equalTo("Abhilash"));
        vr.body("lastname",Matchers.equalTo("Vemula"));


        String firstName = res.then().log().all().extract().path("firstname");
        //AssertJ
        assertThat(firstName).isNotNull().isNotBlank().isNotEmpty();

    }



}


