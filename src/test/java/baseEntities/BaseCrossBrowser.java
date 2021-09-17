package baseEntities;

import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.CrossBrowser;


public class BaseCrossBrowser {
    public WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this);
    public ReadProperties properties;


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @BeforeTest
    @Parameters({"BrowserType"})
    public void setUp(String browserType) {
        properties = ReadProperties.getInstance();
        driver = CrossBrowser.selectDriver(browserType);
    }
}
