package work;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rs.entity.User;
import rs.service.UserApiService;

import static rs.TestData.*;

public class CreatingUserTests extends BaseTest {

    private UserApiService userApiService = new UserApiService();

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {getLongNameUser()},
                {getEmptyFirstNameUser()},
                {getEmptyLastNameUser()},
                {getEmptyUser()}
        };
    }

    @Test(description = "Creating different types of users", dataProvider = "getData")
    public void testCanCreateCorrectUser(User user) {
        userApiService.addUser(user);
    }
}
