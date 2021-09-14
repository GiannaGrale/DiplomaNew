package steps_Anna;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Incorrect log into system with credentials '{username}', '{password}'")
    public LoginStep incorrectLogin(String username, String password) {
        logger.debug("try to log in with failed credentials...");
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginBtn();
        wait.waitForInvisibility(button);
        logger.debug("fail to log in and display error message...");
        return this;
    }

    @Step("Successful log into system with credentials '{username}', '{password}'")
    public ProjectStep correctLogin (String username, String password) {
        logger.debug("try to log in with correct credentials...");
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginBtn();
        wait.waitForInvisibility(button);
        logger.debug("successful log in to the system...");
        return new ProjectStep(driver);
    }
}

