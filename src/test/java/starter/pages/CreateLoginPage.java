package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateLoginPage {
    public String loginEndpoint = "https://altashop-api.fly.dev/api/auth/login";

    @Step("I have endpoint post new user")
    public String setEndpointLogin(){
        return loginEndpoint;
    }

    @Step ("I send post new user")
    public void sendEndpointLogin(){
        String email = "nisa@gmail.com";
        String password = "nisa";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointLogin());
    }

    public void responseCodeStatus() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateDataLogin() {
        Response response = SerenityRest.lastResponse();
        String data = response.getBody().jsonPath().get("data");
        Assert.assertEquals(data, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6Ik5pc2EiLCJFbWFpbCI6Im5pc2FAZ21haWwuY29tIn0.8GZeSCzwsPIdVEuUPOq-t1gen8T0i-lD7Lhidnxnr8s");
    }
}
