package tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GoogleCookiesTest extends BaseTest {

    @BeforeMethod
    public void prepareTest() {
        System.out.println("Open new browser Google page");
        getBrowserWithEnv();
        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void redAllCookiesTest() {
        Set<Cookie> googleCookies = driver.manage().getCookies();
        printCookies(googleCookies);
    }

    @Test
    public void addNewCookieTest() {
        Cookie newCookie = new Cookie("TestCookie", "TestValue", ".google.com", "/", null);
        driver.manage().addCookie(newCookie);
        printCookies(driver.manage().getCookies());
        Assert.assertEquals(getCookie("TestCookie").getValue(), "TestValue");
    }


    private Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }

    private void printCookies(Set<Cookie> cookies) {
        System.out.println("Name:Value ->Domain");
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
    }
}
