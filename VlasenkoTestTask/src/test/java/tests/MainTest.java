package tests;

import deflogger.TestsLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.MainPageSteps;
import steps.mailbox.MailBoxPageSteps;


public class MainTest {
    String testingPage = "https://www.google.com/gmail/";

    protected MainPageSteps mainPageSteps;
    private WebDriver driver;

    @BeforeMethod()
    public void prepareEnv(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\VlasenkoTestTask\\src\\main\\resources\\geckodriver.exe");

        desiredCapabilities.setCapability("marionette", true);
        driver = new FirefoxDriver();
        driver.get(testingPage);

        mainPageSteps = new MainPageSteps(driver);

    }

    @Test()
    public void mainTest(){
        TestsLogger.logMethodName();

        mainPageSteps.enterLogin();
        mainPageSteps.clickNext();
        MailBoxPageSteps mailBoxPageSteps = mainPageSteps.enterThePassword();
        mailBoxPageSteps.writeAnEmail();
        mailBoxPageSteps.goToInbox();

        mailBoxPageSteps.openEmail();
        mailBoxPageSteps.verifyTheText();
    }


    @AfterMethod()
    public void cleanUpEnv(){
        driver.quit();
    }
}
