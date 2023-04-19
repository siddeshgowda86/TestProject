package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdventurePage {
	
	WebDriver driver;
	
	String url="https://qtripdynamic-qa-frontend.vercel.app/pages/adventures";
	
	@FindBy (xpath=("//select[@id='duration-select']"))
	WebElement SelectFilters;
	
	@FindBy (xpath=("//select[@id='category-select']"))
	WebElement Category;
	
	@FindBy (xpath=("//div[@onclick='clearDuration(event)']"))
	WebElement clearfilter;
	@FindBy (xpath=("//div[@onclick='clearCategory(event)']"))
	WebElement clearcategory;
	
	@FindBy (xpath="//input[@id='search-adventures']")
	WebElement search;
	
	@FindBy (xpath="//img[@class='img-responsive']")
	WebElement selectAdvnt;

	
	
	
	
	public AdventurePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
		
		
	}
	
	public void setFilterValue(String filters) {
		
		Select dropdown = new Select(SelectFilters);
		dropdown.selectByVisibleText(filters); 
		
		
}
	
	
	
	public void setCategoryValue(String category)
	{
		Select dropdown1 = new Select(Category);
		dropdown1.selectByVisibleText(category); 
		
	}
	
	public void getResultCountExpected(String Expected)
	{
		int count=0;
		//int result=0;
		List<WebElement> listImages=driver.findElements(By.tagName("img"));
       count=listImages.size();
       System.out.println("Expected Result Count:"+count);
      // if(Expected==count)
       //{
    	  // System.out.println("Expected Result Count"+count);
       //}
		//return count;
	}
	
	public void clearall()
	{
		clearfilter.click();
		clearcategory.click();
	}
	public void getResultCountunExpected(String unexpected)
	{
		int count1=0;
		
		List<WebElement> listImages=driver.findElements(By.xpath("//img[@class='img-responsive']"));
       count1=listImages.size();
       System.out.println("UnFiltered Result Count:"+count1);
       //if(unexpected==count1)
    	   //System.out.println("UnFiltered Result Count"+count1);
	} 
	
	
	public void  selectAdventure(String Adventure) throws InterruptedException{
           //search.clear();
	      search.sendKeys(Adventure);
	      Thread.sleep(3000);
	      selectAdvnt.click();
}
}








