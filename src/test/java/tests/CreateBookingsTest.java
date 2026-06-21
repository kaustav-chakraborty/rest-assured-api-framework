package tests;

import io.restassured.response.Response;
import models.BookingDates;
import models.Bookings;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingsTest {

    @Test
    public void createBooking(){
        BookingDates bookingDates=new BookingDates("2026-06-16",
                "2026-06-20");
        Bookings booking = new Bookings(
                "Kaustav",
                "Chakraborty",
                500,
                true,
                bookingDates,
                "Breakfast"
        );
        Response response=given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(booking)
                .when()
                .post("/booking");
                response.prettyPrint();
                response.then().statusCode(200);


     int bookingid=response.jsonPath().getInt("bookingid");
    }
}
