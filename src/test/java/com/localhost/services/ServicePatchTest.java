package com.localhost.services;

import com.localhost.model.ServicesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicePatchTest extends TestBase {

    @Test
    public void setServicePatchTest() {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Customer Telephone Services");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 22)
                .body(servicesPojo)
                .when()
                .patch("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }

}
