package tests;

import io.restassured.response.Response;
import models.BookingDates;
import models.Bookings;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking {

    @Test
    public void updateBookings() {

        int bookingId = 2666;

        String token = "31f539973eab11b";

        BookingDates bookingDates = new BookingDates(
                "2026-06-18",
                "2026-06-25"
        );

        Bookings updatedBooking = new Bookings(
                "Kaustav",
                "Chakraborty",
                800,
                true,
                bookingDates,
                "Lunch"
        );

        Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(updatedBooking)
                .when()
                .put("/booking/" + bookingId);

        response.prettyPrint();

        response.then().statusCode(200);
    }
}