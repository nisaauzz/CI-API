package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterPage {
    public String register = "https://altashop-api.fly.dev/api/auth/register";

    public String registerInvalid = "https://altashop-api.fly.dev/api/auth/registers";

    @Step
    public String setEndpointRegister() {
        return register;
    }
    @Step
    public String setInvRegister() {
        return registerInvalid;
    }

    @Step
    public void sendEndpointRegister() {
        String email = "nisa5@gmail.com";
        String password = "nisa";
        String fullname = "Nisa' Uzzulfa";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"fullname\":" + fullname + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointRegister());
    }

    @Step
    public void responseCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void validateDataRegister() {
        Response response = SerenityRest.lastResponse();
        String Email = response.getBody().jsonPath().get("data.Email");
        String Password = response.getBody().jsonPath().get("data.Password");
        Assert.assertEquals(Email, "nisa5@gmail.com");
        Assert.assertEquals(Password, "nisa");
    }

    public void sendReqToInvalidRegister() {
        String email = "nisa3@gmail.com";
        String password = "nisa";
        String fullname = "Nisa' Uzzulfa";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"fullname\":" + fullname + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setInvRegister());
    }

    public void seeErrorCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

}
