package com.localhost.services;

import com.localhost.model.ServicesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicePostTest extends TestBase {

    @Test
    public void setServicesPostTest() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Customer Services");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.prettyPrint();
        response.then().statusCode(201);

    }
}