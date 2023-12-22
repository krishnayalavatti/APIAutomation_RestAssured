package org.RestAssured.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRUD_TEST {

    // CRUD Operations basic level
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    Integer BookingId;
    String token;

    @BeforeTest
    public void Setup(){

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.contentType(ContentType.JSON);


    }
    @Test (priority = 1)
    public void Postrequest() {

        // Step 1 - Create the Token and GET THE Token (Post)

        String payloadAuth = "{\n" +

                " \"username\": \"admin\",\n" +

                " \"password\": \"password123\"\n" +

                "}";
        r.basePath("/auth");
        r.body(payloadAuth);

        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);

        //Token
        token = response.then().extract().path("token");
        System.out.println(token);

    }

    // Create Booking to get BOOKING ID (POST)
    @Test (priority = 2)
    public void Post2request(){

        String Postpayload = "{\n" +
                "    \"firstname\" : \"Krishna\",\n" +
                "    \"lastname\" : \"Yalavatti\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("/booking");
        r.body(Postpayload);

        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);

        BookingId = response.then().extract().path("bookingid");
        System.out.println(BookingId);

    }

    @Test (priority = 3)
    public void Getrequest(){
        // To check booking details (GET)
        r.basePath("/booking/"+BookingId);

        response = r.when().get();
        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Krishna"));

    }

   @Test (priority = 4)
    public void Putrequest(){
        // To update booking details (PUT)
        String Payloadpost = "{\n" +
                "    \"firstname\" : \"Sriram\",\n" +
                "    \"lastname\" : \"Yalavatti\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("/booking/"+BookingId);
        r.cookie("token",token);
        r.body(Payloadpost);

        response = r.when().put();
        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname",Matchers.equalTo("Sriram"));

    }

    @Test (priority = 5)
    public void Deleterequest(){
        // To delete booking details (delete)
        r.basePath("/booking/"+BookingId);
        r.cookie("token",token);

        response= r.when().delete();
        vr = response.then().log().all();
        vr.statusCode(201);

    }

    @Test (priority = 6)
    public void Getrequest2(){
        // Verify deleted booking or not (GET)
        r.basePath("/booking/"+BookingId);

        response = r.when().get();
        vr = response.then().log().all();
        vr.statusCode(404);

    }
}
