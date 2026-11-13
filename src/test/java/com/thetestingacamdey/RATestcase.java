package com.thetestingacamdey;

import io.restassured.RestAssured;

public class RATestcase {

    public static void main(String[] args)
    {

       RestAssured
               .given()
               .baseUri("https://api.zippopotam.us/")
               .basePath("/IN/500036")

               .when().log().all()
               .get()

               .then().log().all()
               .statusCode(200);


    }
}

//Non-builder pattern