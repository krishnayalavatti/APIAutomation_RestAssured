package org.RestAssured.CRUD_POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


public class RA_POST_BDD_STYLE {


    @Test
    public void postRequest()

    {

        String payload="{\n" +

                " \"username\": \"admin\",\n" +

                " \"password\": \"password123\"\n" +

                "}";






        RestAssured.given()

                .baseUri("https://restful-booker.herokuapp.com").basePath("/auth")

                .contentType(ContentType.JSON).

                when().body(payload).post()

                .then().log().all().statusCode(200);



    }

}
