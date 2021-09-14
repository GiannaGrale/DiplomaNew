package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DialogBoxPage extends BasePage {

    private final static String endpoint = "index.php?/dashboard";
    private final static By most_Active_Time_By = By.cssSelector(".link.link-tooltip");
    private final static By select_Time_Frame_By = By.id("ui-dialog-title-selectTimeframeDialog");
    private final static By text_in_Time_Frame_By = By.xpath("//div[@class='form-description']");

    public DialogBoxPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getTestRailSite() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getMostActiveTime().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    public WebElement getMostActiveTime() {
        return driver.findElement(most_Active_Time_By);
    }
    public WebElement selectTimeFrame() {
        return driver.findElement(select_Time_Frame_By);
    }
    public WebElement textInTimeFrame() {
        return driver.findElement(text_in_Time_Frame_By);
    }
}
