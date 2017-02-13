package framework;

import com.google.common.collect.ImmutableMap;
import configuration.ConfigMapper;
import logger.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class Browser {
    WebDriver webDriver;

    public Browser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Without custom condition:
    public void customWait(long waitUntil, By xpath){
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        long localWaitUntil = waitUntil;

        while (localWaitUntil > 0){
            try {

                //Try to find given object:
                webDriver.findElement(xpath);

                //If found -> return true (exit while loop)
                break;
            }catch (Exception e){


                //If NOT -> wait 0.5 seconds and decrease total time of waiting by 0.5 seconds
                try{
                    Thread.sleep(500L);
                }catch (Exception e1){ }

                localWaitUntil -= 500;
            }
        }
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //With custom condition:
    public <T> T customWait(long waitUntil, ExpectedCondition<T> expectedCondition){
        CustomLogger.customLog("CustomWait method with parameters: " + waitUntil + "sec for object " + expectedCondition + " is started!");
        WebDriverWait wait = new WebDriverWait(webDriver, waitUntil);
        return wait.until(expectedCondition);
    }

    public void timeOut(Long sleepTime){
        CustomLogger.customLog("Timeout method with parameters: " + sleepTime + " is started!");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    public void kill() {
        webDriver.quit();
    }

    public void navigateToGooglePage(){
        webDriver.get(ConfigMapper.getInstance().getConfigObject().getGoogleUrlName());
    }

    public String getWindowHandle(){
        return webDriver.getWindowHandle();
    }

    /*public WebDriver switchFrames(WebElement element){
        Browser newDriver = (Browser) webDriver.switchTo().frame(webDriver.findElement((By) element));        //webDriver.switchTo().frame(element);
        return (WebDriver) newDriver;
    }*/
}
