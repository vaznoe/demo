package com.company.demo;

import com.company.demo.entity.Address;
import com.company.demo.repository.AddressRepository;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressTests {

    @LocalServerPort
    private int port;

    @Autowired
    private AddressRepository addressRepository;

    @Before
    public void init() {
        RestAssured.port = port;
    }

    @Test
    public void getAddressesTest() {
        Address address = addressRepository.save(getAddress());
        given().pathParam("id", address.getId())
                .when()
                .get( "/addresses/{id}")
                .then()
                .assertThat()
                .body("zipCode", equalTo("90027"));
    }

    @Test
    public void addressControllerPostTest() {
        given().contentType("application/json")
                .body(getAddress())
                .when()
                .post("/addresses/add")
                .then()
                .assertThat()
                .body("city", equalTo("Los Angeles"));
    }

    @Test
    public void addressControllerUpdateTest() {
        Address address = addressRepository.save(getAddress());
        address.setCity("Hollywood");

        given().contentType("application/json")
                .body(address)
                .when()
                .put("/addresses/put")
                .then()
                .assertThat()
                .body("city", equalTo("Hollywood"));

        given().pathParam("id", address.getId())
                .when()
                .get("/addresses/{id}")
                .then()
                .assertThat()
                .body("city", equalTo("Hollywood"));
    }

    @Test
    public void addressControllerGetAllAddressesTest() {
        List response = given()
                .contentType("application/json")
                .when()
                .get("/addresses/all").as(List.class);

        int size = response.size();
        given().contentType("application/json")
                .body(getAddress())
                .when()
                .post("/addresses/add");

        List response2 = given()
                .contentType("application/json")
                .when()
                .get("/addresses/all").as(List.class);
        assertTrue(response2.size() == size + 1);
    }

    @Test
    public void addressControllerDeleteAddressTest() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        given().contentType("application/json")
                .pathParam("id", addresses.get(0).getId())
                .when()
                .delete("/addresses/{id}");

        List<Address> addresses1 = (List<Address>) addressRepository.findAll();

        assertTrue(addresses1.size() == addresses.size() - 1);
    }

    private Address getAddress() {
        Address address = new Address();
        address.setAddress("2015 Hollywood Blvd");
        address.setCity("Los Angeles");
        address.setState("CA");
        address.setZipCode("90027");
        return address;
    }
}
