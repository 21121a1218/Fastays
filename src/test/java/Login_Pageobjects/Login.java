package Login_Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login extends Baseclass{

	WebDriver driver;
	WebDriverWait wait;
	   public Login(WebDriver driver)
	   {
		   super(driver);
		   wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	   }

@FindBy(xpath="//a[normalize-space()='Sign In / Register']") WebElement signInegister;

@FindBy(xpath="//input[@placeholder='Enter your number']") WebElement enterYourNumber;

@FindBy(xpath="//button[normalize-space()='Continue']") WebElement Continue;

@FindBy(xpath="//input[@id='otp-input-0']") WebElement EnterTheOTP_1;

@FindBy(xpath="//input[@id='otp-input-1']") WebElement EnterTheOTP_2;

@FindBy(xpath="//input[@id='otp-input-2']") WebElement EnterTheOTP_3;

@FindBy(xpath="//input[@id='otp-input-3']") WebElement EnterTheOTP_4;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/form/div[3]/button") WebElement submit;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/form/input[1]") WebElement name;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/form/input[2]") WebElement Email;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/form/button[1]") WebElement Save;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/form/button[2]") WebElement Skip;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/h1") WebElement verify;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/form/div[1]/div[2]") WebElement numvalidation;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/form/div[3]/div") WebElement otpvalidation;

public void login()
{
	wait.until(ExpectedConditions.visibilityOf(signInegister)).click();
}
public void number(String num)
{
	wait.until(ExpectedConditions.visibilityOf(enterYourNumber)).sendKeys(num);
}
public void Continue_Button()
{
	wait.until(ExpectedConditions.visibilityOf(Continue)).click();	
}
public void otp1(String otp)
{
	wait.until(ExpectedConditions.visibilityOf(EnterTheOTP_1)).sendKeys(otp);
}
public void otp2(String otp)
{
	wait.until(ExpectedConditions.visibilityOf(EnterTheOTP_2)).sendKeys(otp);
}
public void otp3(String otp)
{
	wait.until(ExpectedConditions.visibilityOf(EnterTheOTP_3)).sendKeys(otp);
}
public void otp4(String otp)
{
	wait.until(ExpectedConditions.visibilityOf(EnterTheOTP_4)).sendKeys(otp);
}
public void submit()
{
	wait.until(ExpectedConditions.visibilityOf(submit)).click();
}
public void name(String entername)
{
	wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(entername);
}
public void email(String email)
{
	wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(email);
}
public void save()
{
	wait.until(ExpectedConditions.visibilityOf(Save)).click();
}
public void skip()
{
	wait.until(ExpectedConditions.visibilityOf(Skip)).click();
}
public void verifyLogin() {
    String conf = wait.until(ExpectedConditions.visibilityOf(verify)).getText();
    Assert.assertTrue(conf.contains("Hi"), "Login failed: Greeting not found!");
}
public void verifyLoginwithname() {
    String conf = wait.until(ExpectedConditions.visibilityOf(verify)).getText();
    Assert.assertTrue(conf.contains("Hi, Demo"), "Login failed: Greeting not found!");
}
public String emptynumvalidation() {
    return wait.until(ExpectedConditions.visibilityOf(numvalidation)).getText();
}
/*public void wrongnumvalidation() {
    String conf = wait.until(ExpectedConditions.visibilityOf(numvalidation)).getText();
    Assert.assertTrue(conf.contains("Mobile number does not match the selected country"));
}*/
public String otpvalidation() {
    return wait.until(ExpectedConditions.visibilityOf(otpvalidation)).getText();
}
}
