package TestNG;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG05 {

    String token;
    Integer bookingId;
    RequestSpecification req;
    Response res;
    ValidatableResponse vr;


  @BeforeTest
    public void getbookingid() {
        System.out.println("--Get booking Id--");

        String payload = "{\n" +
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
        req.body(payload);

        res = req.when().post();

        vr = res.then();
        //String ResponseString = res.asString();
       // System.out.println(ResponseString);
        vr.statusCode(200);
        bookingId = res.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);

    }
      @BeforeTest
      public void gettoken()
      {
          System.out.println("--Get token--");
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
          //vr.body("token", Matchers.notNullValue());
          token = res.then().log().all().extract().path("token");
          System.out.println(token);

      }

       @Test
       public void partialupdate() {
           System.out.println("--Partial update--");
           String payload = "{\n" +
                   "    \"firstname\" : \"Srikanth\",\n" +
                   "    \"lastname\" : \"Bolla\"\n" +
                   "}\n";

           req = RestAssured.given();
           req.baseUri("https://restful-booker.herokuapp.com");
           req.basePath("/booking/" + bookingId);
           req.contentType(ContentType.JSON);
           req.cookie("token", token);
           req.body(payload).log().all();

           res = req.when().patch();

           vr = res.then();
           vr.statusCode(200);
           vr.body("firstname", Matchers.equalTo("Srikanth"));
           vr.body("lastname", Matchers.equalTo("Bolla"));


       }
}



