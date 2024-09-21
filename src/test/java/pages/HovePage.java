package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HovePage extends BasePage {
    @FindBy(xpath = "//button[contains(text(),'Hover me')]")
    private WebElement openHoverButton;

    @FindBy(xpath = "//div[@class='dropdown-content']/div")
    private List<WebElement> dropDownOptions;

    @FindBy(className = "clicked")
    WebElement selectedDropDownOption;

    Actions actions;

    public HovePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public boolean hoverButtonDisplayed() {
        waitUntilElementVisible(openHoverButton);
        return openHoverButton.isDisplayed();
    }

    public void moveToHoveButton() {
        actions.moveToElement(openHoverButton).perform();
    }

    public List<String> getDropDownOptions() {
        moveToHoveButton();
        List<String> dropDownOptionsText = new ArrayList<>();
        for (WebElement element : dropDownOptions) {
            dropDownOptionsText.add(element.getText());
        }
        return dropDownOptionsText;
    }

    public Map<String, WebElement> getMapDropDownOptions() {
        moveToHoveButton();
        Map<String, WebElement> dropDownOptionsMap = new HashMap<>();
        for (WebElement element : dropDownOptions) {
            dropDownOptionsMap.put(element.getText(), element);
        }
        return dropDownOptionsMap;
    }

    public String getSelectedDropDownOption() {
        waitUntilElementVisible(selectedDropDownOption);
        return selectedDropDownOption.getText();
    }

    public void clickDropDownOption(String value) {
        WebElement element = getMapDropDownOptions().get(value);
        actions.moveToElement(element).click().build().perform();
    }
}
