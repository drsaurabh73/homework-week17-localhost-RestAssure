package com.localhost.categories;

import com.localhost.model.CategoriesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPostTest extends TestBase {

    @Test
    public void setCategoriesTest() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Gift Ideas");
        categoriesPojo.setId("00554466");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.prettyPrint();
        response.then().statusCode(201);

    }
}
