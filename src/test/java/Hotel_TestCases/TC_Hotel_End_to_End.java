package Hotel_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Hotel_Pageobjects.Hotel_Booking_Flow;
import Hotel_Pageobjects.Hotel_End_to_End_Verification;
import Login_Pageobjects.Login;
import org.testng.annotations.Listeners;
import Utilities.ExtentListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Listeners({ExtentListener.class, Utilities.RetryListener.class})
public class TC_Hotel_End_to_End extends BaseTestCase {

    private static final Logger log = LogManager.getLogger(TC_Hotel_End_to_End.class);

	private int index=0;
	 private String hotelname;
	 private String rating;
	 private String address;
	 private String date1;
	 private String date2;
	 private String Room;
	 private String refundinfo;
	 private String base;
	 
    @Test
    public void login() throws InterruptedException {

        log.info("===== LOGIN TEST STARTED =====");

        Login lg = new Login(driver);

        lg.login();
        log.info("Clicked login");

        lg.number("6300370135");
        log.info("Entered mobile number");

        lg.Continue_Button();
        log.info("Clicked continue");

        lg.otp1("8");
        lg.otp2("1");
        lg.otp3("2");
        lg.otp4("3");
        log.info("Entered OTP");

        lg.submit();
        log.info("Clicked submit");

        Thread.sleep(3000);
        lg.verifyLogin();
        log.info("Login successful");
    }

    @Test(dependsOnMethods = "login")
    public void Hotel_Search() throws InterruptedException {

        log.info("===== HOTEL SEARCH STARTED =====");

        Hotel_Pageobjects.Hotel_Search hs =
                new Hotel_Pageobjects.Hotel_Search(driver);
        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        hs.SearchCity();
        Thread.sleep(2000);
        hs.City();
        Thread.sleep(2000);
        hs.CityName();
        Thread.sleep(2000);
        hs.Date();
        hs.checkin();
        hs.checkout();
        hs.guest();
        hs.Searchbutton();
        Thread.sleep(10000);

        Assert.assertTrue(
                hs.resultcount().contains("Search Results"),
                "Search Failed"
        );

        log.info("Search Results displayed");

        hotelname=end.hotelname(index);
        rating=end.reviess(index);
        address=end.hoteladrress(index);
        date1=hs.getSplitDates()[0].replaceAll("[^0-9]", "");
        System.out.println(date1);
        date2=hs.getSplitDates()[1].replaceAll("[^0-9]", "");
        System.out.println(date2);

        log.info("Stored hotel data from search page");
    }

    @Test(dependsOnMethods = "Hotel_Search")
    public void verifyseeavialblty() {

        log.info("===== VERIFY SEE AVAILABILITY =====");

        Hotel_Booking_Flow hb = new Hotel_Booking_Flow(driver);
        hb.seeavailablity(index);
        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);
       
        Assert.assertTrue(
                driver.getCurrentUrl().contains("hotels/details"),
                "Redirection failed"
        );

        log.info("Redirection to hotel details successful");
    }
  
    @Test(dependsOnMethods = "verifyseeavialblty")
    public void SelectedHotelname_verfiy() throws InterruptedException {

        log.info("===== VERIFY SELECTED HOTEL NAME =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);
         Thread.sleep(3000);

        Assert.assertTrue(
                end.hoteldeatils().contains(hotelname),
                "Hotel Name Mismatch"
        );

        log.info("Hotel name verified successfully");
    }

    @Test(dependsOnMethods = "SelectedHotelname_verfiy")
    public void viewonMap_verfiy() throws InterruptedException {

        log.info("===== VERIFY VIEW ON MAP =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);
        Thread.sleep(3000);

        Assert.assertTrue(end.clicKmap(), "Google map not Displayed");

        log.info("Google map displayed successfully");
    }

    @Test(dependsOnMethods = "viewonMap_verfiy")
    public void aboutRoom_verfiy() {

        log.info("===== VERIFY ABOUT ROOM =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        Assert.assertTrue(end.aboutroom(), "aboutroom is Displayed");

        log.info("About room section verified");
    }

    @Test(dependsOnMethods = "aboutRoom_verfiy")
    public void amenties_verfiy() {

        log.info("===== VERIFY AMENITIES =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.amenties(), "amenties is Displayed");

        log.info("Amenities verified");
    }

    @Test(dependsOnMethods = "amenties_verfiy")
    public void location_verfiy() {

        log.info("===== VERIFY LOCATION =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.location(), "location is Displayed");

        log.info("Location verified");
    }

    @Test(dependsOnMethods = "location_verfiy")
    public void attraction_verify() {

        log.info("===== VERIFY ATTRACTIONS =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.attraction(), "attraction is Displayed");

        log.info("Attractions verified");
    }

    @Test(dependsOnMethods = "attraction_verify")
    public void reviews_verify() {

        log.info("===== VERIFY REVIEWS =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(
                end.reviews().contains(rating),
                "Reviews mismatch"
        );

        log.info("Reviews verified");
    }

    @Test(dependsOnMethods = "reviews_verify")
    public void Select_roomverify1() {

        log.info("===== SELECT ROOM VERIFY 1 =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        end.clickrooms();
        Room=end.roomdata(1);
        refundinfo=end.refundableinfos(1);
        base=end.roomprice(1);
        end.selectrooms(1);

        Assert.assertTrue(
                end.propertyhotelname().contains(hotelname),
                "Hotel Data is Wrong"
        );

        log.info("Room selected and hotel name verified");
    }

    @Test(dependsOnMethods = "Select_roomverify1")
    public void Select_roomverify2() {

        log.info("===== SELECT ROOM VERIFY 2 =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        System.out.println(end.propertyhoteladdress());
        System.out.println(address);

        Assert.assertTrue(
                end.propertyhoteladdress().contains(address.replace("...", "")),
                "Hotel Data is Wrong"
        );

        log.info("Hotel address verified");
    }

    @Test(dependsOnMethods = "Select_roomverify2")
    public void verify_policy() {

        log.info("===== VERIFY POLICY =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.viewhotelpolicy(), "Hotel policy not displayed");

        log.info("Hotel policy verified");
    }

    @Test(dependsOnMethods = "verify_policy")
    public void verify_iterny() {

        log.info("===== VERIFY ITINERARY =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.viewhotelpolicy(), "Hotel policy not displayed");

        log.info("Itinerary verified");
    }

    @Test(dependsOnMethods = "verify_iterny")
    public void verifyStartDate() {

        log.info("===== VERIFY START DATE =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        System.out.println(end.checkindate());  

        Assert.assertTrue(
                end.checkindate().equals(date1),
                "Checkin Date Wrong"
        );

        log.info("Checkin date verified");
    }

    @Test(dependsOnMethods = "verifyStartDate")
    public void verifyEndDate() {

        log.info("===== VERIFY END DATE =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        System.out.println(end.checkoutdate());

        Assert.assertTrue(
                end.checkoutdate().equals(date2),
                "Checkout Date Wrong"
        );

        log.info("Checkout date verified");
    }

    @Test(dependsOnMethods = "verifyEndDate")
    public void verifyRoomDetails() {

        log.info("===== VERIFY ROOM DETAILS =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(
                end.roominfoverify().contains(Room),
                "Wrong Room Selected"
        );

        log.info("Room details verified");
    }

    @Test(dependsOnMethods = "verifyRoomDetails")
    public void verifyrefundinfo() {

        log.info("===== VERIFY REFUND INFO =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(
                end.verifyrefundableinfo().contains(refundinfo),
                "Wrong Room Selected"
        );

        log.info("Refund info verified");
    }

    @Test(dependsOnMethods = "verifyrefundinfo")
    public void fillthedeatils() {

        log.info("===== FILL DETAILS =====");

    	 Hotel_End_to_End_Verification end =
                 new Hotel_End_to_End_Verification(driver);
        Hotel_Booking_Flow hb = new Hotel_Booking_Flow(driver);

        String fname = randomString();
        String lname = randomString();
        String childFname = randomString();
        String childLname = randomString();
        String phone = randomNumeric();

        hb.tittle();
        hb.firstname(fname);
        hb.lastname(lname);
        hb.gender();

        end.addChild();

        hb.childtittle();
        hb.childgender();
        hb.childfirstname(childFname);
        hb.childlastname(childLname);
        hb.phonenumber(phone);

        log.info("Form details filled");
    }

    @Test(dependsOnMethods = "fillthedeatils")
    public void verifyBaseprice() {

        log.info("===== VERIFY BASE PRICE =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(
                end.basepriceverify().contains(base),
                "Wrong Base Price"
        );

        log.info("Base price verified");
    }

    @Test(dependsOnMethods = "verifyBaseprice")
    public void verifygstcalculation() {

        log.info("===== VERIFY GST =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.gstPriceVerify(), "Wrong Gst");

        log.info("GST verified");
    }

    @Test(dependsOnMethods = "verifygstcalculation")
    public void verifytotalprice() {

        log.info("===== VERIFY TOTAL PRICE =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.verifytotalprice(), "Wrong total");

        log.info("Total price verified");
    }

    @Test(dependsOnMethods = "verifytotalprice")
    public void verifyoffer() throws InterruptedException {

        log.info("===== VERIFY OFFER =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.applyOffer(0), "Wrong total");

        log.info("Offer applied and verified");
    }
      
    @Test(dependsOnMethods = "verifyoffer")
    public void verifyclearoffer() throws InterruptedException {

        log.info("===== VERIFY CLEAR OFFER =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue( end.clearOffers(), "Wrong total");

        log.info("Offer cleared successfully");
    }

    @Test(dependsOnMethods = "verifyclearoffer")
    public void verifypolicycheckbox() {

        log.info("===== VERIFY POLICY CHECKBOX =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);

        Assert.assertTrue(end.terms(), "Wrong total");

        log.info("Policy checkbox verified");
    }

    @Test(dependsOnMethods = "verifypolicycheckbox")
    public void Book() {

        log.info("===== BOOKING PROCESS STARTED =====");

        Hotel_End_to_End_Verification end =
                new Hotel_End_to_End_Verification(driver);
        Hotel_Booking_Flow hb=new Hotel_Booking_Flow(driver);

        hb.pay();
		hb.bankPayment(driver);
		hb.home();

		Assert.assertTrue(hb.verifyhome(), "Booking is failed");

        log.info("Booking completed successfully");
    }
}
