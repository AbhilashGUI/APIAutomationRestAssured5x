package Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePostTestNG {


    @Test
    public void createtoken(){

        String payload ="{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/auth").contentType(ContentType.JSON)

                .body(payload).when().post().then().log().all().statusCode(200);
    }
}
