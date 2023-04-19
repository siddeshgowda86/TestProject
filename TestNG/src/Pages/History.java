package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class History {
	
WebDriver driver;
	
	String Transact="";
	@FindBy (xpath="//a[normalize-space()='Reservations']")
	WebElement Reservations;
	@FindBy (xpath="//tbody/tr[1]/th[1]")
	WebElement TransactionId;
	
	@FindBy (xpath="//button[@class='cancel-button']")
	WebElement Cancel;
	
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td[2]")
	WebElement adv1;
	@FindBy (xpath="//table[@class='table']/tbody/tr[2]/td[2]")
	WebElement adv2;
	@FindBy (xpath="//table[@class='table']/tbody/tr[3]/td[2]")
	WebElement adv3;
	
	public History(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}
	
	public void getReservation()
	{
		
		Reservations.click();
		String Transaction=TransactionId.getText();
		
		System.out.println(Transaction);
		
	}
	
	public void cancelReservation()
	{
		
		Cancel.click();
		System.out.println("Registration is cancelled with:" +TransactionId.getText());
	}

	
	public void  ReservationHistory() throws InterruptedException
	
	{
		//Boolean status=true;
		Reservations.click();
		//Thread.sleep(3000);
		//return true;
		//return false;
		
	}
	
	public Boolean verifybooking(String adventure1)
	{  
		
		boolean status=true;
		try {
			if(adv1.getText().equals(adventure1)||adv2.getText().equals(adventure1)||adv3.getText().equals(adventure1))
			{
				
				System.out.println("verified");
				return status;
			}
			else {
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	        	
	}
	
}
