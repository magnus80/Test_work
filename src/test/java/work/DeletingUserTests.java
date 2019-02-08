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

    @Test(description = "Can delete user with incorrect id", dataProvider = "getUserIds")
    public void testCanDeleteIncorrectUser(int id) {
        ApiResponse response = userApiService.deleteUser(id);
        response.shouldHave(statusCode(200));
    }


}
