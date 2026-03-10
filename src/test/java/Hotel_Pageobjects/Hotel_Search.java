package Hotel_Pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hotel_Search extends BaseClass {
  
    public WebDriver driver;
    public WebDriverWait wait;

    public Hotel_Search(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    @FindBy(xpath="//input[@placeholder='Search for a city']")
    WebElement SearchCity;

    @FindBy(xpath="//input[@placeholder='Search city']")
    WebElement City;

    @FindBy(xpath="//div[@class='px-4 py-2 cursor-pointer hover:bg-primary hover:text-white text-xs']")
    WebElement CityName;

    @FindBy(xpath="//input[@class='rounded-lg p-2 text-sm w-full  focus:outline-none truncate']")
    WebElement Date;

    @FindBy(xpath="//div[contains(@class,'hidden md:block')]//div[contains(@class,'text-xs cursor-pointer rounded px-1 py-1 hover:bg-sky-100 text-black')][normalize-space()='28']")
    WebElement checkin;

    @FindBy(xpath="//div[contains(@class,'hidden md:block')]//div[contains(@class,'text-xs cursor-pointer rounded px-1 py-1 hover:bg-sky-100 text-black')][normalize-space()='29']")
    WebElement checkout;

    @FindBy(xpath="//button[@class='border text-sm w-full md:min-w-52 outline-none bg-white whitespace-nowrap overflow-hidden rounded-md px-2 py-2 text-left']")
    WebElement guest;
    @FindBy(xpath="(//button[@class='flex items-center justify-center px-2 text-lg border border-gray-200 rounded-lg hover:bg-gray-50'][normalize-space()='+'])[1]")
    WebElement addadult;
    @FindBy(xpath="(//button[@class='flex items-center justify-center px-2 text-lg border border-gray-200 rounded-lg hover:bg-gray-50'][normalize-space()='+'])[2]")
    WebElement addchild;
    @FindBy(xpath="//button[@class='flex items-center justify-center px-2 text-lg border border-gray-200 rounded-md hover:bg-gray-50'][normalize-space()='+']")
    WebElement addroom;
    
    @FindBy(xpath="(//button[contains(@type,'button')][contains(text(),'+')])[1]")
    WebElement roomcountadd;

    @FindBy(xpath="(//button[contains(@type,'button')][contains(text(),'−')])[1]")
    WebElement roomcountsub;

    @FindBy(xpath="(//button[contains(@type,'button')][contains(text(),'−')])[2]")
    WebElement adultcountsub;

    @FindBy(xpath="(//button[contains(@type,'button')][contains(text(),'+')])[2]")
    WebElement adultcountadd;

    @FindBy(xpath="(//button[contains(@type,'button')][contains(text(),'+')])[3]")
    WebElement childcountadd;

    @FindBy(xpath="(//button[contains(@type,'button')][contains(text(),'−')])[3]")
    WebElement childcountsub;

    @FindBy(xpath="//button[normalize-space()='Search']")
    WebElement Searchbutton;

    @FindBy(xpath="//p[@class='text-md font-semibold text-foreground']")
    WebElement resultcount;
    
    @FindBy(xpath="//p[normalize-space()='Chennai']")
    WebElement chennai;
    
    public void SearchCity() {
        wait.until(ExpectedConditions.visibilityOf(SearchCity)).click();    
    }

    public void City() {
        wait.until(ExpectedConditions.visibilityOf(City)).sendKeys("Abu Road");
    }

  
    public void CityName() {

        wait.until(ExpectedConditions.visibilityOf(CityName));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "var el = arguments[0];" +
            "var rect = el.getBoundingClientRect();" +
            "var x = rect.left + rect.width / 2;" +
            "var y = rect.top + rect.height / 2;" +
            "var evt = new MouseEvent('mousedown', {clientX:x, clientY:y, bubbles:true});" +
            "el.dispatchEvent(evt);" +
            "evt = new MouseEvent('mouseup', {clientX:x, clientY:y, bubbles:true});" +
            "el.dispatchEvent(evt);" +
            "evt = new MouseEvent('click', {clientX:x, clientY:y, bubbles:true});" +
            "el.dispatchEvent(evt);",
            CityName
        );
    }
    public void Date() {
        wait.until(ExpectedConditions.visibilityOf(Date)).click();
    }

    public void checkin() {
        wait.until(ExpectedConditions.visibilityOf(checkin)).click();
    }

    public void checkout() {
        wait.until(ExpectedConditions.visibilityOf(checkout)).click();
    }

    public void guest() {
        wait.until(ExpectedConditions.visibilityOf(guest)).click();
        wait.until(ExpectedConditions.visibilityOf(addchild)).click();
    }

    public void roomcountadd() {
        wait.until(ExpectedConditions.visibilityOf(roomcountadd)).click();
    }

    public void roomcountsub() {
        wait.until(ExpectedConditions.visibilityOf(roomcountsub)).click();
    }

    public void adultcountsub() {
        wait.until(ExpectedConditions.visibilityOf(adultcountsub)).click();
    }

    public void adultcountadd() {
        wait.until(ExpectedConditions.visibilityOf(adultcountadd)).click();
    }

    public void childcountadd() {
        wait.until(ExpectedConditions.visibilityOf(childcountadd)).click();
    }
    
    public void childcountsub() {
        wait.until(ExpectedConditions.visibilityOf(childcountsub)).click();
    }

    public void Searchbutton() {
        wait.until(ExpectedConditions.visibilityOf(Searchbutton)).click();
    }
    
    public String resultcount() {
        return wait.until(ExpectedConditions.visibilityOf(resultcount)).getText();
    }
    public void chennai() {
         wait.until(ExpectedConditions.visibilityOf(chennai)).click();
    }
    public String[] getSplitDates() {

    	WebElement dateElement = wait.until(ExpectedConditions.visibilityOf(Date));

        String fullText = dateElement.getAttribute("value");
        if (fullText == null || fullText.trim().isEmpty()) {
            throw new RuntimeException("Date value is null or empty!");
        }

        String[] dates = fullText.split("\\s*-\\s*");
        return dates;
    }

    public String getguestdetails() {
        return wait.until(ExpectedConditions.visibilityOf(guest)).getText().replaceAll(",", "");
    } 
    
    
}
