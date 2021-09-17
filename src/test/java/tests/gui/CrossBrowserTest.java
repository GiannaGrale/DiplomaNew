package tests.gui;

import baseEntities.BaseCrossBrowser;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps_Anna.LoginStep;
import steps_Anna.ProjectStep;
import utils.Listener;

@Listeners({Listener.class})
public class CrossBrowserTest extends BaseCrossBrowser {

    @Test
    public void crossBrowserTest() {
        logger.info("crossBrowserTest is started");
        ProjectStep projectStep = new LoginStep(driver)
                .correctLogin(properties.getLogin(), properties.getPassword());
        Assert.assertEquals(projectStep.getDashboardPage().getDashboardButtonText().trim(), "DASHBOARD");
        logger.info("crossBrowserTest is finished");
    }
}
