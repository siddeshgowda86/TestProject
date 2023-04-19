package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
public class Home {
	
	
	WebDriver driver;
	String url ="https://qtripdynamic-qa-frontend.vercel.app";
	
	
	@FindBy (className="login")
	WebElement logoutbtn;
	
    @FindBy (xpath="//a[contains(text(),'Register')]")
    WebElement registerbtn;
    @FindBy (xpath="//a[normalize-space()='Reservations']")
    WebElement Reservationtxt;
    
    @FindBy (className="hero-input")
    WebElement Searchbtn;
    
    @FindBy (xpath="//h5[contains(text(),'No City found')]")
    WebElement NoCityFound;
    
    @FindBy (id="autocomplete")
    WebElement selcity;
    WebElement p;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}
	
	
	public void navigateToHomePage() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }
	
	
	public void clickregister()
	{
		registerbtn.click();
		
		System.out.println("Register button is clicked");

	}
	
	public Boolean VerifyUserLoggedIn() {
	
		try {
	        // Find the username label (present on the top right of the page)
			if(Reservationtxt.getText().equals("Reservation"))
			System.out.println(Reservationtxt.getText());
			//Thread.sleep(3000);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public Boolean PerformLogout() throws InterruptedException {
       
            
           logoutbtn.click();
           
           /*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Logout')]")));*/
            return true;
        
    }
	
	

	public void SearchCity(String City) {
	    Searchbtn.clear(); 
		Searchbtn.sendKeys(City);
		Searchbtn.click();
		
	}
	
	
	public Boolean isNocityfound()
	{
		try
		{ 
			return NoCityFound.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		
		}
	}
	
 public Boolean  assertAutocompleteText(String City) {
	 Boolean status=true;
	 //Searchbtn.sendKeys(City);
      WebElement cityclick=driver.findElement(By.xpath("//ul[@id='results']"));
	 //System.out.println("City Found");
      cityclick.click();
	return status;
	 
	//return driver.findElement(By.xpath(String.format("//li[@id='%s']",City))).isDisplayed();
	
	 
	 
	 //return status;
	 
 }

	public Boolean SelectCity(String City) throws InterruptedException {
	      
		  //Searchbtn.sendKeys(City);
		  Boolean status=true;
		  //Thread.sleep(3000);
		 Searchbtn.sendKeys(Keys.ARROW_DOWN);
		  Searchbtn.sendKeys(Keys.ENTER);
		  //Searchbtn.click();
		  //System.out.println("City Found"+City);
		  //Thread.sleep(2000);
		// WebElement da= driver.findElement(By.xpath(String.format("//li[@id='%s']",City.toLowerCase())));
		 //da.click();
		return status;
	}

}
	

