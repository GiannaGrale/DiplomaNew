package baseEntities;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseCrossBrowser {
    public WebDriver driver;
    public ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @BeforeMethod
    @Parameters({"BrowserType"})
    public void setUpBrowser(String browserType) {
            properties = ReadProperties.getInstance();
        if (browserType.equalsIgnoreCase("Opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }
}
