package Login_Testcases;
import org.testng.annotations.Test;

import Login_Pageobjects.Login;

public class TC_Login extends BaseTestCase{
@Test
void login()
{
	Login lg=new Login(driver);
	lg.login();
	lg.number("6300370135");
    lg.Continue_Button();
    lg.otp1("8");
    lg.otp2("1");
    lg.otp3("2");
    lg.otp4("3");
    lg.submit();
    //lg.skip();
    lg.verifyLogin(); 
}
}
