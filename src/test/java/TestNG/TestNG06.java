package TestNG;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG06 {

    String token;
    Integer bookingId;
    RequestSpecification req;
    Response res;
    ValidatableResponse vr;


    @BeforeTest
    public void getbookingid() {
        System.out.println("--Get bookingid--");
        String payload="{\n" +
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
        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(payload);

        res=req.when().post();

        vr=res.then();
        vr.statusCode(200);
        bookingId= res.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);
    }

      @BeforeTest
    public void gettoken()
      {
          System.out.println("--Get token");
          String payload="{\n" +
                  "    \"username\":\"admin\",\n" +
                  "    \"password\":\"password123\"\n" +
                  "\n" +
                  "}";
          req=RestAssured.given();
          req.baseUri("https://restful-booker.herokuapp.com");
          req.basePath("/auth");
          req.contentType(ContentType.JSON);
          req.body(payload);


          res=req.when().post();

          vr=res.then();
          vr.statusCode(200);
          token = res.then().log().all().extract().path("token");
          System.out.println(token);
      }


      @Test
    public void deletebooking()
      {
          System.out.println("--Delete booking--");
          req=RestAssured.given();
          req.baseUri("https://restful-booker.herokuapp.com");
          req.basePath("/booking/"+bookingId);
          req.contentType(ContentType.JSON);
          req.cookie("token",token);

          res=req.when().delete();
          vr=res.then();
          vr.statusCode(201);

      }
}