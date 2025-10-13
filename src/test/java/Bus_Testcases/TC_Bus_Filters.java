package Bus_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Search;
import Bus_Pageobjects.Searchresultcards_and_Filters;

public class TC_Bus_Filters extends BaseTestcase{
	@Test(priority=0)
	void Timing_filter_1() throws InterruptedException
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
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		Assert.assertTrue(sf.After6PM(), "In Results, buses before 6PM should not display");
	}
	@Test(priority=1)
	void Bus_type1()
	{
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		sf.clearall();
		Assert.assertTrue(sf.AC(), "In Results, AC Buses should be Displayed");	
	}
	@Test(priority=2)
	void Bus_type2()
	{
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		sf.clearall();
		Assert.assertTrue(sf.nonAC(), "In Results, nonAC Buses should be Displayed");	
	}
	@Test(priority=3)
	void Bus_type3()
	{
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		sf.clearall();
		Assert.assertTrue(sf.Seater(), "In Results, sleeper Buses should be Displayed");	
	}
	@Test(priority=4)
	void Boardingpoint()
	{
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		sf.clearall();
		Assert.assertTrue(sf.selectBoardingPoint(), "In Results, with Selected Boarding Point Buses should be Displayed");	
	}
	@Test(priority=5)
	void Droppingpoint()
	{
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		Assert.assertTrue(sf.selectDropingPoint(), "In Results, with Selected Dropping Point Buses should be Displayed");	
	}
	@Test(priority=6)
	void combinationFilters()
	{
		Searchresultcards_and_Filters sf = new Searchresultcards_and_Filters(driver);
		Assert.assertTrue(sf.After6PM(), "In Results, buses before 6PM should not display");
		Assert.assertTrue(sf.selectDropingPoint(), "In Results, with Selected Dropping Point Buses should be Displayed");
		Assert.assertTrue(sf.AC(), "In Results, AC Buses should be Displayed");
		Assert.assertTrue(sf.selectDropingPoint(), "In Results, with Selected Dropping Point Buses should be Displayed");
	}
}
