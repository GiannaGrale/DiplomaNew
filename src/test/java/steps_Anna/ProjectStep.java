package steps_Anna;

import baseEntities.BaseStep;
import core.ReadProperties;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AdminOverviewPage;
import pages.DashboardPage;
import pages.ProjectOverviewPage;
import pages.ProjectPage;

import static io.restassured.RestAssured.given;


public class ProjectStep extends BaseStep {

    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    @Step("Add a project with the following name '{projectName}', and announcement '{projectName}'")
    public ProjectStep addProject(String projectName, String announcement) {
        new DashboardPage(driver, true).getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys(projectName);
        projectPage.getAnnouncementInput().sendKeys(announcement);
        projectPage.getAddProjectButton().click();
        return this;
    }

    @Step("Add a project with the following name '{projectName}', and announcement '{projectName}'")
    public CaseStep addProjectWithFutureTestCase(String projectName, String announcement) {
        addProject(projectName, announcement);
        return new CaseStep(driver);
    }
}

