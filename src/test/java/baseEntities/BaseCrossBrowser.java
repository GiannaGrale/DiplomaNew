package baseEntities;

import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public class BaseCrossBrowser {
    public WebDriver driver;
    public ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
