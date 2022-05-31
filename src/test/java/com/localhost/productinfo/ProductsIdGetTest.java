package com.localhost.productinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsIdGetTest extends TestBase {

    @Test
    public void setProductIdGetTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 9999682)
                .when()
                .get("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}