package org.RestAssured;

import io.restassured.RestAssured;
import org.junit.Test;

public class RATestNg
{

    @Test
    public void RATest()
    {

        RestAssured

                .given().baseUri("https://restful-booker.herokuapp.com/ping")

                .when().get()

                .then().log().all().statusCode(201);

    }


}
