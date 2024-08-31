package testNG;

import courses.java.calculator.Calculator;
import org.junit.Assert;
import org.testng.annotations.*;

@Test
public class MyFirstTestNGTest {
    int count = 0;
    Calculator calculator;

    @BeforeTest
    public void setUp() {
        System.out.println("Set up before each test run");
        calculator = new Calculator();
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up before class");
    }

    public void test1() {
        System.out.println("This is test1");
    }

    @Test(priority = 2, groups = {"regression"})
    public void cleanBrowsersAtEndTest() {
        System.out.println("This is cleanInputsTest");
    }

    @Test(description = "This is login test", groups = {"smoke", "regression"})
    public void login() {
        System.out.println("This is login");
        Assert.fail();
    }

    protected void test3() {
        System.out.println("This is test3");
    }

    @Test(description = "This is logout test", dependsOnMethods = "login", groups = {"smoke", "regression"})
    public void logout() {
        System.out.println("This is logout");
    }

    @BeforeMethod
    public void setUpMethod() {
        count = 1;
        System.out.println("SetUp before method");
    }

    @Test(invocationCount = 10, threadPoolSize = 3, priority = 1, groups = {"smoke"})
    public void testIncrement() throws InterruptedException {
        count++;
        Thread.sleep(2000);
        System.out.println("Current value for count:" + count);
    }

    //    data providers
    @DataProvider
    public Object[][] calculatorDataProvider() {
        return new Object[][]{
                {5, 2, 3, "+", 0},
                {4, 9, 5, "-", 0},
                {42, -6, -7, "*", 0},
                {1.4142, 2, 0, "SQRT", 0.0001},
                {0.66666666666, 2, 3, "/", 0.0001}
        };
    }

    @Test(dataProvider = "calculatorDataProvider")
    public void verifyComputeCalculator(double expectedResults, double firstNumber, double secondNumber, String operator, double delta) {
        System.out.println("compute calculator test with delta:" + delta + " for next (" + firstNumber + operator + secondNumber + ")=" + expectedResults);
        Assert.assertEquals(expectedResults, calculator.compute(firstNumber, secondNumber, operator), delta);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "UNSUPPORTED OPERATOR: op")
    public void verifyNotSupportedOperator() {
        calculator.compute(1, 4, "op");
    }

    @Test(alwaysRun = true, dependsOnMethods = "login")
    public void closeBrowserTab() {
        System.out.println("Closing the browser tab");
    }


    @AfterTest
    public void cleanUp() {
        System.out.println("Clean up after each test run");
    }

    @AfterClass
    public static void cleanAfterClass() {
        System.out.println("Clean up after class run");
    }
}
