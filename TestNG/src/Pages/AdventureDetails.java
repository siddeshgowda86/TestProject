package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AdventureDetails {
	
	
	
	WebDriver driver;
	@FindBy (className="form-control")
	WebElement Name;
	@FindBy (xpath="//input[@type='number']")
	WebElement Person;
	@FindBy (className="reserve-button")
	WebElement Reserve;
	@FindBy (xpath="//input[@name='date']")
	WebElement Date;
	@FindBy (xpath="//div[@id='reserved-banner']")
	WebElement Alert;
	
	public AdventureDetails(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}
	
	
	public void bookAdventure(String Username,String date, String no)
	{
	 Name.sendKeys(Username);
	 Date.click();
	 Date.sendKeys(date);
	 Person.clear();
	 Person.sendKeys(no);
	 Reserve.click();


}
	public  Boolean isbookingsuccessful()
	{
		boolean status=true;
	if(Alert.getText().equals("Greetings! Reservation for this adventure is successful. (Click here to view your reservations)"));
	System.out.println("Booking was Sucssesful with Transaction Id");
		return status;
	}
}