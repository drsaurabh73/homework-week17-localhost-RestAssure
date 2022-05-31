package com.localhost.utilities;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HealthCheckTest extends TestBase {

    @Test
    public void getListOfAllversion() {
        Response response = given()
                .when()
                .get("/healthcheck");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
