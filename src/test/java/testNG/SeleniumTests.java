package testNG;

import courses.java.oop3.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTests {
    WebDriver driver;

    @Test
    public void test01() {
        driver = BrowserUtils.getDriver();

        driver.navigate().to("https://www.facebook.com/");
        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span"));
        cookies.click();
        WebElement email = driver.findElement(By.id("email"));
//        WebElement email2 = driver.findElement(By.cssSelector("#email"));
//        WebElement email3 = driver.findElement(By.xpath("//*[@id=\"email\"]"));\

        driver.close();

    }

    @Test
    public void test02() {

        driver = BrowserUtils.getDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://57.151.123.81:3000/#/");
        WebElement dismissPopup = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted"));
        dismissPopup.click();

        WebElement accountButton = driver.findElement(By.id("navbarAccount"));
        accountButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement loginButton = driver.findElement(By.cssSelector("#navbarLoginButton"));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#navbarLoginButton")));
        loginButton.click();

        WebElement loginText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-login > div > mat-card > h1")));
        Assert.assertEquals(loginText.getText(), "Login", "The site is not on the Login page");

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));

        email.clear();
        email.sendKeys("alex@alex.com");
        password.clear();
        password.sendKeys("alsjd3212jdj");

        driver.quit();
    }
}
