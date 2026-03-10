package Hotel_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Search;
import Login_Pageobjects.Login;

public class TC_Hotel_Search extends BaseTestCase{
	@Test 
	public void Hotel_Search() throws InterruptedException
	{
		Hotel_Pageobjects.Hotel_Search hs=new Hotel_Pageobjects.Hotel_Search(driver);
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
		System.out.println(hs.resultcount());
		Thread.sleep(2000);
		hs.getSplitDates();
		Assert.assertTrue(hs.resultcount().contains("Search Results"), "Search Failed");
	}
}
