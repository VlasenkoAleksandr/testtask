package pageobjects.mailbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageobjects.MainPage;

public class MailBoxPage extends MainPage{

    @FindBy(css = ".aic .z0 .T-I")
    private WebElement buttonWriteEmail;

    public WebElement getButtonWriteEmail() {
        return buttonWriteEmail;
    }

    @FindBy(css=".oj div textarea")
    private WebElement receiverEmailAdress;

    public WebElement getReceiverEmailAdress() {
        return receiverEmailAdress;
    }

    @FindBy(css=".Ar.Au div")
    private WebElement emailTextArea;

    public WebElement getEmailTextArea() {
        return emailTextArea;
    }

    @FindBy(css=".T-I.J-J5-Ji.aoO.T-I-atl.L3")
    private WebElement sendMessage;

    public WebElement getSendMessage() {
        return sendMessage;
    }

    @FindBy(css = ".n1 > a:nth-child(1)")
    private WebElement inBoxButton;

    public WebElement getInBoxButton() {
        return inBoxButton;
    }

    @FindBy(css = ".xS .xT .y6 .y2")
    private WebElement openAnEmail;

    public WebElement getOpenAnEmail() {
        return openAnEmail;
    }

    @FindBy(css = ".nH .h7 .Bk .G3 div .adn .gs")
    private WebElement emailText;

    public WebElement getEmailText() {
        return emailText;
    }

}
