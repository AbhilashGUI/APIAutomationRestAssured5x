package Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NONBDDStylePostTestNG {


    @Test
    public void createtoken()
    {

        //Preparing
        RequestSpecification rs= RestAssured.given();

        String payload= "{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        //Making
        Response response=rs.when().post();


        //Completing
        ValidatableResponse validatableResponse= response.then();
        String responsestring= response.asString();
        System.out.println(responsestring);
        validatableResponse.statusCode(200);
    }
}
