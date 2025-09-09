package Get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NONBDDStyleGetTestNG {


        //Using the TestNG annotation

    @Test
        public void getbookingnegative()
        {
            RequestSpecification rs= RestAssured.given();
            rs.basePath("https://restful-booker.herokuapp.com");
            rs.baseUri("/booking/-1");
            rs.when().log().all();
            rs.then().log().all().statusCode(404);
        }

    @Test
    public void getbookingnegative2()
    {
        RequestSpecification rs= RestAssured.given();
        rs.basePath("https://restful-booker.herokuapp.com");
        rs.baseUri("/booking/abc");
        rs.when().log().all();
        rs.then().log().all().statusCode(404);
    }

    @Test
    public void getbookingpositive()
    {
        RequestSpecification rs= RestAssured.given();
        rs.basePath("https://restful-booker.herokuapp.com");
        rs.baseUri("/booking/2053");
        rs.when().log().all();
        rs.then().log().all().statusCode(201);
    }


    }

