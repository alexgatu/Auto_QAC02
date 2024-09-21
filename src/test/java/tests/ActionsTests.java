package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HovePage;

public class ActionsTests extends BaseTest {
    HovePage hovePage;

    @BeforeTest
    public void prepareTest() {
        super.setUp();
    }

    @Test
    public void verifySelectingElementFromDropDownTest() {
        String expectedDropDownOption = "Cat";
        navigateToURL("/?page=hover");
        hovePage = new HovePage(driver);

        Assert.assertTrue(hovePage.hoverButtonDisplayed(), "Hover button is not displayed");
        hovePage.moveToHoveButton();
        System.out.println("Dropdown opened");
        System.out.println("Dropdown options:");
        hovePage.getDropDownOptions().forEach(System.out::println);
        System.out.println("Selecting Cat from dropdown");
        hovePage.clickDropDownOption(expectedDropDownOption);
        System.out.println("Verify if Cat is selected");
        Assert.assertEquals(hovePage.getSelectedDropDownOption(), expectedDropDownOption);
    }

}
