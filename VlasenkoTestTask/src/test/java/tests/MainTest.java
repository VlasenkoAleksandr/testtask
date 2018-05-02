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

import static org.testng.Assert.assertEquals;


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
    public void mainTest() throws InterruptedException {
        TestsLogger.logMethodName();

        mainPageSteps.enterLogin();
        mainPageSteps.clickNext();
        MailBoxPageSteps mailBoxPageSteps = mainPageSteps.enterThePassword();
        mailBoxPageSteps.writeAnEmail();
        Thread.sleep(1000);
        mailBoxPageSteps.goToInbox();

        mailBoxPageSteps.openEmail();
        boolean text = mailBoxPageSteps.verifyTheText();

        assertEquals(text,true);
    }


    @AfterMethod()
    public void cleanUpEnv(){
        driver.close();
    }
}
