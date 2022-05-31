package com.localhost.productinfo;

import com.localhost.model.ProductPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase {


    @Test
    public void setproductsPostTest() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Duracell - AAA Batteries (8-Pack)");
        productPojo.setType("HardGood");
        productPojo.setPrice(6);
        productPojo.setShipping(1);
        productPojo.setUpc("041333424019");
        productPojo.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 8-pack");
        productPojo.setManufacturer("Duracell");
        productPojo.setModel("MN2400B4Z");
        productPojo.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.prettyPrint();
        response.then().statusCode(201);

    }
}