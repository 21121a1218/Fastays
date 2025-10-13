package Bus_Testcases;

import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Cancellation;
import Login_Pageobjects.Login;

public class TC_Cancellation extends BaseTestcase{
	@Test
	void Cancell()
	{
		Bus_Cancellation bc=new Bus_Cancellation(driver);
		Login lg=new Login(driver);
		lg.login();
		lg.number("6300370135");
		lg.Continue_Button();
	    lg.otp1("8");
	    lg.otp2("1");
	    lg.otp3("2");
	    lg.otp4("3");
	    lg.submit();
		bc.mybusbookings();
		bc.cancell();
		bc.home();
	}
}
