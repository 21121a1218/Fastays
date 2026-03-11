package Bus_Pageobjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bus_Search extends Baseclass{
	WebDriver driver;
	WebDriverWait wait;
	   public Bus_Search(WebDriver driver)
	   {
		   super(driver);
		   wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	   }
@FindBy(xpath="//input[@placeholder='Search for an Origin...']") WebElement searchForAnOrigin;

@FindBy(xpath="//input[@placeholder='Search City']") WebElement searchCity1;

@FindBy(xpath="//div[@class='px-4 py-2 cursor-pointer hover:bg-primary hover:text-white']") List<WebElement> city1;

@FindBy(xpath="//input[contains(@placeholder,'Search for a Destination...')]") WebElement searchForADestination;

@FindBy(xpath="//input[@placeholder='Search City']") WebElement searchCity2;

@FindBy(xpath="//div[normalize-space()='Bandal ( Sirsi )']") WebElement firstcity;

@FindBy(xpath="//input[contains(@placeholder,'Select a date')]") WebElement selectADate;

@FindBy(xpath="//button[contains(@class,'w-full') and contains(@class,'aspect-square') and contains(@class,'rounded-md')]") List<WebElement> dates;

@FindBy(xpath="//button[contains(text(),'→')]") WebElement cal_forward;

@FindBy(xpath="//button[contains(text(),'←')]") WebElement cal_backward;

@FindBy(xpath="//button[normalize-space()='Search']") WebElement search;

@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div[2]/div[3]/div/div[1]/p") WebElement searchmessage;

@FindBy(xpath="//h2[@class='text-base font-semibold text-gray-700']") WebElement currmonth;


public void SearchForAnOrigin()
{
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	wait.until(ExpectedConditions.visibilityOf(searchForAnOrigin)).click();
}
public void SearchCity1(String city1)
{
	wait.until(ExpectedConditions.visibilityOf(searchCity1)).sendKeys(city1);
}
public void City1(String City1) {
	wait.until(ExpectedConditions.visibilityOfAllElements(city1));

    for (WebElement city : city1) {
        if (city.getText().equals(City1)) {
            city.click();
            break; // stop after clicking
        }
    }
}
public void searchForADestination()
{
	wait.until(ExpectedConditions.visibilityOf(searchForADestination)).click();
}
public void SearchCity2(String city2)
{
	wait.until(ExpectedConditions.visibilityOf(searchCity2)).sendKeys(city2);
}
public void City2(String City2)
{
	wait.until(ExpectedConditions.visibilityOfAllElements(city1));

    for (WebElement city : city1) {
        if (city.getText().equals(City2)) {
            city.click();
            break; // stop after clicking
        }
    }
}
public void SelectADate()
{
	wait.until(ExpectedConditions.visibilityOf(selectADate)).click();
}
public void selectDate(String day) {
    wait.until(ExpectedConditions.visibilityOfAllElements(dates));
    for (WebElement date : dates) {
        if (date.getText().equals(day)) {
            date.click();
            break;
        }
    }
}
public void Cal_forward()
{
	wait.until(ExpectedConditions.visibilityOf(cal_forward)).click();
}
public void Cal_backward()
{
	wait.until(ExpectedConditions.visibilityOf(cal_backward)).click();
}
public void Search()
{
	wait.until(ExpectedConditions.visibilityOf(search)).click();
}
public String searchvalidation()
{
	return wait.until(ExpectedConditions.visibilityOf(searchmessage)).getText();
}
public boolean searchbutton()
{
	if(!search.isEnabled())
	{
		return false;
	}
	return true;
}

public boolean verifyPastDatesDisabled() {
    // Get today's date
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");

    boolean allPastDisabled = true;

    for (WebElement date : dates) {
        String dayText = date.getText().trim();
        if (!dayText.isEmpty()) {
            int day = Integer.parseInt(dayText);
            LocalDate dateValue = LocalDate.of(today.getYear(), today.getMonth(), day);

            if (dateValue.isBefore(today)) {
                // Check if date is disabled
                if (date.isEnabled()) {
                    System.out.println("Past date " + day + " is not disabled!");
                    allPastDisabled = false;
                }
            }
        }
    }

    return allPastDisabled;
}
public void City3()
{
	wait.until(ExpectedConditions.visibilityOf(firstcity)).click();
}
public String getCalendarMonth()
{
	return wait.until(ExpectedConditions.visibilityOf(currmonth)).getText();
}
}


