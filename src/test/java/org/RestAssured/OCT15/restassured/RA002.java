package org.RestAssured.OCT15.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RA002 {

    //Make A Post request
    //To create a Token - Post
    //URL- https://restful-booker.herokuapp.com/auth
    //baseUri- https://restful-booker.herokuapp.com
    //basePath- /auth

    //Payload- {\n" +
    //                "    \"username\":\"admin\",\n" +
    //                "    \"password\":\"password123\"\n" +
    //                "}

    //HTTP Method- Post
    //Header - Content Type- application json

    //Verify->
    // TC#1 Status code
    // TC#2 Token should not be null

    @Test
    public void postRequest() {


        String Payload = "{\n" +
                "    \"username\":\"admin\",\n" +
                "    \"password\":\"password123\"\n" +
                "}";


        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)

                .when().body(Payload).post()

                .then().log().all().statusCode(200);

    }
}
