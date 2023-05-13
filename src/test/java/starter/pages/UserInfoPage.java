package starter.pages;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UserInfoPage {
    protected static String email="nisauzz@gmail.com";
    protected static String password="nisa";
    public String token ="";

    public String auth = "https://altashop-api.fly.dev/api/auth";

    @Step
    public String setEndpointAuth(){
        return auth + "/login";
    }

    @Step
    public void sendEnpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step
    public String setEndpointUserInfo(){
        return auth + "/info";
    }

    @Step
    public String invalidAuthLogin() {return auth + "infor";
    }
    @Step
    public void sendEnpointUserInfo(){
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointUserInfo());
    }

    @Step
    public void responseCode() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void sendReqToInvalid() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointUserInfo());
    }

    @Step
    public void errorCode() {
            restAssuredThat(response -> response.statusCode(401));
    }
}
