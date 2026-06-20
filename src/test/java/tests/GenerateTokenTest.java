package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GenerateTokenTest {

    @Test
    public void generateToken(){
        String body = """
    {
        "username":"admin",
        "password":"password123"
    }
    """;
        Response response=given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(body)
                .when()
                .post("/auth");
        response.prettyPrint();
        String token = response.jsonPath().getString("token");

        System.out.println(token);
    }
}
