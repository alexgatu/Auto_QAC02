package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ModalPage;

public class ModalTest extends BaseTest{
    ModalPage modalPage;
    String expectedModalBodyText = "I'm stealing the click action for any element rendered behind me";

    @BeforeTest
    public void prepareTest() {
        super.setUp();
    }

    @Test
    public void modalTest() {
        navigateToURL("/?page=modal");
        modalPage = new ModalPage(driver);

        System.out.println("Open modal");
        modalPage.openModal();
        System.out.println(modalPage.getModalBodyText());
        Assert.assertEquals(modalPage.getModalBodyText(), expectedModalBodyText);
        System.out.println("Close modal with X");
        modalPage.closeModalWithX();
        System.out.println("Open modal again to close with cancel");
        modalPage.openModal();
        System.out.println(modalPage.getModalBodyText());
        Assert.assertEquals(modalPage.getModalBodyText(), expectedModalBodyText);
        System.out.println("Close modal with cancel");
        modalPage.closeModalWithCancel();
    }
}
