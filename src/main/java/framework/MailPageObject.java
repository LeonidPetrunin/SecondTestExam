package framework;

import logger.CustomLogger;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class MailPageObject {
    private static final By MAIL_PAGE_OBJECT_LOGO = By.xpath("//*[@class='logo-link']");
    private static final By MAIL_PAGE_OBJECT_SIGN_UP = By.xpath("//*[@id='signup-button']");
    private static final By MAIL_PAGE_SIGN_UP_REF_FORM = By.xpath("//*[@class='reg-form']");
    private static final By REG_FORM_NAME_FIELD = By.xpath("//*[@tabindex='1']");
    private static final By REG_FORM_LAST_NAME_FIELD = By.xpath("//*[@tabindex='2']");
    private static final By REG_FORM_BIRTH_MONTH = By.xpath("//*[@tabindex='4']/descendant::option[@value='3']");
    private static final By REG_FORM_BIRTH_DATE = By.xpath("//*[@tabindex='5']/descendant::option[@value='15']");
    private static final By REG_FORM_BIRTH_YEAR = By.xpath("//*[@tabindex='6']/descendant::option[@value='37']");
    private static final By REG_FORM_EMAIL_ADRESS = By.xpath("//*[@tabindex='8']");
    private static final By REG_FORM_PASS_ONE = By.xpath("//*[@tabindex='10']");
    private static final By REG_FORM_PASS_TWO = By.xpath("//*[@tabindex='11']");
    private static final By REG_FORM_PASS_SECURITY_TIPS = By.xpath("//*[@class='securityTipsHead']");
    private static final By REG_FORM_VERIFICATION_FIELD = By.xpath("//*[@id='g-recaptcha-panel']/descendant::*iframe/descendant::span[@id='recaptcha-anchor']");
    private static final By REG_FORM_ACCEPT_BUTTON = By.xpath("//*[@tabindex='15']");
    private static final By REG_FORM_SEC_QUASTION = By.xpath("//*[@tabindex='13']/descendant::*[@value='4']");
    private static final By REG_FORM_SEC_ANSWER = By.xpath("//*[@tabindex='14']");
    private static final By CAPTCHA_FRAME = By.xpath("//*[@title='recaptcha widget']");

    Browser browser;

    public MailPageObject(Browser browser) {
        this.browser = browser;
    }

    public void enterMailRegistrationPage(){
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(MAIL_PAGE_OBJECT_LOGO));
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(MAIL_PAGE_OBJECT_SIGN_UP)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(MAIL_PAGE_SIGN_UP_REF_FORM));
        CustomLogger.customLog("Enter MAIL.COM registration page method is finished");

    }

    public void mailPageRegistration(){
        String name = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        String emailName = RandomStringUtils.randomAlphabetic(8);
        String password = RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.random(3);
        String answer = RandomStringUtils.randomAlphabetic(8);

        browser.timeOut(5000l);
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_NAME_FIELD));
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_NAME_FIELD)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_NAME_FIELD)).sendKeys(name);
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_LAST_NAME_FIELD)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_LAST_NAME_FIELD)).sendKeys(lastName);
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_BIRTH_MONTH));
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_BIRTH_MONTH)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_BIRTH_DATE));
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_BIRTH_DATE)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_BIRTH_YEAR));
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_BIRTH_YEAR)).click();
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_EMAIL_ADRESS)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_EMAIL_ADRESS)).sendKeys(emailName);
        browser.timeOut(2000l);
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_PASS_ONE)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_PASS_ONE)).sendKeys(password);
        browser.timeOut(2000l);
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_PASS_SECURITY_TIPS));
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_PASS_TWO)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_PASS_TWO)).sendKeys(password);
        browser.timeOut(2000l);
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_SEC_QUASTION)).click();
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_SEC_ANSWER)).click();
        browser.customWait(10, ExpectedConditions.visibilityOfElementLocated(REG_FORM_SEC_ANSWER)).sendKeys(answer);
        //Browser newDriver = webDriver.switchTo().frame(webDriver.findElement(By.xpath("//*[@title='recaptcha widget']")));
        //newDriver.findElement(By.id("recaptcha-anchor")).click();
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_VERIFICATION_FIELD)).click();
        browser.customWait(10, ExpectedConditions.elementToBeClickable(REG_FORM_ACCEPT_BUTTON)).click();


    }
}
