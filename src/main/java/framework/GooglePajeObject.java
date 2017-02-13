package framework;

import logger.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class GooglePajeObject {

    private static final By GOOGLE_PAGE_SEARCH_FIELD = By.xpath("//*[@id='lst-ib']");
    private static final By GOOGLE_PAGE_RESULT_LIST = By.xpath("//*[@id='ires']");
    private static final By MAIL_OBJECT_IN_GOOGLE_SEARCH_LIST = By.xpath("//*[@id='ires']/descendant::a[@href='https://www.mail.com/']");


    Browser browser;

    public GooglePajeObject(Browser browser) {
        this.browser = browser;
    }

    //Page Methods:

    public void searchItemOnGooglePage(String text){
        browser.customWait(15, ExpectedConditions.visibilityOfElementLocated(GOOGLE_PAGE_SEARCH_FIELD)).click();
        browser.customWait(15, ExpectedConditions.elementToBeClickable(GOOGLE_PAGE_SEARCH_FIELD)).sendKeys(text);
        browser.customWait(15, ExpectedConditions.elementToBeClickable(GOOGLE_PAGE_SEARCH_FIELD)).sendKeys(Keys.RETURN);
        browser.customWait(15, ExpectedConditions.visibilityOfElementLocated(GOOGLE_PAGE_RESULT_LIST));
        browser.customWait(5, ExpectedConditions.visibilityOfElementLocated(MAIL_OBJECT_IN_GOOGLE_SEARCH_LIST)).click();
        CustomLogger.customLog("Search item in google page method is finished");
    }



}
