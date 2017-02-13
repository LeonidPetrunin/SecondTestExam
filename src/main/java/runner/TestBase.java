package runner;

import framework.Browser;
import framework.GooglePajeObject;
import framework.MailPageObject;
import logger.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public abstract class TestBase {
    private Browser browser;
    GooglePajeObject googlePajeObject;
    MailPageObject mailPageObject;

    @BeforeMethod
    public void beforeMethod() {
              CustomLogger.customLog("BeforeMethod is running");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lpetrunin\\Downloads\\chromedriver_win32\\chromedriver.exe");

        //Driver:
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Browser:
        browser = new Browser(webDriver);
        browser.maximizeWindow();

        //PageObjects:
        googlePajeObject = new GooglePajeObject(browser);
        mailPageObject = new MailPageObject(browser);

        //GooglePageNavigate:
        browser.navigateToGooglePage();


    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        browser.kill();
    }
}
