package baseEntities;


import core.ReadProperties;
import cucumber_aqa06.support.MyWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.DashboardPage;
import pages.DialogBoxPage;
import pages.LoginPage;


public class BaseGUIStep {
    public LoginPage loginPage;
    public DialogBoxPage dialogBoxPage;
    public DashboardPage dashboardPage;
    public ReadProperties props = ReadProperties.getInstance();

    public final EventFiringWebDriver webDriver;

    public BaseGUIStep(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
