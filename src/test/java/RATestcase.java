import io.restassured.RestAssured;

public class RATestcase {

    public static void main(String[] args) {
        //given()---Setup request
        //URL= baseuri+basepath
        //Header
        //Auth-Basic, Digest, JWT, Bearer Token


        //when()---Execute request
        //Payload,since we are using Get method > No payload requires

        //then()---Validate response
        //Status code
        //Response body
        //Time, Headers, cookies


        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/").basePath("IN/500036")

                .when().log().all()
                .get()

                .then().log().all()
                .statusCode(200);


    }
}
