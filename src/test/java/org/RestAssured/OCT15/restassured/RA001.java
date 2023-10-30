package org.RestAssured.OCT15.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RA001 {

    //RestAssured steps
    // Prepare a request - Given()
    // Make a request - when()
    // Verify the request - then()


    //TestNg Concepts
    // Annotations and How TestNg works with RA

    @Test(groups = {"Positive"},priority = 1)
    public void getRequest_Positive(){

        RestAssured

                .given().baseUri("https://restful-booker.herokuapp.com/ping")

                .when().get()

                .then().log().all().statusCode(201);
        System.out.println("Success");

    }

    @Test(groups = {"Negetive"},priority = 2)
    public void getRequest_Negetive(){

        RestAssured

                .given().baseUri("https://restful-booker.herokuapp.com/ping")

                .when().get()

                .then().log().all().statusCode(200);

    }

}
