package com.company.demo;

import com.company.demo.entity.MyUser;
import com.company.demo.repository.UserRepository;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        RestAssured.port = port;
    }

    @Test
    public void getUserTest() {
        MyUser user = userRepository.save(getUser());
        given().pathParam("id", user.getId())
                .when()
                .get("/user/{id}")
                .then()
                .assertThat()
                .body("lastName", equalTo("White"));
    }

    @Test
    public void userControllerPostTest() {
        given().contentType("application/json")
                .body(getUser())
                .when()
                .post("/user/save")
                .then()
                .assertThat()
                .body("lastName", equalTo("White"));
    }

    private MyUser getUser() {
        MyUser user = new MyUser();
        user.setFirstName("Bob");
        user.setLastName("White");
        user.setAge(32);
        return user;
    }
}
