package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(id="identifierId")
    private WebElement userEmailTextArea;

    public WebElement getUserEmailTextArea() {
        return userEmailTextArea;
    }

    @FindBy(id="identifierNext")
    private WebElement nextButtonEmailArea;

    public WebElement getNextButtonEmailArea() {
        return nextButtonEmailArea;
    }

    @FindBy(css = "#password .aCsJod .aXBtI .Xb9hP .whsOnd")
    private WebElement userPasswordTextArea;

    public WebElement getUserPasswordTextArea() {
        return userPasswordTextArea;
    }

    @FindBy(id="passwordNext")
    private WebElement nextButtonPasswordArea;

    public WebElement getNextButtonPasswordArea() {
        return nextButtonPasswordArea;
    }
}
