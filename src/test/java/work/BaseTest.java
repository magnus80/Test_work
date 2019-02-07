package work;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        baseURI = "http://localhost:28080/rs/users";

    }
}
