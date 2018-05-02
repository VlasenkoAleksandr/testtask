package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.MainPage;
import steps.mailbox.MailBoxPageSteps;

public class MainPageSteps {

    private MainPage mainPage;
    protected WebDriver driver;

    public MainPageSteps(WebDriver driver){
        this.driver = driver;
        mainPage = PageFactory.initElements(driver,MainPage.class);
    }

    public void enterLogin(){

        mainPage.getUserEmailTextArea().sendKeys("vlasenkotest@gmail.com");
    }

    public void clickNext(){
        mainPage.getNextButtonEmailArea().click();
    }

    public MailBoxPageSteps enterThePassword(){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(mainPage.getUserPasswordTextArea()));
        mainPage.getUserPasswordTextArea().sendKeys("vlasenkotest1");
        mainPage.getNextButtonPasswordArea().click();
        return new MailBoxPageSteps(driver);
    }

}
