package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest5 {
	
	
	@Test()
	public void TestLogin() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromeDriver//chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/login/");
		Thread.sleep(3000);
		driver.findElement(By.id("floatingInput")).sendKeys("TestUser@gmail.com");
		driver.findElement(By.id("floatingPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		
		//Thread.sleep(5000);
		driver.quit();
	}
	

}
