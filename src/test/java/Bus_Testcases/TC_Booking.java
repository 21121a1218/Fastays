package Bus_Testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Booking_flow;
import Bus_Pageobjects.Bus_Search;
import Bus_Pageobjects.Searchresultcards_and_Filters;
import Login_Pageobjects.Login;
import Utilities.ExtentListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Listeners({ExtentListener.class, Utilities.RetryListener.class})
public class TC_Booking extends BaseTestcase {

	 private static final Logger log = LogManager.getLogger(TC_Booking.class);
    @Test(priority = 1)
    public void loginTest() {

        log.info("===== LOGIN TEST STARTED =====");

        Login lg = new Login(driver);

        lg.login();
        lg.number("6300370135");
        lg.Continue_Button();

        lg.otp1("8");
        lg.otp2("1");
        lg.otp3("2");
        lg.otp4("3");

        lg.submit();

        log.info("===== LOGIN SUCCESSFUL =====");
    }

    @Test(priority = 2)
    public void searchBusTest() {

        log.info("===== BUS SEARCH TEST STARTED =====");

        Bus_Search bs = new Bus_Search(driver);

        bs.SearchForAnOrigin();
        bs.SearchCity1("Hyderabad");
        bs.City1("Hyderabad");

        bs.searchForADestination();
        bs.SearchCity2("Kurnool");
        bs.City2("Kurnool");

        bs.SelectADate();
        bs.selectDate("21");

        bs.Search();

        log.info("===== BUS SEARCH COMPLETED =====");
    }

    @Test(priority = 3)
    public void selectSeatTest() {

        log.info("===== SEAT SELECTION STARTED =====");

        Searchresultcards_and_Filters sf =
                new Searchresultcards_and_Filters(driver);

        sf.selectseat();

        log.info("===== SEAT SELECTED SUCCESSFULLY =====");
    }

    @Test(priority = 4)
    public void passengerDetailsTest() {

        log.info("===== PASSENGER DETAILS TEST STARTED =====");

        Bus_Booking_flow bf = new Bus_Booking_flow(driver);

        bf.Continue();

        bf.chooseYourBoardingPoint("abids");
        bf.chooseYourDroppingPoint("Byepass");

        bf.Continue();

        bf.AddPassenger();

        bf.Passengerdetails("Veru", "Stephene", "21");

        bf.Detailssent("9381483697", "", "Trinty");

        bf.Submit();

        log.info("===== PASSENGER DETAILS SUBMITTED =====");
    }

    @Test(priority = 5)
    public void paymentTest() throws InterruptedException {

        log.info("===== PAYMENT TEST STARTED =====");

        Bus_Booking_flow bf = new Bus_Booking_flow(driver);

        bf.payNow(driver);

        Thread.sleep(3000);

        bf.bankPayment(driver);

        bf.home();

        log.info("===== PAYMENT FLOW COMPLETED =====");
    }
}