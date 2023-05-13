package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.RegisterPage;

public class RegisterSteps {
    @Steps
    RegisterPage register;

    @Given("user has endpoint for create user register")
    public void userHasEndpointForCreateUserRegister() {
        register.setEndpointRegister();
    }

    @When("user send endpoint for create user register")
    public void userSendEndpointForCreateUserRegister() {
        register.sendEndpointRegister();
    }

    @Then("user get status code {int}")
    public void userGetStatusCode(int arg0) {
    register.responseCode();
    }

    @And("I receive valid data user register")
    public void iReceiveValidDataUserRegister() { register.validateDataRegister();
    }

    @When("user send request to invalid endpoint for create user register")
    public void userSendRequestToInvalidEndpointForCreateUserRegister() {
        register.sendReqToInvalidRegister();
    }

    @Then("user see error status code {int}")
    public void userSeeErrorStatusCode(int arg0) {
        register.seeErrorCode();
    }

    @Given("user set invalid endpoint for create user register")
    public void userSetInvalidEndpointForCreateUserRegister() { register.setInvRegister();
    }
}
