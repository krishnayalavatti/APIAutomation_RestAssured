package org.RestAssured.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


public class RA_POST_BDD_STYLE {


    // Step
    // prepare a request - Given
    // Make a request - When
    // Verify the request - Then()


    // Make a POST Request ?
    // To Create A Token  - Post
    // URL - https://restful-booker.herokuapp.com/auth
    // BaseURI - https://restful-booker.herokuapp.com
    // BasePath - /auth


    // Payload - {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    // HTTP Method - POST
    // Header - Content-type- application json

    // Verify ->
    // TC#1 - Status Code,
    // TC#2 - Token should not be null


    @Test
    public void postRequest()

    {

        String payload="{\n" +

                " \"username\": \"admin\",\n" +

                " \"password\": \"password123\"\n" +

                "}";






        RestAssured.given()
                //Given
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)

                //When
                .when().body(payload).post()

                 //Then
                .then().log().all().statusCode(200);



    }

}
