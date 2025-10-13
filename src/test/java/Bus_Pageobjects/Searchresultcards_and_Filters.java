package Bus_Pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searchresultcards_and_Filters extends Baseclass{
	WebDriver driver;
	WebDriverWait wait;
	   public Searchresultcards_and_Filters(WebDriver driver)
	   {
		   super(driver);
		   wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	   }
	 
@FindBy(xpath="//p[@class='mt-2 bg-green-100 text-green-700 md:text-xs md:px-2 text-[10px] px-1 py-1 w-fit rounded']") WebElement seatsleft;
@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/p/button") WebElement viewCancellationPolicies;
@FindBy(xpath="//button[normalize-space()='Low Price']") WebElement lowPrice;
@FindBy(xpath="//button[normalize-space()='High Price']") WebElement highPrice;
@FindBy(xpath="//button//span[normalize-space()='Before 6AM']") WebElement before6AM;
@FindBy(xpath="//button//span[normalize-space()='6AM-12PM']") WebElement sixAM12PM;
@FindBy(xpath="//button//span[normalize-space()='12PM-6PM']") WebElement twelvePM6PM;
@FindBy(xpath="//button//span[normalize-space()='After 6PM']") WebElement after6PM;
@FindBy(xpath="//button//span[normalize-space()='A/C']") WebElement AC;
@FindBy(xpath="//button//span[normalize-space()='Non A/C']") WebElement NonAC;
@FindBy(xpath="//button//span[normalize-space()='Sleeper']") WebElement Sleeper;
@FindBy(xpath="//button//span[normalize-space()='Seater']") WebElement Seater;
@FindBy(xpath="//button//span[normalize-space()='Semi Sleeper']") WebElement Semisleeper;
@FindBy(xpath="//input[@placeholder='Select Boarding Point']") WebElement selectBoardingPoint;
@FindBy(xpath="//input[@placeholder='Search...']") WebElement search;
@FindBy(xpath="//label[normalize-space()='Abids']") WebElement abids;
@FindBy(xpath="//button[normalize-space()='Cancel']") WebElement cancel;
@FindBy(xpath="//button[normalize-space()='Apply']") WebElement apply;
@FindBy(xpath="//input[@placeholder='Select Dropping Point']") WebElement selectDroppingPoint;
@FindBy(xpath="//label[normalize-space()='ByePass']") WebElement byePass;
@FindBy(xpath="//button[normalize-space()='Clear All']") WebElement clearAll;
@FindBy(xpath="//div[@class='w-full sm:w-auto mt-4 flex justify-start sm:justify-end']//button") List <WebElement> selectSeats;
@FindBy(xpath="//div[@style='width: 60px; height: 24px;' and not(contains(@class, 'bg-gray-300')) and not(contains(@class, 'bg-pink-300')) and not(contains(@class, 'bg-blue-300'))]") List<WebElement> Seat;
@FindBy(xpath="//button[normalize-space()='Close']") WebElement close;
@FindBy(xpath="//div[@class='z-10  md:p-6 p-4 bg-white rounded shadow-lg relative']") WebElement cancellationtab;
@FindBy(xpath="//p[contains(text(),'₹')]") List <WebElement> prices;
@FindBy(xpath="//div[@class='flex flex-col items-start justify-center min-h-[60px]']//p[@class='md:text-2xl text-lg font-semibold']") WebElement Timing;
@FindBy(xpath="//div//div//div//div//p[@class='text-gray-500 md:text-sm text-xs']") WebElement bustype;
@FindBy(xpath="//div[@class='flex flex-col items-start justify-center min-h-[60px]']//span") WebElement boardingpoint;
@FindBy(xpath="//div[@class='flex flex-col items-end justify-center min-h-[60px]']//span") WebElement droppingpoint;
@FindBy(xpath="//div[@class='p-4 rounded-lg shadow-md bg-white mx-auto m-2']") List<WebElement>  noofresults;
@FindBy(xpath="//p[contains(@class,'text-lg font-semibold text-foreground')]") WebElement resultcount;
@FindBy(xpath="//button[contains(text(),'✕')]") WebElement closepolicytab;

public boolean seatsleft() {
    String seatsLeftText = wait.until(ExpectedConditions.visibilityOf(seatsleft)).getText();
    int seatcount = Integer.parseInt(seatsLeftText.replaceAll("[^0-9]", ""));
    wait.until(ExpectedConditions.visibilityOfAllElements(selectSeats));
    if (!selectSeats.isEmpty()) 
	{
    	selectSeats.get(3).click();
	}
    return seatcount == Seat.size();
}
public void selectseat()
{
	 wait.until(ExpectedConditions.visibilityOfAllElements(selectSeats)); 
	 if (!selectSeats.isEmpty()) 
		{
	    	selectSeats.get(3).click();
		}
		if (!Seat.isEmpty()) 
		{
		    Seat.get(0).click();
		}
}
public void close_btn()
{
	wait.until(ExpectedConditions.visibilityOf(close)).click();
}
public boolean cancellationPolicy() {
    // Click the button
    wait.until(ExpectedConditions.visibilityOf(viewCancellationPolicies)).click();

    // Wait for cancellation tab to be visible
    boolean isVisible = wait.until(ExpectedConditions.visibilityOf(cancellationtab)).isDisplayed();

    // Close the tab if visible
    if (isVisible) {
        wait.until(ExpectedConditions.elementToBeClickable(closepolicytab)).click();
    }

    return isVisible;
}

public boolean checklowprice() {
	wait.until(ExpectedConditions.visibilityOf(lowPrice)).click();
    List<Double> numbers = new ArrayList<>();

    for (WebElement element : prices) {
        String text = element.getText().trim();

        if (!text.isEmpty()) {
            String cleaned = text.replace("₹", "").replace(",", "").trim();
            try {
                numbers.add(Double.parseDouble(cleaned));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + cleaned);
                return false;
            }
        }
    }
    for (int i = 0; i < numbers.size() - 1; i++) {
        if (numbers.get(i) > numbers.get(i + 1)) {
            return false;
        }
    }

    return true;
}
public boolean checkhighprice() {
	wait.until(ExpectedConditions.visibilityOf(highPrice)).click();
    List<Double> numbers = new ArrayList<>();

    for (WebElement element : prices) {
        String text = element.getText().trim();

        if (!text.isEmpty()) {
            String cleaned = text.replace("₹", "").replace(",", "").trim();
            try {
                numbers.add(Double.parseDouble(cleaned));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + cleaned);
                return false;
            }
        }
    }
    for (int i = 0; i < numbers.size() - 1; i++) {
        if (numbers.get(i) < numbers.get(i + 1)) {
            return false; 
        }
    }

    return true;
}
public boolean Before6Am() 
{
	before6AM.click();
	
	String time=Timing.getText();
	 String hourPart = time.split(":")[0];
	 int Time = Integer.parseInt(hourPart);
	 if(Time>6)
	{
		return false;
	}
	return true;
}
public boolean  To12PM() 
{
	sixAM12PM.click();
	
	String time=Timing.getText();
	 String hourPart = time.split(":")[0];
	 int Time = Integer.parseInt(hourPart);
	 if(Time > 12 && Time < 6)
	{
		return false;
	}
	return true;
}
public boolean To6PM() 
{
	twelvePM6PM.click();
	String time=Timing.getText();
	 String hourPart = time.split(":")[0];
	 int Time = Integer.parseInt(hourPart);
	 if(Time > 18 && Time < 12)
	{
		return false;
	}
	return true;
}
public boolean After6PM() 
{
	after6PM.click();
	String time=Timing.getText();
	 String hourPart = time.split(":")[0];
	 int Time = Integer.parseInt(hourPart);
	 if(Time < 18)
	{
		return false;
	}
	return true;
}
public boolean AC() 
{
	AC.click();
	String bus=bustype.getText();
	 if(!bus.contains("A/C"))
	{
		return false;
	}
	return true;
}
public boolean nonAC() 
{
	NonAC.click();
	
	String bus=bustype.getText();
	 if(!bus.contains("Non A/C"))
	{
		return false;
	}
	return true;
}
public boolean sleeper() 
{
	Sleeper.click();
	
	String bus=bustype.getText();
	 if(!bus.contains("Sleeper"))
	{
		return false;
	}
	return true;
}
public boolean Semisleeper() 
{
	Semisleeper.click();
	
	String bus=bustype.getText();
	 if(!bus.contains("Semi Sleeper"))
	{
		return false;
	}
	return true;
}
public boolean Seater() 
{
	Seater.click();
	
	String bus=bustype.getText();
	 if(!bus.contains("Seater"))
	{
		return false;
	}
	return true;
}
public boolean selectBoardingPoint()
{
	wait.until(ExpectedConditions.visibilityOf(selectBoardingPoint)).click();
	wait.until(ExpectedConditions.visibilityOf(search)).click();
	wait.until(ExpectedConditions.visibilityOf(abids)).click();
	wait.until(ExpectedConditions.visibilityOf(apply)).click();
	String point=boardingpoint.getText();
	if(!point.contains("Abids"))
	{
		return false;
	}
	return true;
}
public boolean selectDropingPoint()
{
	wait.until(ExpectedConditions.visibilityOf(selectDroppingPoint)).click();
	wait.until(ExpectedConditions.visibilityOf(search)).click();
	wait.until(ExpectedConditions.visibilityOf(byePass)).click();
	wait.until(ExpectedConditions.visibilityOf(apply)).click();
	String point=droppingpoint.getText();
	if(!point.contains("ByePass"))
	{
		return false;
	}
	return true;
}
public boolean resultcountverify() {
    String countText = wait.until(ExpectedConditions.visibilityOf(resultcount)).getText();
    int resultcount = Integer.parseInt(countText.replaceAll("[^0-9]", ""));
    return resultcount == noofresults.size();
}
public void clearall()
{
	wait.until(ExpectedConditions.visibilityOf(clearAll)).click();
}
}
