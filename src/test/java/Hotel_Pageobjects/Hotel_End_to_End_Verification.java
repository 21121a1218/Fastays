package Hotel_Pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hotel_End_to_End_Verification extends BaseClass{
   WebDriver driver;
   WebDriverWait wait;
   private double finalprice=0.00;
	public Hotel_End_to_End_Verification(WebDriver driver) {
		super(driver);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	@FindBy(xpath = "//span[@class='bg-secondary px-2 py-0.5 rounded-md text-white text-md font-semibold shadow-sm']")
	List<WebElement> reviess;
	@FindBy(xpath = "//h2[@class='text-lg font-semibold text-gray-900 cursor-pointer']")
	List<WebElement> hotelname;
	@FindBy(xpath = "//p[@class='text-[10px] text-gray-500 max-w-md break-words py-0.5 mt-1']")
	List<WebElement> hoteladrress;
	@FindBy(xpath = "//div[@class='ml-auto flex items-center gap-2']")
	List<WebElement> hotelrating;
	@FindBy(xpath = "//h2[@class='text-lg font-bold']")
	WebElement hoteldeatils;
	@FindBy(xpath = "//span[@class='text-blue-500 hover:underline cursor-pointer']")
	WebElement viewonmap;
	@FindBy(xpath = "//p[normalize-space()='ABOUT']")
	WebElement aboutroom;
	@FindBy(xpath = "//p[normalize-space()='AMENITIES']")
	WebElement amenties;
	@FindBy(xpath = "//p[normalize-space()='LOCATION']")
	WebElement location;
	@FindBy(xpath = "//p[normalize-space()='NEARBY ATTRACTIONS']")
	WebElement attraction;
	@FindBy(xpath = "//p[normalize-space()='GUEST REVIEWS']")
	WebElement reviews;
	@FindBy(xpath = "//p[normalize-space()='ROOMS']")
	WebElement rooms;
	@FindBy(xpath = "//button[contains(normalize-space(),'Select Room')]")
	List <WebElement> selectrooms;
	@FindBy(xpath = "//div[@class='bg-white my-4 p-4 rounded-lg shadow-md']")
	WebElement aboutinfo;
	@FindBy(xpath = "//div[@class='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8']")
	WebElement amentiesinfo;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/div[2]/div/div/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div[2]")
	WebElement googlemap;
	@FindBy(xpath = "//div[contains(@class,'bg-white my-4 p-4 rounded-lg shadow-md')]")
	WebElement attractionsinfo;
	@FindBy(xpath = "//h2[@class='text-xl font-bold text-foreground bg-secondary px-2 py-1 rounded-md text-white']")
	WebElement reviewinfo;
	@FindBy(xpath = "//div[contains(@class,'grid grid-cols-1 md:grid-cols-3 gap-4')]//div//div[1]//h3")
	List <WebElement> roomdata; 
	@FindBy(xpath = "//p[@class='text-lg font-bold text-gray-800']")
	List <WebElement> roomprice;
	@FindBy(xpath = "//h2[@class='text-xl font-semibold']")
	WebElement propertyhotelname;
	@FindBy(xpath = "//p[@class='text-xs text-muted-foreground']")
	WebElement propertyhoteladdress;
	@FindBy(xpath = "//button[normalize-space()='View Hotel Policy']")
	WebElement viewhotelpolicy;
	@FindBy(xpath = "//div[contains(@class,'bg-white rounded-lg shadow-lg w-full max-w-xl p-6 relative')]")
	WebElement policydetails;
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement closepoicy;
	@FindBy(xpath = "(//p[@class='text-black font-semibold text-sm'])[1]")
	WebElement checkindate;
	@FindBy(xpath = "(//p[@class='text-black font-semibold text-sm'])[2]")
	WebElement checkoutdate;
	@FindBy(xpath = "(//p[@class='text-black font-semibold text-sm'])[3]")
	WebElement iternydeatils;
	@FindBy(xpath = "//div[contains(@class,'flex justify-between items-start flex-wrap gap-y-2')]")
	WebElement roominfoverify;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]/span[1]")
	WebElement basepriceverify;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/main[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/span[2]/span[1]")
	WebElement gstpriceverify;
	@FindBy(xpath = "//div[contains(@class,'flex justify-between font-semibold')]//span[2]")
	WebElement totalprice;
	@FindBy(xpath = "//button[normalize-space()='View Hotel Offers']")
	WebElement viewoffers;
	@FindBy(xpath = "//p[@class='text-sm font-medium']")
	List <WebElement> offers;
	@FindBy(xpath = "//div[@class='flex items-start p-2 rounded-2xl md:border-dotted border-2 transition-all hover:bg-green-100 text-gray-700 border-gray-200']")
	WebElement selectOffer;
	@FindBy(xpath = "//button[normalize-space()='Hide Hotel Offers']")
	WebElement hideoffers;
	@FindBy(xpath = "//input[@name='termsConditions']")
	WebElement termsandconditions;
	@FindBy(xpath = "//a[normalize-space()='Terms And Conditions']")
	WebElement termslink;
	@FindBy(xpath = "	//button[normalize-space()='Clear']")
	WebElement clearoffers;
	@FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
	WebElement polocylink;
	@FindBy(xpath = "//span[@class='text-[10px] px-2 py-0.5 rounded-full font-medium bg-red-100 text-red-800 ring-1 ring-red-100']")
	List <WebElement> refundableinfos;
	@FindBy(xpath = "//span[@class=' bg-red-100 text-red-800 ring-1 ring-red-200inline-flex items-center gap-1 text-[10px] px-2 py-1 rounded-full font-medium ']")
	WebElement verifyrefundableinfo;
	@FindBy(xpath = "//button[normalize-space()='+ Add Children']")
	WebElement addchild;
	public String hotelname(int i)
	{
		  wait.until(ExpectedConditions.visibilityOfAllElements(hotelname));
		  String name=hotelname.get(i).getText();
		  return name;
		        
	}
	public String hoteladrress(int i)
	{
		  wait.until(ExpectedConditions.visibilityOfAllElements(hoteladrress));
		  String name=hoteladrress.get(i).getText();
		  return name;
		        
	}
	public String hotelrating(int i)
	{
		  wait.until(ExpectedConditions.visibilityOfAllElements(hotelrating));
		  String name=hotelrating.get(i).getText();
		  return name;	        
	}
	public String hoteldeatils()
	{
		  wait.until(ExpectedConditions.visibilityOfAllElements(hoteldeatils));
		  String name=hoteldeatils.getText();
		  return name;	        
	}
	public String reviess(int i)
	{
		  wait.until(ExpectedConditions.visibilityOfAllElements(reviess));
		  String name=reviess.get(i).getText();
		  return name;	        
	}
	
	public boolean clicKmap() {
		 wait.until(ExpectedConditions.elementToBeClickable(viewonmap)).click();
		 boolean result=wait.until(ExpectedConditions.visibilityOf(googlemap)).isDisplayed();
		 return result;
	}
	public boolean aboutroom() {
		 wait.until(ExpectedConditions.elementToBeClickable(aboutroom)).click();
		 boolean result=wait.until(ExpectedConditions.visibilityOf(aboutinfo)).isDisplayed();
		 return result;
	}
	public boolean amenties() {
		 wait.until(ExpectedConditions.elementToBeClickable(amenties)).click();
		 boolean result=wait.until(ExpectedConditions.visibilityOf(amentiesinfo)).isDisplayed();
		 return result;
	}
	public boolean location() {
		 wait.until(ExpectedConditions.elementToBeClickable(location)).click();
		 boolean result=wait.until(ExpectedConditions.visibilityOf(googlemap)).isDisplayed();
		 return result;
	}
	public boolean attraction() {
		 wait.until(ExpectedConditions.elementToBeClickable(attraction)).click();
		 boolean result=wait.until(ExpectedConditions.visibilityOf(attractionsinfo)).isDisplayed();
		 return result;
	}
	public String reviews() {
		 wait.until(ExpectedConditions.elementToBeClickable(reviews)).click();
		 String rating=wait.until(ExpectedConditions.visibilityOf(reviewinfo)).getText();
		 return rating;
	}
	public void clickrooms()
	{
		 wait.until(ExpectedConditions.visibilityOf(rooms)).click();
	}
	public void selectrooms(int i){
		
		 wait.until(ExpectedConditions.visibilityOfAllElements(selectrooms));
		 selectrooms.get(i).click();
	}
	public String roomdata(int i) {
		 String rating=wait.until(ExpectedConditions.visibilityOfAllElements(roomdata)).get(i).getText();
		 return rating;
	}
	public String refundableinfos(int i) {
		 String rating=wait.until(ExpectedConditions.visibilityOfAllElements(refundableinfos)).get(i).getText();
		 return rating;
	}
	
	public String roomprice(int i) {
		 String rating=wait.until(ExpectedConditions.visibilityOfAllElements(roomprice)).get(i).getText();
		 return rating;
	}
	public String propertyhotelname() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(propertyhotelname)).getText();
		 return rating;
	}
	public String propertyhoteladdress() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(propertyhoteladdress)).getText();
		 return rating;
	}
	public boolean viewhotelpolicy(){
		 wait.until(ExpectedConditions.visibilityOf(viewhotelpolicy)).click();
		boolean policyviewed = wait.until(ExpectedConditions.visibilityOf(policydetails)).isDisplayed();
		 wait.until(ExpectedConditions.visibilityOf(closepoicy)).click();
		return policyviewed;
	}
	public String checkindate() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(checkindate)).getText();
		 return rating.replaceAll("[^0-9]", "");
	}
	public String checkoutdate() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(checkoutdate)).getText();
		 return rating.replaceAll("[^0-9]", "");
	}
	public String iternydeatils() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(iternydeatils)).getText();
		 return rating;
	}
	public String roominfoverify() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(roominfoverify)).getText();
		 return rating;
	}
	public String verifyrefundableinfo() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(verifyrefundableinfo)).getText();
		 return rating;
	}
	
	public String basepriceverify() {
		 String rating=wait.until(ExpectedConditions.visibilityOf(basepriceverify)).getText();
		 return rating;
	}

	public boolean gstPriceVerify() {
	    String baseText = wait.until(ExpectedConditions.visibilityOf(basepriceverify))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    String gstText = wait.until(ExpectedConditions.visibilityOf(gstpriceverify))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    double base = Double.parseDouble(baseText);
	    double displayedGst = Double.parseDouble(gstText);
	    double othercharges = (
	            (base * 1 / 100) +
	            (base * 3 / 100) +
	            12
	    );
	    double onlyGst = othercharges * 18 / 100;
	    double calculatedGst=onlyGst +othercharges;
	    calculatedGst = Math.ceil(calculatedGst);
	    System.out.println(base);
	    System.out.println(displayedGst);
	    System.out.println(calculatedGst);
	    return Math.abs(displayedGst - calculatedGst) < 0.01;
	}
	public boolean verifytotalprice() {
	    String baseText = wait.until(ExpectedConditions.visibilityOf(basepriceverify))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    String gstText = wait.until(ExpectedConditions.visibilityOf(gstpriceverify))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    String totalPrice = wait.until(ExpectedConditions.visibilityOf(totalprice))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    double base = Double.parseDouble(baseText);
	    double Gst = Double.parseDouble(gstText);
	    double total = Double.parseDouble(totalPrice);
	    finalprice = base+Gst;
	      return Math.abs(total - finalprice) < 0.01;
	}
	public boolean applyOffer(int i) throws InterruptedException {
	    wait.until(ExpectedConditions.visibilityOf(viewoffers)).click();
	    String baseText = wait.until(ExpectedConditions.visibilityOf(basepriceverify))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	   String gstText = wait.until(ExpectedConditions.visibilityOf(gstpriceverify))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    double base = Double.parseDouble(baseText);
	    double Gst = Double.parseDouble(gstText);
	    WebElement offerElement = wait.until(ExpectedConditions.visibilityOfAllElements(offers)).get(i);
	    String offerText = offerElement.getText();  
	    System.out.println(offerText);
	    offerElement.click();
	    double expectedTotal = 0;
	    if (offerText.contains("₹")) {
	        String discountValue = offerText.replaceAll("[^0-9.]", "");
	        double discount = Double.parseDouble(discountValue);
	        expectedTotal = (base - discount)+Gst;
	        
	    }
	    else if (offerText.contains("%")) {
	        String discountValue = offerText.replaceAll("[^0-9.]", "");
	        double discount = Double.parseDouble(discountValue);
	        expectedTotal = (base - (base * discount / 100))+Gst;
	        
	    }
	    Thread.sleep(2000);
	    String totalafterdiscount = wait.until(ExpectedConditions.visibilityOf(totalprice))
	            .getText()
	            .replaceAll("[^0-9.]", "");
	    double displayedTotal = Double.parseDouble(totalafterdiscount);
	    System.out.println(displayedTotal);
	    expectedTotal = Math.floor(expectedTotal);
	    System.out.println(expectedTotal);
	    return Math.abs(displayedTotal - expectedTotal) < 0.01;
	}
    public boolean terms()
    {
    	return wait.until(ExpectedConditions.elementToBeClickable(termsandconditions)).isSelected();  	 
    }
    public void term()
    {
    	wait.until(ExpectedConditions.visibilityOf(termslink)).click();
    }
    public void policy()
    {
    	wait.until(ExpectedConditions.visibilityOf(polocylink)).click();
    }
    public boolean clearOffers() throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOf(clearoffers)).click();
    	Thread.sleep(2000);
    	 String totalPrice = wait.until(ExpectedConditions.visibilityOf(totalprice))
 	            .getText()
 	            .replaceAll("[^0-9.]", "");
    	 double total = Double.parseDouble(totalPrice);
    	 if(finalprice-total>0.01)
    	 {
    		 return false;
    	 }
    	 return true;
    }
    public void addChild()
    {
    	wait.until(ExpectedConditions.visibilityOf(addchild)).click();
    }
}
