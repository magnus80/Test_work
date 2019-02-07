package rs.condition;

import io.restassured.response.Response;

public abstract class Condition {

    public abstract void check(Response response);
}
