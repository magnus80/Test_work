package work;

import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rs.ApiResponse;
import rs.service.UserApiService;

import static rs.TestData.getCorrectUser;
import static rs.condition.Conditions.statusCode;

@Story("Deleting users")
public class DeletingUserTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();
    private int userId;
    private static final int INCORRECT_ID = 4545;

    @BeforeClass
    public void setUp() {
        if (0 == userApiService.getAllUsers().getBodySize()) {
            ApiResponse response = userApiService.addUser(getCorrectUser());
            response.shouldHave(statusCode(200));
            //userId = parseInt(response.getBodyField("ID").get(0).toString());
        }
    }

    @Test(description = "Can delete user with correct id", dataProvider = "getData")
    public void testCanDeleteCorrectUser() {
        if (userApiService.getAllUsers().getBodyField("ID").isEmpty()) {
            ApiResponse response = userApiService.addUser(getCorrectUser());
            response.shouldHave(statusCode(200));
            //userId = parseInt(response.getBodyField("ID").get(0).toString());
        }

        ApiResponse response = userApiService.deleteUser(userId);
        response.shouldHave(statusCode(200));
    }

    @Test(description = "Can delete user with incorrect id")
    public void testCanDeleteIncorrectUser() {
        ApiResponse response = userApiService.deleteUser(INCORRECT_ID);
        response.shouldHave(statusCode(200));
    }


}
