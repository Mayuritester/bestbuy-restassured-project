package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

//    21. Extract the limit
@Test
public void test001 () {
    int limit = response.extract().path("limit");


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : " + limit);
    System.out.println("------------------End of Test---------------------------");

}
//22. Extract the total
@Test
public void test002() {
    int total = response.extract().path("total");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Total is : " + total);
    System.out.println("------------------End of Test---------------------------");

}

//23. Extract the name of 5th product
@Test
public void test003() {
    String nameof5thProduct = response.extract().path("data[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name is : " + nameof5thProduct);
    System.out.println("------------------End of Test---------------------------");

}

//24. Extract the names of all the products
@Test
public void test004() {
    List<String> nameOfProduct = response.extract().path("data.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Store names are: " + nameOfProduct);
    System.out.println("------------------End of Test---------------------------");

}

//25. Extract the productId of all the products
@Test
public void test005() {
    List <Integer> lsitOfStoreName = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Store names are: " + lsitOfStoreName);
    System.out.println("------------------End of Test---------------------------");

}
//26. Print the size of the data list
@Test
public void test006() {
    List <String> sizeOfData = response.extract().path("data");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of the data is : " + sizeOfData.size());
    System.out.println("------------------End of Test---------------------------");
}
//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
@Test
public void test007() {
    List <HashMap> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The values for product name 'Energizer - MAX Batteries AA (4-Pack)' are: " + values);
    System.out.println("------------------End of Test---------------------------");
}

//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2- pack)
@Test
public void test008() {
    Object model = response.extract().path("data[8].model");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("model number is: " + model);
    System.out.println("------------------End of Test---------------------------");

}

//29. Get all the categories of 8th products
@Test
public void test009() {
    List <?> allCat = response.extract().path("data[7].categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All categories are : " + allCat);
    System.out.println("------------------End of Test---------------------------");
}

//30. Get categories of the store where product id = 150115
@Test
public void test010() {
    List <?> allCat1 = response.extract().path("data[3].categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All categories are : " + allCat1);
    System.out.println("------------------End of Test---------------------------");
}
//31. Get all the descriptions of all the products
@Test
public void test011() {
    List <?> description = response.extract().path("data.description");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All the description : " + description);
    System.out.println("------------------End of Test---------------------------");
}
//32. Get id of all the all categories of all the products
@Test
public void test012() {
    List <?> allIds = response.extract().path("data.categories.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All the Ids : " + allIds);
    System.out.println("------------------End of Test---------------------------");
}
//33. Find the product names Where type = HardGood
@Test
public void test019() {
    List <?> productNames = response.extract().path("data.findAll {it.type == 'HardGood'}.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Product Names : " + productNames);
    System.out.println("------------------End of Test---------------------------");
}
//34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)

    @Test
    public void test020() {
        List <?> value = response.extract().path("data[1].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" total categories are : " + value.size());
        System.out.println("------------------End of Test---------------------------");
    }

//35. Find the createdAt for all products whose price < 5.49
@Test
public void test021() {
    List <String> productName =  response.extract().path("data.findAll{it.price < 5.49}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of products that price is less than 5.49 are: " + productName);
    System.out.println("------------------End of Test---------------------------");
}

//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4- pack)
@Test
public void test22() {
    List<String> categories = response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}.categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack) : " +categories);
    System.out.println("------------------End of Test---------------------------");
}

// 36. Find the manufacturer of all the products
@Test
public void test23() {
    List<String> manufacture = response.extract().path("data.manufacturer");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("manufeturer names are  : " + manufacture);
    System.out.println("------------------End of Test---------------------------");
}
//38. Find the image of products whose manufacturer is = Energizer
@Test
public void test24() {
    List<String> manufectureImage = response.extract().path("data.findAll{it.name =='Energizer'}.manufacturer");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The image are: " + manufectureImage);
    System.out.println("------------------End of Test---------------------------");
}
//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void test25() {
    List <String> productName =  response.extract().path("data.findAll{it.price > 5.49}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of products that price is less than 5.49 are: " + productName);
    System.out.println("------------------End of Test---------------------------");
}
// 40. Find the uri of all the products
@Test
public void test26() {
    List<String> url = response.extract().path("data.url");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The URLs are: " +url);
    System.out.println("------------------End of Test---------------------------");
}
}
