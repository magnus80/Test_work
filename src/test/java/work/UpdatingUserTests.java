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
    @Test(description = "Can update user with correct id", dataProvider = "getUserIds")
    public void testCanDeleteCorrectUser(int id) {
        ApiResponse response = userApiService.deleteUser(id);
        response.shouldHave(statusCode(200));
    }

}
