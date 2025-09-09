package Get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NONBDDStyleGet {


    //given(), when(), then() are the builder pattern
    public static void main(String[] args) {

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/2009");
        rs.when().log().all();
        rs.get();
        rs.then().log().all().statusCode(200);


        RequestSpecification rs1 = RestAssured.given();
        rs1.baseUri("https://restful-booker.herokuapp.com");
        rs1.basePath("/booking/6");
        rs1.when().log().all();
        rs1.get();
        rs1.then().log().all().statusCode(200);
    }
}