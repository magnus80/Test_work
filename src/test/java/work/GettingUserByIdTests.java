package work;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import rs.ApiResponse;
import rs.service.UserApiService;

import static io.restassured.RestAssured.given;
import static rs.TestData.getCorrectUser;
import static rs.condition.Conditions.statusCode;

@Story("Getting users")
public class GettingUserByIdTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();

    @Test(description = "Getting the list of all users")
    public void testCanGetUserByCorrectId() {
        ApiResponse response = userApiService.addUser(getCorrectUser());
        response.shouldHave(statusCode(200));
    }
}
