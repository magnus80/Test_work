package work;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import rs.service.UserApiService;

import static io.restassured.RestAssured.baseURI;
import static rs.TestData.*;

public class BaseTest {

    private UserApiService userApiService = new UserApiService();

    @BeforeSuite
    public void setUp() {
        baseURI = "http://localhost:28080/rs/users";
        // userId = parseInt(response.getBodyField("ID").get(0))
    }

    @DataProvider
    public Object[][] getUserData() {
        return new Object[][]{
                {getLongNameUser()},
                {getEmptyFirstNameUser()},
                {getEmptyLastNameUser()},
                {getEmptyUser()}
        };
    }

    @DataProvider
    public Object[][] getUserIds() {
        return new Object[][]{
                {2},
                {2342342},
                {-1}
        };
    }

}
