package testNG;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class PageTest extends BaseTest {

    @Test
    public void Test01() {
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        myTest.log(Status.PASS, "Test01 ran OK ");

    }

    @Test
    public void Test02() {
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        myTest.log(Status.PASS, "Test02 ran OK ");
    }

    @Test
    public void Test03() {
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        myTest.log(Status.PASS, "Test03 ran OK ");
    }

}
