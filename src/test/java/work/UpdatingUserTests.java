package work;

import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rs.ApiResponse;
import rs.service.UserApiService;

import static rs.TestData.getCorrectUser;
import static rs.condition.Conditions.statusCode;

@Story("Updating users")
public class UpdatingUserTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();
    private int userId;
    private static final int INCORRECT_ID = 45565656;

    @BeforeClass
    public void setUp() {
        if (0 == userApiService.getAllUsers().getBodySize()) {
            ApiResponse response = userApiService.addUser(getCorrectUser());
            response.shouldHave(statusCode(200));
        }
    }

    /**
     *
     */
    @Test(description = "Can update user with correct id", alwaysRun = false)
    public void testCanDeleteCorrectUser() {
        ApiResponse response = userApiService.deleteUser(userId);
        response.shouldHave(statusCode(200));
    }

    @Test(description = "Can update user with incorrect id")
    public void testCanDeleteIncorrectUser() {
        ApiResponse response = userApiService.updateUser(INCORRECT_ID);
        response.shouldHave(statusCode(200));
    }
}
