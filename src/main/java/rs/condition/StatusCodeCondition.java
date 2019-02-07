package rs.condition;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StatusCodeCondition extends Condition {

    private int statusCode;

    StatusCodeCondition(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void check(Response response) {
        assertThat(response.statusCode(), equalTo(statusCode));
    }
}
