package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Generatetokenandbookingid {

        RequestSpecification req;
        Response res;
        ValidatableResponse var;
        String Token;
        int bookingId;

        @Test
        public void tokenandbookingid() {

                String authpayload = "{\n" +
                        "    \"username\":\"admin\",\n" +
                        "    \"password\":\"password123\"\n" +
                        "\n" +
                        "}";

                req=RestAssured.given();
                req.baseUri("https://restful-booker.herokuapp.com");
                req.basePath("/auth");
                req.contentType(ContentType.JSON);
                req.body(authpayload).log().all();

                res=req.when().post();

                var=res.then().log().all();
                var.statusCode(200);
                Token= res.asString();
                System.out.println(Token);


                String reqpayload="{\n" +
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
                req.body(reqpayload).log().all();


                res=req.when().post();

                var=res.then().log().all();
                var.statusCode(200);
                bookingId= res.jsonPath().getInt("bookingid");
                System.out.println(bookingId);


        }
}
