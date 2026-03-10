package Hotel_Pageobjects;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hotel_Booking_Flow extends BaseClass{
      WebDriver driver;
      WebDriverWait wait;
      WebDriverWait wait2;
	public Hotel_Booking_Flow(WebDriver driver) {
		super(driver);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(90));
	}
	
	@FindBy(xpath = "//h2[contains(@class,'text-lg') and contains(@class,'cursor-pointer')]")
	List<WebElement> roomList;
	@FindBy(xpath="//button[@type='button'][normalize-space()='Select Room']")
	List <WebElement> selectroom;
	@FindBy(xpath="(//select[@name='adults[0].title'])")
	WebElement tittle;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/main/form/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/select")
	WebElement childtittle;
	@FindBy(xpath="//input[@name='adults[0].firstName']")
	WebElement firstname;
	@FindBy(xpath="//input[@name='childs[0].firstName']")
	WebElement childfirstname;
	@FindBy(xpath="//input[@name='adults[0].lastName']")
	WebElement lastname;
	@FindBy(xpath="//input[@name='childs[0].lastName']")
	WebElement childlastname;
	@FindBy(xpath="(//select[@name='adults[0].gender'])")
	WebElement gender;
	@FindBy(xpath="(//select[@class='block w-full border border-gray-300 bg-white text-sm rounded-md py-2.5 px-1 text-muted outline-none '])[2]")
	WebElement childgender;
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement email;
	@FindBy(xpath="//input[@placeholder='Enter Phone Number']")
	WebElement phonenumber;
	@FindBy(xpath="//button[normalize-space()='PAY NOW']") 
	WebElement Paynow;
	@FindBy(xpath="//button[normalize-space()='Success']") 
	WebElement success;
	@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/button") 
	WebElement home;
	@FindBy(xpath="//*[@id=\"nav-sidebar\"]/div[1]/label[2]/div/div") 
	WebElement netbanking;
	@FindBy(xpath="//*[@id=\"main-stack-container\"]/div/div/div/div/div[2]/div/div/form[1]/div/label[1]/div/div/div/div/span")
	WebElement bod;
	@FindBy(xpath="//div[@class='text-red-500 text-xs']")
	List <WebElement> deatailvalidations;
	
	public void clickFirstRoom(int i) {
	    wait.until(ExpectedConditions.visibilityOfAllElements(roomList));
	    roomList.get(i).click();
	}
	public void seeavailablity(int i)
	{
		 wait.until(ExpectedConditions.visibilityOfAllElements(roomList));
		    roomList.get(i).click();
		    String parentWindow = driver.getWindowHandle();
		    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		    for (String win : driver.getWindowHandles()) {
		        if (!win.equals(parentWindow)) {
		            driver.switchTo().window(win);
		            break;
		        }
		    }
		    
	}
	public void selectroom(int i)
	{
		String parentWindow = driver.getWindowHandle();
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	    for (String win : driver.getWindowHandles()) {
	        if (!win.equals(parentWindow)) {
	            driver.switchTo().window(win);
	            break;
	        }
	    }
	    wait.until(ExpectedConditions.visibilityOfAllElements(selectroom));
	    selectroom.get(i).click();
	}
	public void tittle()
	{
		wait.until(ExpectedConditions.visibilityOf(tittle));
		Select titt=new Select(tittle);
		titt.selectByVisibleText("Mr");
	}
	public void firstname(String fs)
	{
		wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(fs);
	}
	public void lastname(String ls)
	{
		wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(ls);
	}
	public void email(String Email)
	{
		WebElement mail=wait.until(ExpectedConditions.visibilityOf(email));
		mail.clear();
		mail.clear();
		mail.sendKeys(Email);
	}
	public void phonenumber(String pn)
	{
		wait.until(ExpectedConditions.visibilityOf(phonenumber)).sendKeys(pn);
	}
	public void gender()
	{
		wait.until(ExpectedConditions.visibilityOf(gender));
		Select titt=new Select(gender);
		titt.selectByVisibleText("Male");
	}
	public void pay()
	{
		wait.until(ExpectedConditions.visibilityOf(Paynow)).click();;
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
		wait2.until(ExpectedConditions.elementToBeClickable(home));
		Actions act=new Actions(driver);
		act.moveToElement(home).perform();
		act.click().perform();
	}
	public void childtittle()
	{  
		wait.until(ExpectedConditions.visibilityOf(childtittle));
		Select Childtittle=new Select(childtittle);
		Childtittle.selectByVisibleText("Mr");
	}
	public void childfirstname(String fs)
	{
		wait.until(ExpectedConditions.visibilityOf(childfirstname)).sendKeys(fs);
	}
	public void childlastname(String ls)
	{
		wait.until(ExpectedConditions.visibilityOf(childlastname)).sendKeys(ls);
	}
	public void childgender()
	{
		wait.until(ExpectedConditions.visibilityOf(childgender));
		Select titt=new Select(childgender);
		titt.selectByVisibleText("Male");
	}
	public boolean formvalidation()
	{
	    boolean answer = true;

	    if (deatailvalidations.size() > 0) {

	        for (WebElement validation : deatailvalidations) {
	            if (validation.isDisplayed()) {
	                return false;
	            }
	        }

	    } else {
	        System.out.println("No validation messages present");
	    }

	    return answer;
	}
	public boolean verifyhome()
	{
		return driver.getCurrentUrl().contains("https://uat.fastays.com/");
	}

	
		
}
