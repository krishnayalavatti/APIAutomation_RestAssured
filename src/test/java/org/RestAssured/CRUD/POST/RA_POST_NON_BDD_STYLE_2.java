package org.RestAssured.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RA_POST_NON_BDD_STYLE_2 {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void Given(){
        // Given
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");

    }

     @Test
    public void postRequest_1()

    {

        String payload="{\n" +

                " \"username\": \"admin\",\n" +

                " \"password\": \"password123\"\n" +

                "}";

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        //requestSpecification.when().post();
        response = requestSpecification.when().post();

        // Verification of status code and token
        //Then
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse = response.then();
        validatableResponse.statusCode(200);


    }

    @Test
    public void postRequest_2()

    {

        String payload="{\n" +

                " \"username\": \"admin2\",\n" +

                " \"password\": \"password123\"\n" +

                "}";

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        requestSpecification.when().post();
        response = requestSpecification.post();

        // Verification of status code and token
        //Then
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse = response.then();
        validatableResponse.statusCode(200);


    }

}

