package rs.service;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import rs.ApiResponse;
import rs.entity.User;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.valueOf;
import static java.lang.String.format;
import static java.lang.System.getProperty;

@Slf4j
public class UserApiService {

    private RequestSpecification given() {
        List<Filter> filters = new ArrayList<>();
        if (valueOf(getProperty("EnableLogging", "false"))) {
            filters.add(new RequestLoggingFilter());
            filters.add(new ResponseLoggingFilter());
        }
        filters.add(new AllureRestAssured());

        return RestAssured.given()
                .filters(filters);
    }

    @Step("Registering user {0}")
    public ApiResponse addUser(User user) {
        log.info("Registering user {}", user);

        Response response = given()
                .body(user)
                .when()
                .post()
                .then()
                .extract().response();
        return new ApiResponse(response);
    }

    @Step("Registering user with empty body")
    public ApiResponse addUserWithEmptyBody() {
        log.info("Registering user with empty body");

        Response response = given()
                .body("")
                .when()
                .post()
                .then()
                .extract().response();
        return new ApiResponse(response);
    }


    @Step("Deleting user with id {0}")
    public ApiResponse deleteUser(int userId) {
        log.info("Deleting user with id {}", userId);

        Response response = given()
                .when()
                .delete(format("/%d", userId))
                .then()
                .extract().response();
        return new ApiResponse(response);
    }

    @Step("Updating user with id {0}")
    public ApiResponse updateUser(int userId) {
        log.info("Updating user with id {}", userId);

        Response response = given()
                .when()
                .delete(format("/%d", userId))
                .then()
                .extract().response();
        return new ApiResponse(response);
    }

    @Step("Getting all existing users")
    public ApiResponse getAllUsers() {
        log.info("Getting all existing users");

        Response response = given()
                .when()
                .get()
                .then()
                .extract().response();
        return new ApiResponse(response);
    }

    @Step("Getting user by Id")
    public ApiResponse getUserById(int userId) {
        log.info("Getting all existing users");

        Response response = given()
                .when()
                .get(format("/%d", userId))
                .then()
                .extract().response();
        return new ApiResponse(response);
    }
}
