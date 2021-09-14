package steps_Boris;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;

public class DashboardSteps extends BaseStep {

    public DashboardSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(){
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickAddProjectButton();
    }

    public DashboardSteps clickOnPopUpMessage(){
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getInProgressElement().click();
        return this;
    }
}

