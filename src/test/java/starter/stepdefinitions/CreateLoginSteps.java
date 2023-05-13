package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.CreateLoginPage;

public class CreateLoginSteps {

    @Steps
    CreateLoginPage login;

    @Given("user has endpoint for create login user")
    public void userHasEndpointForCreateLoginUser() {
        login.setEndpointLogin();
    }

    @When("user send request for create login user")
    public void userSendRequestForCreateLoginUser() {
        login.sendEndpointLogin();
    }

    @Then("get response with status code {int}")
    public void getResponseWithStatusCode(int arg0) {
        login.responseCodeStatus();
    }

    @And("I receive valid data user login")
    public void iReceiveValidDataUserLogin() { login.validateDataLogin();
    }
}
