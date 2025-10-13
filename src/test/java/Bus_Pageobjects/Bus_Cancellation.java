package Bus_Pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bus_Cancellation extends Baseclass{
	WebDriver driver;
	WebDriverWait wait;
	   public Bus_Cancellation(WebDriver driver)
	   {
		   super(driver);
		   wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	   }

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/h1") WebElement hiVaru;
@FindBy(xpath="//h2[normalize-space()='My Bookings']") WebElement myBookings;
@FindBy(xpath="//select[contains(@class,'block md:w-full w-1/2 px-3 py-2 text-sm cursor-pointer text-center text-white bg-black rounded-md outline-none')]") WebElement allFlightsHotelsBusesPackages;
//@FindBy(xpath="//h2[@class='text-base sm:text-lg font-bold truncate']")WebElement ;
@FindBy(xpath="//button[normalize-space()='Upcoming']") WebElement upcomming;
@FindBy(xpath="//button[contains(text(),'View Bus Details >')]") List<WebElement> viewBusDetails;
@FindBy(xpath="//button[contains(@class,'py-1 px-4 text-center rounded hidden w-40 px-4 py-2 text-white rounded-md bg-primary md:block hidden w-40 px-4 py-2 text-white rounded-md bg-primary md:block cursor-pointer')]") WebElement cancelBooking;
@FindBy(xpath="//label[@class='flex items-center space-x-2 text-xs text-gray-700 cursor-pointer']")List <WebElement> Reason;
@FindBy(xpath="//button[normalize-space()='Next']") WebElement next;
@FindBy(xpath="//button[normalize-space()='Confirm']") WebElement confirm;
@FindBy(xpath="//button[normalize-space()='Back']") WebElement back;
@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/button") WebElement home;
public void mybusbookings()
{
	wait.until(ExpectedConditions.visibilityOf(hiVaru)).click();
	wait.until(ExpectedConditions.visibilityOf(myBookings)).click();
	Select type=new Select(wait.until(ExpectedConditions.visibilityOf(allFlightsHotelsBusesPackages)));
	type.selectByContainsVisibleText("Buses");
}
public void cancell()
{
	wait.until(ExpectedConditions.visibilityOf(upcomming)).click();
	wait.until(ExpectedConditions.visibilityOfAllElements(viewBusDetails));
	if(!viewBusDetails.isEmpty())
	{
		viewBusDetails.get(0).click();	
		}
	wait.until(ExpectedConditions.visibilityOf(cancelBooking)).click();
	wait.until(ExpectedConditions.visibilityOfAllElements(Reason));
	if(!Reason.isEmpty())
	{
		Reason.get(0).click();
	}
	wait.until(ExpectedConditions.visibilityOf(next)).click();
	wait.until(ExpectedConditions.visibilityOf(confirm)).click();
}   
public void home()
{
	wait.until(ExpectedConditions.elementToBeClickable(home)).click();
}
}
