package Hotel_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Hotel_Pageobjects.Hotel_Booking_Flow;
import Login_Pageobjects.Login;

public class TC_HotelBooking_Flow extends BaseTestCase{
	@Test 
	public void Hotel_Search() throws InterruptedException
	{
		
		Login lg=new Login(driver); 
		Hotel_Pageobjects.Hotel_Search hs=new Hotel_Pageobjects.Hotel_Search(driver);
		Hotel_Booking_Flow hb=new Hotel_Booking_Flow(driver);
		lg.login();
		  lg.number("6300370135");
		  lg.Continue_Button();
		  lg.otp1("8");
		  lg.otp2("1");
		  lg.otp3("2");
		  lg.otp4("3");
		  lg.submit();
		  Thread.sleep(3000);
		  hs.SearchCity();
			Thread.sleep(2000);	
			hs.City();
			Thread.sleep(2000);
			hs.CityName();
			Thread.sleep(2000);
			hs.Date();
			hs.checkin();
			hs.checkout();
			hs.Searchbutton();
			Thread.sleep(10000);
		hb.clickFirstRoom(2);
		hb.selectroom(1);
		hb.tittle();
		hb.firstname("Deva");
		hb.lastname("reva");
		hb.gender();
		//hb.email("email@gmail.com");
		hb.phonenumber("9999999999");
		hb.pay();
		hb.bankPayment(driver);

	}  
}
