package com.localhost.Storeinfo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreGetTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    // 1. Extract the value of limit
    @Test
    public void test001() {

        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    // 2. extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of Total is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test // Extract the name of 5th store
    public void test003() {
        String storename = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th Store is : " + storename);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test //Extract the names of all the store
    public void test004() {
        List<String> allstorename = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store : " + allstorename);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test  // 5. Extract the storeId of all the store
    public void test005() {
        List<Integer> allstoreid = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store : " + allstoreid);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test  // 6. Print the size of the data list
    public void test006() {
        List<String> data = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list : " + data.size());
        System.out.println("------------------End of Test---------------------------");

    }

    @Test  // 7. Get all the value of the store where store name = St Cloud
    public void test007() {
        List<HashMap<String, ?>> storename = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of of the store where store name = St Cloud : " + storename);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test // 8. Get the address of the store where store name = Rochester
    public void test008() {
        List<HashMap<String, ?>> storeaddress = response.extract().path("data.findAll{it.name=='Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester is : " + storeaddress);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test  // 9. Get all the services of 8th store
    public void test009() {
        List<String> services = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all the services of 8th store are : " + services);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test  // 10. Get storeservices of the store where service name = Windows Store
    public void test0010() {
        List<HashMap<String, ?>> storeservices = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices of the store where service name is Windows Store : " + storeservices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test //12 Get id of all the store
    public void test0012() {
        List<String> allstoreid = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeid of the store  is : " + allstoreid);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test // 13 Find the store names Where state = ND
    public void test0013() {
        List<HashMap<String, ?>> statestorename = response.extract().path("data.findAll{it.state=='ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state = ND is : " + statestorename);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test // 14 Find the Total number of services for the store where store name = Rochester
    public void test0014() {
        List<HashMap<String, ?>> numberofservices = response.extract().path("data.findAll{it.name=='Rochester'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of services for the store where store name = Rochester : " + numberofservices);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test // 15. Find the createdAt for all services whose name = “Windows Store”
    public void test0015() {
        List<HashMap<String, ?>> createdservices = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the createdAt for all services whose name = “Windows Store” : " + createdservices);
        System.out.println("------------------End of Test---------------------------");
    }

@Test  // 16. Find the name of all services Where store name = “Fargo”
public void test0016() {
    List<HashMap<String, ?>> nameofservices = response.extract().path("data.findAll{it.name=='Fargo'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of all services Where store name = “Fargo” : " + nameofservices);
    System.out.println("------------------End of Test---------------------------");
}
    @Test  // 17. Find the zip of all the store
    public void test0017() {
        List<String> allstorezip = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of all the store : " + allstorezip);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test  // 18. Find the zip of store name = Roseville
    public void test0018() {
        List<String> zipofRoseville = response.extract().path("data.[2].zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of store name = Roseville : " + zipofRoseville);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test // 20. Find the lat of all the stores
    public void test0020() {
        List<String> latofallstore = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The lat of all the stores : " + latofallstore);
        System.out.println("------------------End of Test---------------------------");
    }
}