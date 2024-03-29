package work;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import rs.ApiResponse;
import rs.service.UserApiService;

import static rs.condition.Conditions.statusCode;

@Story("Getting users")
public class GettingAllUsersTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();

    @Test(description = "Getting the list of all users")
    public void testCanGetAllUsers() {
        ApiResponse response = userApiService.getAllUsers();
        response.shouldHave(statusCode(200));
    }
}
