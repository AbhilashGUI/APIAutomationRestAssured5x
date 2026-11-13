package SerializationUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Createbookingrunnerclass {

    RequestSpecification req;
    Response res;
    ValidatableResponse var;
    Integer bookingId;

    @Test
    public void Pojobookingcreation()
    {
        PojoBooking booking=new PojoBooking();
        booking.setFirstname("Abhilash");
        booking.setLastname("Sharma");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);


        PojoBookingdates pojoBookingdates=new PojoBookingdates();
        pojoBookingdates.setCheckin("2026-04-15");
        pojoBookingdates.setCheckout("2026-04-30");
        booking.setBookingdates(pojoBookingdates);
        booking.setAdditionalneeds("Breakfast");

        req=RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(booking).log().all();


        res=req.when().post();


        var=res.then().log().all();
        var.statusCode(200);
        bookingId=res.then().extract().path("bookingid");
        System.out.println(bookingId);




    }

}
