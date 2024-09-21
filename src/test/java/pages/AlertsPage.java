package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BasePage {
    @FindBy(id = "alert-trigger")
    private WebElement simpleAlertButton;

    @FindBy(id = "confirm-trigger")
    private WebElement confirmationAlertButton;

    @FindBy(id = "prompt-trigger")
    private WebElement promptAlertButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openSimpleAlert() {
        waitUntilElementClickable(simpleAlertButton);
        simpleAlertButton.click();
    }

    public void openConfirmAlert() {
        waitUntilElementClickable(confirmationAlertButton);
        confirmationAlertButton.click();
    }

    public void openPromptAlert() {
        waitUntilElementClickable(promptAlertButton);
        promptAlertButton.click();
    }
}
