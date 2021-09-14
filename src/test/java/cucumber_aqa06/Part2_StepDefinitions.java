package cucumber_aqa06;

import baseEntities.BaseGUIStep;
import cucumber_aqa06.support.MyWebDriver;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pages.LoginPage;
import steps_Anna.CaseStep;


import java.awt.*;

public class Part2_StepDefinitions extends BaseGUIStep {

    public Part2_StepDefinitions(MyWebDriver webDriver) {
        super(webDriver);
    }

    @Step
    @Then("log in with incorrect credentials {string}, {string}")
    public void logInWithIncorrectCredentialsTest(String login, String psw) {
        LoginPage loginPage = new LoginPage(webDriver, false);
        loginPage.setUsername(login);
        loginPage.setPassword(psw);
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Step
    @Then("insert outbound values")
    public void insertOutboundValuesTest() {
        String randomChars = RandomStringUtils.randomAlphanumeric(255);
        LoginPage loginPage = new LoginPage(webDriver, false);
        loginPage.setUsername(randomChars);
        loginPage.setPassword(props.getPassword());
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Field Email/User is too long (250 characters at most).");
    }

    @Step
    @Then("upload a file to a test case in a project")
    public void testCaseWithUploadedPictureTest() throws AWTException {
        CaseStep caseStep = new CaseStep(webDriver)
                .addTestCaseWithFile(props.getProjectName());
        Assert.assertEquals(caseStep.getCaseOverviewPage().getMessageSuccess().getText(), "Successfully added the new test case. Add another");
    }
}