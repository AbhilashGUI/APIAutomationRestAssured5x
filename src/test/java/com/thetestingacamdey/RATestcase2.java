package com.thetestingacamdey;

import io.restassured.RestAssured;

public class RATestcase2 {

    public static void main(String[] args)
    {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/").basePath("IN/500044")

                .when().log().all()
                .get()

                .then().log().all()
                .statusCode(201);



    }
}
