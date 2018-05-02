package steps.mailbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.mailbox.MailBoxPage;
import steps.MainPageSteps;

public class MailBoxPageSteps extends MainPageSteps {

    private MailBoxPage mailBoxPage;

    public MailBoxPageSteps(WebDriver driver){
        super(driver);
        mailBoxPage = PageFactory.initElements(driver, MailBoxPage.class);
    }

    WebDriverWait wait = new WebDriverWait(driver,10);

    public void writeAnEmail(){
        wait.until(ExpectedConditions.visibilityOf(mailBoxPage.getButtonWriteEmail()));
        mailBoxPage.getButtonWriteEmail().click();
        wait.until(ExpectedConditions.visibilityOf(mailBoxPage.getReceiverEmailAdress()));
        mailBoxPage.getReceiverEmailAdress().sendKeys("vlasenkotest@gmail.com");
        mailBoxPage.getEmailTextArea().sendKeys("Hello, world!");
        mailBoxPage.getSendMessage().click();
    }

    public void goToInbox(){
        wait.until(ExpectedConditions.visibilityOf(mailBoxPage.getButtonWriteEmail()));
        mailBoxPage.getInBoxButton().click();
    }

    public void openEmail(){
        wait.until(ExpectedConditions.visibilityOf(mailBoxPage.getOpenAnEmail()));
        mailBoxPage.getOpenAnEmail().click();
    }

    public boolean verifyTheText(){
        wait.until(ExpectedConditions.visibilityOf(mailBoxPage.getEmailText()));
        return mailBoxPage.getEmailText().getText().contains("Hello, world!");

    }
}
