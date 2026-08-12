package Misc.NonGson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PojoPostRunnerclass {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    Integer bookingId;

    @Test
    public void Pojopostreq()
    {
      PojoBooking booking=new PojoBooking();
      booking.setFirstname("Abhilash");
      booking.setLastname("Sharma");
      booking.setTotalprice(123);
      booking.setDepositpaid(true);

      PojoBookingdates bookingdates=new PojoBookingdates();
      bookingdates.setCheckin("2024-03-19");
      bookingdates.setCheckout("2024-06-20");
      booking.setBookingdates(bookingdates);
      booking.setAdditionalneeds("Breakfast");

      req= RestAssured.given();
      req.baseUri("https://restful-booker.herokuapp.com");
      req.basePath("/booking");
      req.contentType(ContentType.JSON);
      req.body(booking).log().all();


      res=req.when().post();

      var= res.then().log().all();
      var.statusCode(200);
      bookingId=res.then().extract().path("bookingid");
      System.out.println(bookingId);

    }
}