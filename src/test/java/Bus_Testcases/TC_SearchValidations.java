package Bus_Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Search;

public class TC_SearchValidations extends BaseTestcase {

    @Test(dataProvider = "searchvalidations")
    void validation(String origin, String destination, String date) throws InterruptedException {
        Bus_Search bs = new Bus_Search(driver);

        // --- Step 1: Enter criteria ---
        if (origin != null && !origin.isEmpty()) {
            bs.SearchForAnOrigin();
            bs.SearchCity1(origin);
            bs.City1("Mumbai");
        }

        if (destination != null && !destination.isEmpty()) {
            bs.searchForADestination();
            bs.SearchCity2(destination);
            bs.City2("Pune");
        }

        if (date != null && !date.isEmpty()) {
            bs.SelectADate();
            bs.selectDate(date);
        }

        boolean initiallyEnabled = bs.searchbutton();
        if ((origin == null || origin.isEmpty()) || (destination == null || destination.isEmpty())) {
            Assert.assertFalse(initiallyEnabled,
                "Search button should be disabled when origin or destination is empty");
        } else {
            Assert.assertTrue(initiallyEnabled,
                "Search button should be enabled when both origin and destination are provided");

            bs.Search();
            boolean afterClick = bs.searchbutton();
            Assert.assertFalse(afterClick, "Search button should be disabled immediately after clicking Search");
            Thread.sleep(5000);
            bs.searchForADestination();
            bs.City3();


            boolean afterChange = bs.searchbutton();
            Assert.assertTrue(afterChange,
                "Search button should be enabled again when criteria (e.g., destination) is changed");
        }
    }

    @DataProvider
    public Object[][] searchvalidations() {
        return new Object[][] {
           {"", "Pune", "30"},     
            {"","", "30"}, 
            {"Mumbai","Pune","30"} 
        };
    }
}
