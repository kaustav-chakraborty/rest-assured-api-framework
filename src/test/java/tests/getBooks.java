package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getBooks {

    @Test
    public void booking() {

        Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking/1");

        response.then().statusCode(200);

        response.prettyPrint();
    }
}