package Bus_Pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bus_Booking_flow extends Baseclass{

	WebDriver driver;
	WebDriverWait wait;
	   public Bus_Booking_flow(WebDriver driver)
	   {
		   super(driver);
		   this.driver=driver;
		   wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	   }

@FindBy(xpath="//button[normalize-space()='Continue']") WebElement Continue;
@FindBy(xpath="//input[@placeholder='Choose your Boarding Point']") WebElement chooseYourBoardingPoint;
@FindBy(xpath="//input[@placeholder='Choose your Dropping Point']") WebElement chooseYourDroppingPoint;
@FindBy(xpath="(//ul[@class='space-y-2 px-4 my-2 max-h-40 overflow-y-auto'])[1]") List<WebElement> Boardingpoint;
@FindBy(xpath="(//ul[@class='space-y-2 px-4 my-2 max-h-40 overflow-y-auto'])[2]") List<WebElement> Droppingpoint;
@FindBy(xpath="//button[normalize-space()='Add Passenger']") WebElement addPassenger;
@FindBy(xpath="//select[@name='passengerDetails[0].title']") WebElement selectTitleMrMsMrs;
@FindBy(xpath="//input[@placeholder='Enter First Name']") WebElement enterFirstName;
@FindBy(xpath="//input[@placeholder='Enter Last Name']") WebElement enterLastName;
@FindBy(xpath="//select[contains(@id,'passengerDetails')]") WebElement gender;
@FindBy(xpath="//input[@placeholder='Enter Age']") WebElement enterAge;
@FindBy(xpath="//input[@placeholder='Enter Phone Number']") WebElement enterPhoneNumber;
@FindBy(xpath="//input[@id='email']") WebElement enterEmailAddress;
@FindBy(xpath="//input[@placeholder='Enter Address']") WebElement enterAddress;
@FindBy(xpath="//button[normalize-space()='Back']") WebElement back;
@FindBy(xpath="//button[normalize-space()='Submit']") WebElement submit;
@FindBy(xpath="//button[normalize-space()='PAY NOW']") WebElement pAYNOW;
@FindBy(xpath="//button[normalize-space()='Success']") WebElement success;
@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/button") WebElement home;
@FindBy(xpath="//*[@id=\"nav-sidebar\"]/div[1]/label[2]/div/div") WebElement netbanking;
@FindBy(xpath="//*[@id=\"main-stack-container\"]/div/div/div/div/div[2]/div/div/form[1]/div/label[1]/div/div/div/div/span") WebElement bod;
public void Continue()
{
	wait.until(ExpectedConditions.visibilityOf(Continue)).click();
}
public void chooseYourBoardingPoint(String boardingpoint) {
    wait.until(ExpectedConditions.visibilityOf(chooseYourBoardingPoint)).sendKeys(boardingpoint);
    wait.until(ExpectedConditions.visibilityOfAllElements(Boardingpoint));
    for (WebElement option : Boardingpoint) {
        if (option.getText().equalsIgnoreCase(boardingpoint)) {
            option.click();
            break;
        }
    }
}

public void chooseYourDroppingPoint(String dropingpoint)
{
	wait.until(ExpectedConditions.visibilityOf(chooseYourDroppingPoint)).sendKeys(dropingpoint);
	wait.until(ExpectedConditions.visibilityOfAllElements(Droppingpoint));
    for (WebElement option : Droppingpoint) {
        if (option.getText().equalsIgnoreCase(dropingpoint)) {
            option.click();
            break;
        }
    }
}
public void AddPassenger() {
	wait.until(ExpectedConditions.visibilityOf(addPassenger)).click();
}
public void Passengerdetails(String fs,String ls,String age)
{
	wait.until(ExpectedConditions.visibilityOf(selectTitleMrMsMrs)).click();
	Select title=new Select(selectTitleMrMsMrs);
	title.selectByContainsVisibleText("Mr");
	wait.until(ExpectedConditions.visibilityOf(enterFirstName)).sendKeys(fs);
	wait.until(ExpectedConditions.visibilityOf(enterLastName)).sendKeys(ls);
	wait.until(ExpectedConditions.visibilityOf(enterAge)).sendKeys(age);
	wait.until(ExpectedConditions.visibilityOf(gender)).click();
	Select Gender=new Select(gender);
	Gender.selectByContainsVisibleText("Male");
}
public void Detailssent(String phone,String email,String address)
{
	WebElement Phone=wait.until(ExpectedConditions.visibilityOf(enterPhoneNumber));
	Phone.clear();
	Phone.sendKeys(phone);
	
	wait.until(ExpectedConditions.visibilityOf(enterEmailAddress)).sendKeys(email);
	wait.until(ExpectedConditions.visibilityOf(enterAddress)).sendKeys(address);
}
public void Submit() {
    wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
}

public void payNow(WebDriver driver) {
    String parentWindow = driver.getWindowHandle();

    // Wait until child window opens (FastPay)
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    for (String win : driver.getWindowHandles()) {
        if (!win.equals(parentWindow)) {
            driver.switchTo().window(win); // Switch to FastPay
            break;
        }
    }

    // Click Pay Now on FastPay page
    wait.until(ExpectedConditions.elementToBeClickable(pAYNOW)).click();
}
public void bankPayment(WebDriver driver) {
    // Step 1: Switch into iframe
    WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
    driver.switchTo().frame(iframe);

    // Step 2: Select Netbanking + BoB
    netbanking.click();
    bod.click();

    // Step 3: Exit iframe but stay in FastPay child window
    driver.switchTo().defaultContent();

    // Step 4: Wait for popup window (bank page)
    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
    String fastPayWindow = driver.getWindowHandle();

    for (String win : driver.getWindowHandles()) {
        if (!win.equals(fastPayWindow)) {
            driver.switchTo().window(win); // Switch to popup
        }
    }

    // Step 5: Click Success
    wait.until(ExpectedConditions.elementToBeClickable(success)).click();

    // Step 6: Switch back to FastPay child window
    for (String win : driver.getWindowHandles()) {
        if (!win.equals(fastPayWindow)) {
            driver.switchTo().window(fastPayWindow);
            break;
        }
    }
}
public void home()
{
	wait.until(ExpectedConditions.elementToBeClickable(home)).click();
}
}
