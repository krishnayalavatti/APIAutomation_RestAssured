package org.RestAssured.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RA_POST_NON_BDD_STYLE {

     @Test
    public void postRequest()

    {

        String payload="{\n" +

                " \"username\": \"admin\",\n" +

                " \"password\": \"password123\"\n" +

                "}";

        // Given
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        requestSpecification.basePath("/auth");

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(payload);

        requestSpecification.when().post();

        //When
        //Post
        Response response = requestSpecification.post();

        // Verification of status code and token
        //Then
        String responseString = response.asString();
        System.out.println(responseString);

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(200);







//        RestAssured.given()
//                 //Given
//                .baseUri("https://restful-booker.herokuapp.com")
//                .basePath("/auth")
//                .contentType(ContentType.JSON)
//                 //When
//                .when().body(payload).post()
//                 // Then
//                .then().log().all().statusCode(200);



    }


}

