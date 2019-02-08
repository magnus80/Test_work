package rs;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import rs.condition.Condition;

@Slf4j
public class ApiResponse {

    private Response response;

    public ApiResponse(Response response) {
        this.response = response;
    }

    @Step("Response should have {0}")
    public void shouldHave(Condition condition) {

        condition.check(response);
    }

    public <T> T as(Class<T> aClass) {
        return response.as(aClass);
    }

    public int getBodySize() {
        int wer = response.getBody().asString().length();
        return wer;
    }

    public String getBodyField(String jsonPath) {
        return response.getBody().jsonPath().get(jsonPath).toString();

    }

}
