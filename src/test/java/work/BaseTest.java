package work;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import rs.ApiResponse;
import rs.service.UserApiService;

import static io.restassured.RestAssured.baseURI;
import static rs.TestData.*;
import static rs.condition.Conditions.statusCode;

public class BaseTest {

    private UserApiService userApiService = new UserApiService();

    @BeforeSuite
    public void setUp() {
        baseURI = "http://localhost:28080/rs/users";
        if (userApiService.getAllUsers().getBodyField("ID").isEmpty()) {
            ApiResponse response = userApiService.addUser(getCorrectUser());
            response.shouldHave(statusCode(200));
            // userId = parseInt(response.getBodyField("ID").get(0));
        }

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {getLongNameUser()},
                {getEmptyFirstNameUser()},
                {getEmptyLastNameUser()},
                {getEmptyUser()}
        };
    }
}
