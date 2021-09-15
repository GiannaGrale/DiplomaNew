package tests;

import baseEntities.BaseCrossBrowser;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;
import utils.Listener;

@Listeners({Listener.class})
public class CrossBrowserTest extends BaseCrossBrowser {
    @Test
    public void crossBrowserTest(String browserType) {
        logger.info("crossBrowserTest is started");
        properties = ReadProperties.getInstance();
        if (browserType.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText().trim(), "DASHBOARD");
        logger.info("crossBrowserTest is finished");
    }
}
