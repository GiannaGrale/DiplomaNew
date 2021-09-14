package steps_Boris;

import baseEntities.BaseStep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DialogBoxPage;

public class DialogBoxStep extends BaseStep {
    public DialogBoxStep(WebDriver driver) {
        super(driver);
    }

    public DialogBoxStep clickOnDialogueBox(){
        DialogBoxPage dialogBoxPage = new DialogBoxPage(driver, true);
        dialogBoxPage.getMostActiveTime().click();
        WebElement timeFrame = dialogBoxPage.selectTimeFrame();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(timeFrame));
        return this;
    }
}
