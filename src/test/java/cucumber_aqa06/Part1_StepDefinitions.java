package cucumber_aqa06;


import baseEntities.BaseGUIStep;

import core.ReadProperties;
import cucumber_aqa06.support.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import steps_Boris.DashboardSteps;
import steps_Boris.LoginStep;


public class Part1_StepDefinitions extends BaseGUIStep {
    ReadProperties props = ReadProperties.getInstance();
    LoginStep loginStep;
    DashboardSteps dashboardSteps;

    public Part1_StepDefinitions(MyWebDriver webDriver) {
        super(webDriver);
    }

    @Given("browser is started")
    public void startBrowser() {
    }

    @When("Boris' login page is opened")
    public void loginPageIsOpened() {
        loginStep = new LoginStep(webDriver);
    }

    @When("dashboard page is opened")
    public void dashboardPageIsOpened() {
        dashboardSteps = new DashboardSteps(webDriver);
    }

    @Then("log in with correct credentials")
    public void successfulLoginTest() {
        loginStep.successfulLogin(props.getLogin(), props.getPassword());
        Assert.assertEquals(loginStep.getDashboardPage().getDashboardButtonText(), "DASHBOARD");
    }

    @Then("border value in the email input while signing in")
    public void borderValueTest() {
        String randomChars = RandomStringUtils.randomAlphanumeric(250);
        loginStep.failedLogin(randomChars, props.getPassword());
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Then("pop-up message check")
    public void checkOfPopUpMessage() {
        dashboardSteps.clickOnPopUpMessage();
        Assert.assertTrue(dashboardSteps.getDashboardPage().getInProgressElement().isDisplayed());
    }

    @Then("dialogue box check")
    public void checkOfDialogueBox() {
        dashboardSteps.clickOnDialogueBox();
        Assert.assertEquals(dashboardSteps.getDashboardPage().textInTimeFrame().getText(), "Select a different time frame for the chart.");
    }
}


