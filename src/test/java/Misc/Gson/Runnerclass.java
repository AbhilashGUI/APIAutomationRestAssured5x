package Misc.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Runnerclass {
    RequestSpecification req;
    Response res;
    ValidatableResponse vrs;

    @Test
    public void testpost()
    {

        Booking booking=new Booking();
        booking.setFirstname("Abhilash");
        booking.setLastname("Vemula");
        booking.setTotalprice(125);
        booking.setDepositpaid(true);

        Bookingdates bookingdates= new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2024-05-02");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking);
        System.out.println(bookingdates);

        req= RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(booking).log().all();


        res=req.when().post();
        Integer bookingId= res.then().extract().path("bookingid");
        vrs=res.then().log().all();
        vrs.statusCode(200);
        System.out.println(bookingId);




    }


}
