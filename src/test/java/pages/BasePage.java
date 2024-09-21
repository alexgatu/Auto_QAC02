package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static utils.ConstantUtils.SCREENSHOTS_PATH;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait longWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitUntilAlertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText(Alert alert) {
        return alert.getText();
    }

    public void acceptAlert(Alert alert) {
        //Press the OK button from alert
        alert.accept();
    }

    public void acceptAlert(Alert alert, String response) {
        //enter response on prompt alert
        alert.sendKeys(response);
        //Press the OK button from alert
        alert.accept();
    }

    public void cancelAlert(Alert alert) {
        //Press the OCancel button from alert
        alert.dismiss();
    }

    public boolean isAlertClosed() {
        try {
            driver.switchTo().alert();
            return false;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }

}