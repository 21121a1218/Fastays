package Bus_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Search;
import Bus_Pageobjects.Searchresultcards_and_Filters;

public class TC_Resultscard extends BaseTestcase{
	@Test(priority=0)
void resultscount() throws InterruptedException
{
		Bus_Search bs=new Bus_Search(driver);
		bs.SearchForAnOrigin();
		bs.SearchCity1("Hyderabad");
		bs.City1("Hyderabad");
		bs.searchForADestination();
		bs.SearchCity2("Kurnool");
		bs.City2("Kurnool");
		bs.SelectADate();
		bs.selectDate("30");
		bs.Search();
		Thread.sleep(6000);
		Searchresultcards_and_Filters sf=new Searchresultcards_and_Filters(driver);
		Assert.assertTrue(sf.resultcountverify(), "Displayed result count should match number of result cards");
}
	@Test(priority=1)
	void cancellationpolicyTab() throws InterruptedException
	{
			Searchresultcards_and_Filters sf=new Searchresultcards_and_Filters(driver);
			Assert.assertTrue(sf.cancellationPolicy(), "Cancellation should be Opened with Appropriate Data");
			
}	
	@Test(priority=4)
	void seatsleft() throws InterruptedException
	{
			Searchresultcards_and_Filters sf=new Searchresultcards_and_Filters(driver);
			Assert.assertTrue(sf.seatsleft(), "Displayed seatsleft count should match number of vacant seats in Seatlayout");
	}
	@Test(priority=3)
	void highpricefilter() throws InterruptedException
	{
			Searchresultcards_and_Filters sf=new Searchresultcards_and_Filters(driver);
			Assert.assertTrue(sf.checkhighprice(), "Displayed results should be Arranged in Descending Order");	
	}
	@Test(priority=2)
	void lowpricefilter() throws InterruptedException
	{
			Searchresultcards_and_Filters sf=new Searchresultcards_and_Filters(driver);
			Assert.assertTrue(sf.checklowprice(), "Displayed results should be Arranged in Asscending Order");	
	}
}
