package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createBookingsTest {

    @Test
    public void createBooking(){
        String body="""
            {
                "firstname":"Kaustav",
                "lastname":"Chakraborty",
                "totalprice":500,
                "depositpaid":true,
                "bookingdates":{
                    "checkin":"2026-06-16",
                    "checkout":"2026-06-20"
                },
                "additionalneeds":"Breakfast"
            }
            """;
        Response response=given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(body)
                .when()
                .post("/booking");
                response.prettyPrint();
                response.then().statusCode(200);


     int bookingid=response.jsonPath().getInt("bookingid");
    }
}
