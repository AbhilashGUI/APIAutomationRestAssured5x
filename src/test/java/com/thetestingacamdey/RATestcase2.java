package com.thetestingacamdey;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RATestcase2 {

    static RequestSpecification req;
    static Response res;
    static ValidatableResponse var;
    public static void main(String[] args)
    {

                req=RestAssured.given();
                req.baseUri("https://api.zippopotam.us");
                req.basePath("/IN/500045");

                res=req.when().log().all()
                        .get();

                var=res.then().log().all()
                .statusCode(200);



    }
}

//builder pattern