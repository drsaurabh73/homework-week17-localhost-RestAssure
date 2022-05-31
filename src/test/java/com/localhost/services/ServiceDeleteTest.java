package com.localhost.services;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServiceDeleteTest extends TestBase {

    @Test
    public void setDeleteServices() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 22)
                .when()
                .delete("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);


    }
}
