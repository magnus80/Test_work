package work;

import org.testng.annotations.BeforeSuite;
import rs.ApiResponse;
import rs.condition.Conditions;
import rs.service.UserApiService;

import static io.restassured.RestAssured.baseURI;
import static rs.TestData.getCorrectUser;

public class BaseTest {

    static final int INCORRECT_ID = 4545;

    @BeforeSuite
    public void setUp() {
        baseURI = "http://localhost:28080/rs/users";

    }
}
