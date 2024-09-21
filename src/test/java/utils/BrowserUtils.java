package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.ConstantUtils.SCREENSHOTS_PATH;

public class BrowserUtils {
    public static WebDriver getDriver(String browser) {
        return getDriver(browser, "local");
    }


    public static WebDriver getDriver(String browser, String environment) {
        switch (browser.toLowerCase()) {

            case "firefox" : {
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 1);
                profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.download.manager.focusWhenStarting", false);
                profile.setPreference("browser.download.useDownloadDir", true);
                profile.setPreference("browser.helperApps.alwaysAsk.force", false);
                profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
                profile.setPreference("browser.download.manager.closeWhenDone", true);
                profile.setPreference("browser.download.manager.showAlertOnComplete", true);
                profile.setPreference("browser.download.manager.useWindow", false);
                // You will need to find the content-type of your app and set it here.
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                        "application/octet-stream");

                FirefoxOptions capabilities = new FirefoxOptions();
                capabilities.setCapability("browserName", "Firefox");
                capabilities.setCapability("browserVersion", "95.0");
                HashMap<String, Object> customOptions = new HashMap<String, Object>();
                customOptions.put("os", "OS X");
                customOptions.put("osVersion", "Monterey");
                customOptions.put("buildName", "Selenium Java Firefox Profile");
                customOptions.put("sessionName", "Selenium Java Firefox Profile");
                capabilities.setCapability("bstack:options", customOptions);
                capabilities.setProfile(profile);
                return new FirefoxDriver(capabilities);
            }
            case "chrome" : {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                if (environment.equalsIgnoreCase("headless")) {
                    options.addArguments("--headless");
                }

                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory", "/src/test/resources/downloads");
                options.setExperimentalOption("prefs", prefs);

                return new ChromeDriver(options);
            }
            case "edge" : {
                return new EdgeDriver();
            }
            case "safari" : {
                return new SafariDriver();
            }
            default : {
                return new ChromeDriver();
            }
        }
    }

    public static void generateScreenShots(String filename, WebDriver driver, boolean alertOn) throws IOException {
        if (alertOn)
            driver.switchTo().alert().accept();
        File screnshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File saveFile = new File(SCREENSHOTS_PATH + "/" + filename + ".png");
        FileUtils.copyFile(screnshotFile, saveFile);
    }
}
