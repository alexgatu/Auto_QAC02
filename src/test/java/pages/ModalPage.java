package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalPage extends BasePage {
    @FindBy(xpath = "//button[contains(text(),'Open Modal')]")
    private WebElement openModalButton;

    @FindBy(className = "modal-body")
    private WebElement modalBody;

    @FindBy(xpath = "//div[@class='modal']//span")
    private WebElement xButton;

    @FindBy(xpath = "//button[@class='neutral']")
    private WebElement cancelButton;

    public ModalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openModal() {
        int nrOfRetries = 10;
        waitUntilElementClickable(openModalButton);

//        close modal if it is already open
        while (nrOfRetries > 0) {
            try {
                openModalButton.click();
                break;
            } catch (ElementClickInterceptedException e) {
                closeModalWithX();
                nrOfRetries--;
            }
        }


    }

    public void closeModalWithX() {
        waitUntilElementClickable(xButton);
        xButton.click();
    }

    public void closeModalWithCancel() {
        waitUntilElementClickable(cancelButton);
        cancelButton.click();
    }

    public String getModalBodyText() {
        waitUntilElementVisible(modalBody);
        return modalBody.getText();
    }
}
