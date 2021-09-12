package cucumber_aqa06;

import baseEntities.BaseGUIStep;
import core.ReadProperties;
import cucumber_aqa06.support.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import steps_Anna.CaseStep;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;

import java.awt.*;

public class Part2_StepDefinitions extends BaseGUIStep {
    LoginStep loginStep;
    ReadProperties props = ReadProperties.getInstance();

    public Part2_StepDefinitions(MyWebDriver webDriver) {
        super(webDriver);
    }

    @Step
    @When("Anna's login page is opened")
    public void loginPageIsOpened() {
        loginStep = new LoginStep(webDriver);
    }

    @Step
    @And("successfulSignIn")
    public void successfulSignIn() {
        loginStep.correctLogin(props.getLogin(), props.getPassword());
    }

    @Step
    @When("Project is created")
    public void projectIsCreated() {
        CaseStep caseStep = new ProjectStep(webDriver)
                .addProjectWithFutureTestCase(props.getProjectName(), props.getAnnouncementMessage());
    }

    @Step
    @Then("log in with incorrect credentials {string}, {string}")
    public void logInWithIncorrectCredentials(String login, String psw) {
        loginStep.incorrectLogin(login, psw);
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText().trim(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Step
    @Then("insert outbound values")
    public void insertOutboundValues() {
        String randomChars = RandomStringUtils.randomAlphanumeric(255);
        loginStep.incorrectLogin(randomChars, props.getPassword());
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText().trim(), "Field Email/User is too long (250 characters at most).");
    }

    @Step
    @Then("Create a test case in a project with an uploaded picture")
    public void createATestCaseInAProjectWithAnUploadedPicture() throws AWTException, InterruptedException {
        CaseStep caseStep = new CaseStep(webDriver)
                .addTestCaseWithFile(props.getProjectName());
        Assert.assertEquals(caseStep.getCaseOverviewPage().getMessageSuccess().getText(), "Successfully added the new test case. Add another");
    }
}