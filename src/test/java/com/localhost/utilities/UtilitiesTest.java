package com.localhost.utilities;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UtilitiesTest extends TestBase {

    @Test
    public void getListOfAllversion() {
        Response response = given()
                .when()
                .get("/version");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
