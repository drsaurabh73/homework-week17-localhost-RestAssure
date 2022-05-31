package com.localhost.categories;

import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteTest extends TestBase {

    @Test
    public void setDeleteCategories() {

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 00554466)
                .when()
                .delete("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
