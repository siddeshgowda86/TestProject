package Pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class DataProvider {
	
	    WebDriver driver;
	    WebDriverWait wait;
	    HSSFWorkbook workbook;
	    HSSFSheet sheet;
	    HSSFCell cell;
	 
	 @BeforeTest
	 public void TestSetup() throws InterruptedException
	{
	    // Set the path of the Firefox driver.
	    System.setProperty("webdriver.chrome.driver","C://Drivers//chromeDriver//chromedriver.exe");
	    driver = new ChromeDriver();
	     
	    // Enter url.
	    driver.get("https://crio-qkart-frontend-qa.vercel.app/login/");
	    driver.manage().window().maximize();
	     Thread.sleep(3000);
	    //wait = new WebDriverWait(driver,30);
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	 
	 
	 
	 

}
