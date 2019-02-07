package rs.condition;

import org.hamcrest.Matcher;

public class Conditions {

    public static Condition statusCode(int statusCode) {
        return new StatusCodeCondition(statusCode);
    }

    public static BodyFieldCondition bodyField(String jsonPath, Matcher matcher){
        return new BodyFieldCondition(jsonPath,matcher);
    }
}
