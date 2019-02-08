package work;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import rs.ApiResponse;
import rs.condition.Conditions;
import rs.entity.User;
import rs.service.UserApiService;

@Story("Creating users")
public class CreatingUserTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();

    @Test(description = "Creating different types of users", dataProvider = "getUserData")
    public void testCanCreateCorrectUser(User user) {
        ApiResponse response = userApiService.addUser(user);
        response.shouldHave(Conditions.statusCode(200));
       /* String createdId = DBChecks.getCreatedId();
        MatcherAssert.assertThat(createdId, notNullValue());*/
    }

    @Test(description = "Registering user with empty body")
    public void testCanNotCreateUser() {
        ApiResponse response = userApiService.addUserWithEmptyBody();
        response.shouldHave(Conditions.statusCode(200));
    }

}
