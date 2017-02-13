package listner;

import org.testng.*;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class CustomListner implements ITestListener, ITestNGListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        //Assert.fail("TEST IS FAIL!");
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
