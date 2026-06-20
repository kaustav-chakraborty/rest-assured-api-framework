package client;

import io.restassured.response.Response;
import specifications.RequestSpec;


import static io.restassured.RestAssured.given;

public class RestClient {

    public Response get(String endpoint) {
        return given()
                .spec(RequestSpec.getRequestSpec())
                .when()
                .get(endpoint);
    }

    public Response post(String endpoint, Object payload) {
        return given()
                .spec(RequestSpec.getRequestSpec())
                .body(payload)
                .when()
                .post(endpoint);
    }
}
