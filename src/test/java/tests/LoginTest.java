package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//          username, password, browser
                {"zebra", "zebrapassword", "edge"},
                {"dingo", "dingopassword", "chrome"},
                {"camel", "camelpassword", "edge"},
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String username, String password, String browser) {
        getBrowser(browser);
        getBaseURL();

        navigateToURL("/?page=login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("Verify login successful");
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username));
    }
}
