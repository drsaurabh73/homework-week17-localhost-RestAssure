package com.localhost.Storeinfo;

import com.localhost.model.StoresPojo;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StorePatchTest extends TestBase {

    @Test
    public void setPatchStore() {
        HashMap<Object, Object> store = new HashMap<>();
        store.put("createdAt", "2016-11-17T17:57:05.708Z");
        store.put("updatedAt", "2016-11-17T17:57:05.708Z");

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Minnetonka");
        storesPojo.setType("Small  Box");
        storesPojo.setAddress("Eastle Street");
        storesPojo.setAddress2("Coventry University Road");
        storesPojo.setCity("Coventry");
        storesPojo.setState("West Midland");
        storesPojo.setZip("554466");
        storesPojo.setLat(456);
        storesPojo.setLng(897);
        storesPojo.setServices(store);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id", 8922)
                .body(storesPojo)
                .when()
                .patch("/stores/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
