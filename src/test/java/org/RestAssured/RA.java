package org.RestAssured;
import io.restassured.RestAssured;

public class RA {
    public static void main(String[] args) {

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")

                .when().get().then().log().all().statusCode(201);

    }
}
