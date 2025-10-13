package Bus_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Search;

public class TC_Calender extends BaseTestcase{

	@Test
	void calendarPastDatesValidation() {
	    Bus_Search bs = new Bus_Search(driver);
	    bs.SelectADate(); // open calendar

	    boolean pastDatesDisabled = bs.verifyPastDatesDisabled();
	    Assert.assertTrue(pastDatesDisabled, "All past dates should be disabled in the calendar");
	}
	@Test
	void movenextmonth() {
	    Bus_Search bs = new Bus_Search(driver);
	    bs.SelectADate(); 
	    String currentMonth = bs.getCalendarMonth();

	    bs.Cal_forward();
	    String nextMonth = bs.getCalendarMonth();

	    Assert.assertNotEquals(nextMonth, currentMonth, "Calendar should move to the next month");
	}

	@Test
	void movepreviousmonth() {
	    Bus_Search bs = new Bus_Search(driver);
	    bs.SelectADate(); 
	    bs.Cal_forward();
		 bs.Cal_forward();
	    String currentMonth = bs.getCalendarMonth();

	    bs.Cal_backward();
	    String prevMonth = bs.getCalendarMonth();

	    Assert.assertNotEquals(prevMonth, currentMonth, "Calendar should move back to the previous month");
	}

}
