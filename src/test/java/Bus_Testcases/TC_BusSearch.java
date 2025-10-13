package Bus_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Search;

public class TC_BusSearch extends BaseTestcase{
	@Test
	void search() throws InterruptedException
	{
		Bus_Search bs=new Bus_Search(driver);
		bs.SearchForAnOrigin();
		bs.SearchCity1("Mumbai");
		bs.City1("Mumbai");
		bs.searchForADestination();
		bs.SearchCity2("Pune");
		bs.City2("Pune");
		bs.SelectADate();
		bs.selectDate("30");
		bs.Search();
		Thread.sleep(9000);
        String actualMessage = bs.searchvalidation();
        
        if (actualMessage.contains("Sorry")) {
            Assert.assertTrue(actualMessage.contains("Sorry"),
                    "Expected 'Sorry' message but got: " + actualMessage);
        } else if (actualMessage.contains("Showing")) {
            Assert.assertTrue(actualMessage.contains("Showing"),
                    "Expected 'Showing' results message but got: " + actualMessage);
        } else {
            Assert.fail("Unexpected search validation message: " + actualMessage);
        }
    }	
	}

