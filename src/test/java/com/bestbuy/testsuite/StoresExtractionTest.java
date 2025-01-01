package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
//  1. Extract the limit
        @Test
        public void test001 () {
            int limit = response.extract().path("limit");


            System.out.println("------------------StartingTest---------------------------");
            System.out.println("The value of limit is : " + limit);
            System.out.println("------------------End of Test---------------------------");

        }

//2. Extract the total
@Test
public void test002() {
    int total = response.extract().path("total");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Total is : " + total);
    System.out.println("------------------End of Test---------------------------");

}
//3. Extract the name of 5th store
@Test
public void test003() {
    String storeName = response.extract().path("data[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Store name is: " + storeName);
    System.out.println("------------------End of Test---------------------------");

}
//4. Extract the names of all the store
@Test
public void test004() {
    List <String> lsitOfStoreName = response.extract().path("data.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Store names are: " + lsitOfStoreName);
    System.out.println("------------------End of Test---------------------------");

}
//5. Extract the storeId of all the store
@Test
public void test005() {
    List <Integer> allStoreIds = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Store Ids are: " + allStoreIds);
    System.out.println("------------------End of Test---------------------------");

}
//6. Print the size of the data list
@Test
public void test006() {
    List <String> sizeOfData = response.extract().path("data");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of the data is : " + sizeOfData.size());
    System.out.println("------------------End of Test---------------------------");
}

//7. Get all the value of the store where store name = St Cloud
@Test
public void test007() {
    List <HashMap> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The values for product name 'St Cloud' are: " + values);
    System.out.println("------------------End of Test---------------------------");
}

//8. Get the address of the store where store name = Rochester

    @Test
    public void test008() {
        String storeAddress = response.extract().path("data[8].address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store address of Rochester is : " + storeAddress);
        System.out.println("------------------End of Test---------------------------");
    }

//9. Get all the services of 8th store
@Test
public void test009() {
    List <?> allServicesOfStore8 = response.extract().path("data[7].services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All Services of store 8 are : " + allServicesOfStore8);
    System.out.println("------------------End of Test---------------------------");
}

//10. Get storeservices of the store where service name = Windows Store
@Test
public void test010() {
    List <Integer> allServicesOfStore8 = response.extract().path("data.findAll{it.name == 'Windows Store'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All Services of store 8 are : " + allServicesOfStore8);
    System.out.println("------------------End of Test---------------------------");
}

//11. Get all the storeId of all the store
@Test
public void test011() {
    List <?> allStoreIds = response.extract().path("data.services.storeservices.storeId");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All Ids are : " + allStoreIds);
    System.out.println("------------------End of Test---------------------------");
}


//12. Get id of all the store
@Test
public void test012() {
    List <?> allStoreIds = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All Ids are : " + allStoreIds);
    System.out.println("------------------End of Test---------------------------");
}



//13. Find the store names Where state = ND
@Test
public void test013() {
    List <String> state = response.extract().path("data.findAll{it.state == 'ND'}.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("store name where state = ND: " + state);
    System.out.println("------------------End of Test---------------------------");
}


//14. Find the Total number of services for the store where store name = Rochester
@Test
public void test014() {
    List <Integer> totalservices = response.extract().path("data[8].services");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("total services are: " + totalservices.size());
    System.out.println("------------------End of Test---------------------------");
}

//15. Find the createdAt for all services whose name = “Windows Store”
@Test
public void test015() {
    List <?> createdAt = response.extract().path("data.findAll {it.name.startsWith('Win')}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("createdAT are: " +  createdAt );
    System.out.println("------------------End of Test---------------------------");
}
// 16. Find the name of all services Where store name = “Fargo”

    @Test
    public void test016() {
        List <?> services = response.extract().path("data.findAll {it.name == 'Fargo'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Services of Fargo are : " +  services );
        System.out.println("------------------End of Test---------------------------");
    }

// 17. Find the zip of all the store
@Test
public void test017() {
    List <?> zipcode = response.extract().path("data.zip");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All the Zip codes are : " +  zipcode );
    System.out.println("------------------End of Test---------------------------");
}
//18. Find the zip of store name = Roseville
@Test
public void test018() {
    List <?> rosevillezipcode = response.extract().path("data[2].zip");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Zip codes of RoseVille is : " +  rosevillezipcode );
    System.out.println("------------------End of Test---------------------------");
}

//19. Find the storeservices details of the service name = Magnolia Home
@Test
public void test019() {
    List <?> servicesOfMagnolia = response.extract().path("data.findAll {it.name == 'Magnolia Home Theater'}.services");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Zip codes of RoseVille is : " + servicesOfMagnolia);
    System.out.println("------------------End of Test---------------------------");
}


//20. Find the lat of all the stores
@Test
public void test020() {
    List <?> latValues = response.extract().path("data.lat");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Lat of all the stores are : " + latValues);
    System.out.println("------------------End of Test---------------------------");
}



}
