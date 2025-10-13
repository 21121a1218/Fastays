package Login_Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Login_Pageobjects.Login;

public class Login_OTPNegativeTC extends BaseTestCase {

    @Test(dataProvider = "invalidOtpData")
    void verifyInvalidOtpScenarios(String otp, String expectedMsg) {
        Login lg = new Login(driver);
        lg.login();
        lg.number("8050007018");  
        lg.Continue_Button();
        if (!otp.isEmpty() && otp.length() == 4) {
            lg.otp1(Character.toString(otp.charAt(0)));
            lg.otp2(Character.toString(otp.charAt(1)));
            lg.otp3(Character.toString(otp.charAt(2)));
            lg.otp4(Character.toString(otp.charAt(3)));
        }
        lg.submit();
        String actualMsg = lg.otpvalidation();

        Assert.assertTrue(actualMsg.contains(expectedMsg),
                "Expected: " + expectedMsg + " | Actual: " + actualMsg);
    }

    @DataProvider
    public Object[][] invalidOtpData() {
        return new Object[][] {
            {"", "Please enter a valid 4-digit OTP."}, 
            {"1234", "OTP verification failed."}
        };
    }
}
