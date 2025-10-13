package Login_Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Login_Pageobjects.Login;

public class Login_NumberNegativeTC extends BaseTestCase {

    @Test(dataProvider = "invalidNumbers")
    void negativeScenarios_withInvalidNumbers(String number, String expectedMsg) {
        Login lg = new Login(driver);
        lg.login();

        if (!number.isEmpty()) {
            lg.number(number); 
        }

        lg.Continue_Button();

        // Get actual error message from page
        String actualMsg = lg.emptynumvalidation(); 
        // Compare
        Assert.assertTrue(actualMsg.contains(expectedMsg),
                "Expected: " + expectedMsg + " | Actual: " + actualMsg);
    }

    @DataProvider
    public Object[][] invalidNumbers() {
        return new Object[][] {
            {"", "Mobile number is required"}, 
            {"1234567891", "Mobile number does not match the selected country"},
        };
    }
}
