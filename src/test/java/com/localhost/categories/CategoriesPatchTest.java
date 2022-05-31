package com.localhost.categories;

import com.localhost.model.CategoriesPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPatchTest extends TestBase {

    @Test
    public void setPatchCategoiresTest() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Gift Paper Ideas");
        categoriesPojo.setId("00554466");

            Response response = given()
                    .header("Content-Type", "application/json")
                    .pathParam("id", "00554466")
                    .body(categoriesPojo)
                    .when()
                    .patch("/categories/{id}");
            response.prettyPrint();
            response.then().statusCode(200);


    }
}
