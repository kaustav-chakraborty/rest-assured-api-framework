package Client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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
