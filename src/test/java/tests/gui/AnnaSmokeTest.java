package tests.gui;

import baseEntities.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps_Anna.CaseStep;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;

import java.awt.*;

public class AnnaSmokeTest extends BaseTest {

    @Feature("Login")
    @Test(description = "incorrect login to testrail")
    public void negativeLoginTest() {
        logger.info("negativeLoginTest is started...");
        LoginStep loginStep = new LoginStep(driver)
                .incorrectLogin(properties.getIncorrectLogin(), properties.getIncorrectPassword());
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText().trim(), "Email/Login or Password is incorrect. Please try again.");
        logger.info("negativeLoginTest is finished...");
    }

    @Feature("Login")
    @Test(description = "simulation of login failure")
    public void failLoginTest() {
        logger.info("failLoginTest is started...");
        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText(), "Ooops, failure!");
        logger.info("failLoginTest is finished...");
    }

    @Feature("Login")
    @Test(description = "input of 255 symbols where only 250 is possible")
    public void negativeOutboundCharsLoginTest() {
        logger.info("negativeOutboundCharsLoginTest is started...");
        String randomChars = RandomStringUtils.randomAlphanumeric(255);
        LoginStep loginStep = new LoginStep(driver)
                .incorrectLogin(randomChars, properties.getPassword());
        Assert.assertEquals(loginStep.getLoginPage().getErrorMessageText().trim(), "Field Email/User is too long (250 characters at most).");
        logger.info("negativeOutboundCharsLoginTest is finished...");
    }

    @Features(value = {@Feature("Login"), @Feature("Project"), @Feature("Test Case")})
    @Test(description = "adding a testcase with file(picture)")
    public void createTestCaseWithAttachmentTest() throws AWTException {
        logger.info("createTestCaseWithAttachmentTest is started...");
        CaseStep caseStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword())
                .addProjectWithFutureTestCase(properties.getProjectName(), properties.getAnnouncementMessage())
                .addTestCaseWithFile(properties.getProjectName());
        Assert.assertEquals(caseStep.getCaseOverviewPage().getMessageSuccess().getText(), "Successfully added the new test case. Add another");
        logger.info("negativeOutboundCharsLoginTest is finished...");
    }
}
