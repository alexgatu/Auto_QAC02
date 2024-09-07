package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class BrowserUtils {

    private static String browser = readConfigFile();

    public static WebDriver getDriver() {
        switch (browser.toLowerCase()) {

            case "firefox" : {
                return new FirefoxDriver();
            }
            case "chrome" : {
                return new ChromeDriver();
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

    private static String readConfigFile() {
        String browserValue = "Chrome";
        Properties props = new Properties();
        try {
            String path = Paths.get("").toAbsolutePath().toString();
            props.load(new FileInputStream(path + "/src/test/resources/config/application.properties"));
            browserValue = props.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return browserValue;
    }

    private static String readSystemVariable() {
        String browserRet = System.getenv("autoBrowser");
        return browserRet;
    }

}
