package runner;

import configuration.ConfigMapper;
import org.testng.annotations.Test;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class TestClassOne extends TestBase{
    @Test
    public void GoogleSearch(){
        String findItem = ConfigMapper.getInstance().getConfigObject().getMailPage();
        googlePajeObject.searchItemOnGooglePage(findItem);
        mailPageObject.enterMailRegistrationPage();
        mailPageObject.mailPageRegistration();
    }
}
