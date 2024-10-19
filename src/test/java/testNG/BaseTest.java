package testNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static ExtentReports extent;

    @BeforeSuite
    public void setUp() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void clearUp() {
        extent.flush();
    }

}
