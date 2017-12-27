package com.company.demo;

import com.company.demo.entity.Employee;
import com.company.demo.repository.EmployeeRepository;
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
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeTests {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void init() {
        RestAssured.port = port;
    }

    @Test
    public void getEmployeeTest() {
        Employee employee = employeeRepository.save(getEmployee());
        given().pathParam("id", employee.getId())
                .when()
                .get("/employee/{id}")
                .then()
                .assertThat()
                .body("lastName", equalTo("Markov"));
    }

    @Test
    public void employeeControllerPostTest() {
        given().contentType("application/json")
                .body(getEmployee())
                .when()
                .post("/employee/add")
                .then()
                .assertThat()
                .body("position", equalTo("ETL Developer"));
    }

    @Test
    public void employeeControllerPutTest() {
        Employee employee = employeeRepository.save(getEmployee());
        employee.setPosition("Manager");

        given().contentType("application/json")
                .body(employee)
                .when()
                .put("/employee/put")
                .then()
                .assertThat()
                .body("position", equalTo("Manager"));

        given().pathParam("id", employee.getId())
                .when()
                .get("/employee/{id}")
                .then()
                .assertThat()
                .body("position", equalTo("Manager"));
    }

    @Test
    public void employeeControllerDeleteTest() {
        Employee employee = employeeRepository.save(getEmployee());
        given().pathParam("id", employee.getId())
                .body(employee)
                .when()
                .delete("/employee/delete/{id}")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void employeeControllerGetAllTest() {
        List response = given()
                .contentType("aplication/json")
                .when()
                .get("/employee/all")
                .as(List.class);
        System.out.println(response);
    }

    @Test
    public void employeeControllerFindPositionTest() {
        Employee employee = employeeRepository.save(getEmployee());
        List response = given()
                .pathParam("position", employee.getPosition())
                .body(employee)
                .when()
                .get("/employee/find_position")
                .as(List.class);
        System.out.println(response);
    }

    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Alex");
        employee.setLastName("Markov");
        employee.setExperience("9 years");
        employee.setPosition("ETL Developer");
        employee.setSalary(105000.00);
        return employee;
    }
}
