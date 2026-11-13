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
        String token;
        int bookingid;

        @Test
        public void generatetokenandbookingid()
        {
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

                var=res.then().log().all();
                var.statusCode(200);
                token=res.asString();
                System.out.println(token);

                String payload2="{\n" +
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
                req.body(payload2);


                res=req.when().post();

                var=res.then();
                var.statusCode(200);
                bookingid=res.jsonPath().getInt("bookingid");
                System.out.println(bookingid);


        }

}