package rs.condition;

import io.restassured.response.Response;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;

public class BodyFieldCondition extends Condition {

    private String jsonPath;
    private Matcher matcher;

    public BodyFieldCondition(String jsonPath, Matcher matcher) {
        this.jsonPath = jsonPath;
        this.matcher = matcher;
    }

    @Override
    public void check(Response response) {
        assertThat(response.getBody().jsonPath().get(jsonPath), matcher);
    }
}
