package com.localhost.Storeinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreIdGetTest extends TestBase {

    @Test
    public void setStoreIdGetTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 8923)
                .when()
                .get("/stores/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }


}
