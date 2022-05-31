package com.localhost.Storeinfo;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreDeleteTest extends TestBase {

    @Test
    public void setProductDelete() {

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 8923)
                .when()
                .delete("/stores/{id}");
        response.prettyPrint();
        response.then().statusCode(200);


    }

}
