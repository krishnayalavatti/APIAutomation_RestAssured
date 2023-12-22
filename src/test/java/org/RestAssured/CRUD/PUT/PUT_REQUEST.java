package org.RestAssured.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PUT_REQUEST {

    // Get a Token - POST
    // Create a Booking and get ID
    // ID and Token in the PUT request
    // Then PUT -> Verify


    // Make a Post request to the /auth - get Token and ID
    // pass the token to the put requests
    //
    // make a put request with the token & ID and validate the response


    @Test
    public void putrequest(){

        // Step 1 - Create the Token and GET THE Token (Post)

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        String payloadAuth="{\n" +

                " \"username\": \"admin\",\n" +

                " \"password\": \"password123\"\n" +

                "}";
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payloadAuth);

        Response response = r.when().post();
        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

        //Token
        String token = response.then().extract().path("token");
        System.out.println(token);


        // Step 2 - Create the Booking ane get the id (POST)

        String payload_post = "{\n" +
                "    \"firstname\" : \"Krishna\",\n" +
                "    \"lastname\" : \"Ram\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload_post);

        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);

        //Booking Id
        Integer bookingid = response.then().extract().path("bookingid");
        System.out.println(bookingid);

        // STEP 3
        // Token and ID
        // Change the name to Ram in PUT request and Verify
        // name = Ram

        String payloadPutRequest = "{\n" +
                "    \"firstname\" : \"Ram\",\n" +
                "    \"lastname\" : \"Ram\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);   // use cookie method to pass token
        r.body(payloadPutRequest);

        response = r.when().put();
        vr = response.then().log().all();


        //TC #1
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Ram"));



    }
}
