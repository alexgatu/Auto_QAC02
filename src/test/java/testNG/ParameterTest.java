package testNG;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest extends BaseTest{

    @Parameters( {"username", "password"} )
    @Test
    public void ParameterTest01(String u, String p, final ITestContext testContext) {
//        ExtentTest myTest = extent.createTest(testContext.getName());
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Reporter.log("Test started<br/>");
        Reporter.log("Authenticating with username " + u);
        Reporter.log("Authenticating with password " + p);
        myTest.log(Status.PASS, "Authenticated with username " + u);

        Assert.assertEquals(10, 10, "the 2 numbers are equal");
        Assert.assertEquals("alex@alex.com", u, "Test ran with username " + u);
        Reporter.log("Test completed");
    }

}
