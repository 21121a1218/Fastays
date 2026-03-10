package Bus_Testcases;

import org.testng.annotations.Test;

import Bus_Pageobjects.Bus_Booking_flow;
import Bus_Pageobjects.Bus_Search;
import Bus_Pageobjects.Searchresultcards_and_Filters;
import Login_Pageobjects.Login;

public class TC_Booking extends BaseTestcase{
	@Test
void book() throws InterruptedException
{
  Login lg=new Login(driver);
  Bus_Search bs=new Bus_Search(driver);
  Bus_Booking_flow bf=new Bus_Booking_flow(driver); 
  Searchresultcards_and_Filters sf=new Searchresultcards_and_Filters(driver);
  lg.login();
  lg.number("6300370135");
  lg.Continue_Button();
  lg.otp1("8");
  lg.otp2("1");
  lg.otp3("2");
  lg.otp4("3");
  lg.submit();
  Thread.sleep(2000);
  bs.SearchForAnOrigin();
  bs.SearchCity1("Hyderabad");
  bs.City1("Hyderabad");
  bs.searchForADestination();
  bs.SearchCity2("Kurnool");
  bs.City2("Kurnool");
  bs.SelectADate();
  bs.selectDate("21");
  bs.Search();
  sf.selectseat();
  bf.Continue();
  bf.chooseYourBoardingPoint("abids");
  bf.chooseYourDroppingPoint("Byepass");
  bf.Continue();
  bf.AddPassenger();
  bf.Passengerdetails("Veru", "Stephene", "21");
  bf.Detailssent("9381483697","", "Trinty");
   bf.Submit();
  bf.payNow(driver);
  Thread.sleep(3000);
  bf.bankPayment(driver);
  bf.home();
}
}
