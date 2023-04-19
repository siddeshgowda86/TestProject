package Pages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.ExcelDataSupllier;

public class TestBase {
	static WebDriver driver;
	public static String lastGeneratedUserName;
	String driverPath = "C://Drivers//chromeDriver//chromedriver.exe";
	private String dataset;
	// String url = "https://qtripdynamic-qa-frontend.vercel.app";

	@BeforeSuite(alwaysRun = true)
	public void createDriver() throws MalformedURLException {

		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		System.setProperty("log4j.configurationFile", "./path_to_the_log4j2_config_file/log4j2.xml");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get(url);
	}

	public void registerNewuser(String NewUserName, String Password) throws InterruptedException {
		// SoftAssert sa =new SoftAssert();
		Register1 register = new Register1(driver);
		register.navigateToRegisterPage();
		register.clickregister();
		Thread.sleep(2000);
		register.registerUser(NewUserName, Password, true);

		// sa.assertEquals(register.registerUser("TestUser@gmail.com","abc@123","abc@123",true),"Failed
		// to Create new user");
		lastGeneratedUserName = register.lastGeneratedUsername;
	}

	// @Test(priority=3, description="Verify User logedin",dataProvider =
	// "loginData", dataProviderClass = ExcelDataSupllier.class)
	public void TestCase(String Password) throws InterruptedException {
		// registerNewuser();

		String lastgeneratedUserName = lastGeneratedUserName;
		Login1 login = new Login1(driver);
		login.navigateToLoginPage();
		login.PerformLogin(lastGeneratedUserName, Password);
		// login.PerformLogin("siddeshgowda86@gmail.com", "Admin@123");
		Thread.sleep(5000);
		// Boolean status = login.PerformLogin(lastGeneratedUserName, "abc@123");
		// Assert.assertTrue(status);

	}

	/*
	 * @Test( priority=1,description ="Verify HomePage",dataProvider="loginData")
	 * public void Homelog(String UserName1,String Password) throws
	 * InterruptedException{ Home home=new Home(driver); home.navigateToHomePage();
	 * Thread.sleep(4000); //home.clickregister(); Register1 register=new
	 * Register1(driver);
	 * 
	 * register.navigateToRegisterPage(); home.clickregister(); Thread.sleep(2000);
	 * register.registerUser(UserName1,Password,true); lastGeneratedUserName =
	 * register.lastGeneratedUsername; String lastgeneratedUserName =
	 * lastGeneratedUserName; Login1 login = new Login1(driver);
	 * login.navigateToLoginPage();
	 * login.PerformLogin(lastGeneratedUserName,Password); Thread.sleep(3000);
	 * Boolean status1=home.VerifyUserLoggedIn(); Assert.assertTrue(status1);
	 * Thread.sleep(5000); Boolean status = home.PerformLogout();
	 * 
	 * Assert.assertTrue((status)); }
	 * 
	 * @DataProvider public Object[][] loginData() throws Exception{ Object[][]
	 * test=ExcelDataSupllier.getData(
	 * "C://Users//USER//eclipse-workspace//TestNG//DataSheet//TestData.xlsx",
	 * "TestCase01"); return(test);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * /* @Test(priority=2,dataProvider="SearchFilter") public void
	 * Testcase02(String CityName,String Category_Filter,String
	 * DurationFilter,String ExpectedFilteredResults,String
	 * ExpectedUnFilteredResults) throws InterruptedException{
	 * 
	 * Home home=new Home(driver); home.navigateToHomePage(); Thread.sleep(4000);
	 * //home.SearchCity("Mumbai"); //Thread.sleep(3000); //Boolean
	 * status5=home.isNocityfound(); //Assert.assertTrue(status5);
	 * //home.navigateToHomePage(); //Thread.sleep(4000); home.SearchCity(CityName);
	 * home.SelectCity(CityName); Thread.sleep(3000); Boolean
	 * status=home.assertAutocompleteText(CityName); Assert.assertTrue(status);
	 * AdventurePage adp=new AdventurePage(driver);
	 * adp.setCategoryValue(Category_Filter); Thread.sleep(2000);
	 * adp.setFilterValue(DurationFilter); Thread.sleep(2000);
	 * 
	 * adp.getResultCountExpected(ExpectedFilteredResults); Thread.sleep(2000);
	 * adp.clearall(); Thread.sleep(3000);
	 * adp.getResultCountunExpected(ExpectedUnFilteredResults); }
	 * 
	 * @DataProvider public Object[][] SearchFilter() throws Exception{ Object[][]
	 * test=ExcelDataSupllier.getData(
	 * "C://Users//USER//eclipse-workspace//TestNG//DataSheet//TestData.xlsx",
	 * "Sheet2"); return(test);
	 * 
	 * }
	 * 
	 * @Test(priority=3,dataProvider = "BookingCancel") public void Testcase3(String
	 * NewUserName,String Password,String SearchCity,String AdventureName,String
	 * GuestName,String Date,String count) throws InterruptedException{ //String
	 * lastgeneratedUserName = lastGeneratedUserName;
	 * 
	 * //String Citycity="Bengaluru"; Home home=new Home(driver);
	 * home.navigateToHomePage(); Thread.sleep(4000); Register1 register=new
	 * Register1(driver);
	 * 
	 * register.navigateToRegisterPage(); home.clickregister(); Thread.sleep(2000);
	 * register.registerUser(NewUserName,Password,true); lastGeneratedUserName =
	 * register.lastGeneratedUsername; // String lastgeneratedUserName =
	 * lastGeneratedUserName; Login1 login = new Login1(driver);
	 * login.navigateToLoginPage();
	 * login.PerformLogin(lastGeneratedUserName,Password); Thread.sleep(3000);
	 * //registerNewuser(); //TestCase(Password); //Thread.sleep(3000);
	 * home.SearchCity(SearchCity); home.SelectCity(SearchCity); Thread.sleep(3000);
	 * Boolean status=home.assertAutocompleteText(SearchCity);
	 * Assert.assertTrue(status); //Thread.sleep(3000); AdventurePage adp=new
	 * AdventurePage(driver); adp.selectAdventure(AdventureName);
	 * Thread.sleep(5000); AdventureDetails Ad=new AdventureDetails(driver);
	 * Ad.bookAdventure(GuestName,Date,count); Thread.sleep(3000); Boolean status1=
	 * Ad.isbookingsuccessful(); Assert.assertTrue(status1); History hist=new
	 * History(driver); hist.getReservation(); hist.cancelReservation();
	 * Thread.sleep(5000);
	 * 
	 * Boolean statusl = home.PerformLogout();
	 * 
	 * Assert.assertTrue((statusl)); }
	 * 
	 * @DataProvider public Object[][] BookingCancel() throws Exception{ Object[][]
	 * test=ExcelDataSupllier.getData(
	 * "C://Users//USER//eclipse-workspace//TestNG//DataSheet//TestData.xlsx",
	 * "Sheet3"); return(test);
	 * 
	 * }
	 */

	/*
	 * @Test(priority=1,dataProvider="Booking")
	 * 
	 * @DataProvider(name="testdata") public void Testcase4(String
	 * NewUserName,String Password,String dataset1 ,String dataset2,String
	 * name,String date,String cnt) throws InterruptedException{ String
	 * lastgeneratedUserName = lastGeneratedUserName; Home home=new Home(driver);
	 * home.navigateToHomePage(); Thread.sleep(4000); //registerNewuser();
	 * //TestCase(); //Thread.sleep(3000); Register1 register=new Register1(driver);
	 * 
	 * register.navigateToRegisterPage(); home.clickregister(); Thread.sleep(2000);
	 * register.registerUser(NewUserName,Password,true); lastGeneratedUserName =
	 * register.lastGeneratedUsername; // String lastgeneratedUserName =
	 * lastGeneratedUserName; Login1 login = new Login1(driver);
	 * login.navigateToLoginPage();
	 * login.PerformLogin(lastGeneratedUserName,Password); Thread.sleep(3000);
	 * home.SearchCity(CityName); home.SelectCity(CityName); Thread.sleep(3000);
	 * //Boolean status5=home.isNocityfound(); //Assert.assertTrue(status5);
	 * //home.navigateToHomePage(); //Thread.sleep(4000);
	 * //home.SearchCity("Bengaluru"); //home.SelectCity("Bengaluru");
	 * //Thread.sleep(3000); Boolean status= home.assertAutocompleteText(CityName);
	 * Assert.assertTrue(status); Thread.sleep(3000); AdventurePage adp=new
	 * AdventurePage(driver); Thread.sleep(4000); adp.selectAdventure(Adventure);
	 * Thread.sleep(5000); AdventureDetails Ad=new AdventureDetails(driver);
	 * Ad.bookAdventure(name,date,cnt); Thread.sleep(3000); Boolean status1=
	 * Ad.isbookingsuccessful(); Assert.assertTrue(status1);
	 * home.navigateToHomePage(); Thread.sleep(3000); home.SearchCity(CityName);
	 * home.SelectCity(CityName); Thread.sleep(3000); Boolean status2=
	 * home.assertAutocompleteText(CityName); Assert.assertTrue(status2);
	 * Thread.sleep(3000); AdventurePage adp1=new AdventurePage(driver);
	 * adp1.selectAdventure(Adventure); Thread.sleep(5000); AdventureDetails Ad1=new
	 * AdventureDetails(driver); Ad1.bookAdventure(name,date,cnt);
	 * Thread.sleep(3000); Boolean status3= Ad1.isbookingsuccessful();
	 * Assert.assertTrue(status3); Thread.sleep(3000); home.navigateToHomePage();
	 * Thread.sleep(3000); home.SearchCity(CityName); home.SelectCity(CityName);
	 * Thread.sleep(3000); Boolean status12= home.assertAutocompleteText(CityName);
	 * Assert.assertTrue(status12); Thread.sleep(3000); AdventurePage adp2=new
	 * AdventurePage(driver); adp2.selectAdventure(Adventure); Thread.sleep(5000);
	 * AdventureDetails Ad2=new AdventureDetails(driver);
	 * Ad2.bookAdventure(name,date,cnt); Thread.sleep(3000); Boolean status4=
	 * Ad2.isbookingsuccessful(); Assert.assertTrue(status4); History hist=new
	 * History(driver); hist.ReservationHistory(); Thread.sleep(3000); //
	 * Assert.assertTrue(status5); Boolean statusl = home.PerformLogout();
	 * 
	 * Assert.assertTrue((statusl));
	 * 
	 * }
	 */

	/*
	 * public void login_for_Testcase04(String NewUserName,String Password) throws
	 * InterruptedException { Home home=new Home(driver); home.navigateToHomePage();
	 * Thread.sleep(4000); //home.clickregister(); Register1 register=new
	 * Register1(driver);
	 * 
	 * register.navigateToRegisterPage(); home.clickregister(); Thread.sleep(2000);
	 * register.registerUser(NewUserName,Password,true); lastGeneratedUserName =
	 * register.lastGeneratedUsername; String lastgeneratedUserName =
	 * lastGeneratedUserName; Login1 login = new Login1(driver);
	 * login.navigateToLoginPage();
	 * login.PerformLogin(lastGeneratedUserName,Password); Thread.sleep(3000); }
	 * 
	 * @Test(priority=4,dataProvider="Booking") public void Testcase05(String
	 * NewUserName,String Password,String dataset1 ,String dataset2,String dataset3)
	 * throws InterruptedException { login_for_Testcase04(NewUserName,Password);
	 * make_repeat_bookings(dataset1);
	 * 
	 * preparebooking();
	 * 
	 * make_repeat_bookings(dataset2); preparebooking();
	 * make_repeat_bookings(dataset3); showbookdetails(); //Thread.sleep(3000);
	 * Assert.assertTrue(driver.findElement(By.xpath("//div[@id='reserved-banner']")
	 * ).isDisplayed(), "Booking not successful."); /* WebElement
	 * adv1=driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]"));
	 * if(adv1.getText().equals(dataset1)) { System.out.println(adv1.getText()); }
	 */
	// verifyBooking(dataset4);
	// Thread.sleep(2000);

	// logout();
	// }*/

	/*
	 * public void preparebooking() throws InterruptedException{ Home home=new
	 * Home(driver); home.navigateToHomePage(); Thread.sleep(4000); }
	 * 
	 * public void showbookdetails() throws InterruptedException{ History hist=new
	 * History(driver); hist.ReservationHistory(); Thread.sleep(3000); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void logout() throws InterruptedException { Home home=new
	 * Home(driver); Boolean statusl = home.PerformLogout();
	 * Assert.assertTrue((statusl));
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void make_repeat_bookings(String dataset) throws InterruptedException
	 * { // TODO Auto-generated method stub
	 * 
	 * String [] brkdataset= dataset.split(";"); String searchcity=brkdataset[0];
	 * String adventure =brkdataset[1]; String guest=brkdataset[2]; String
	 * date=brkdataset[3]; String count=brkdataset[4]; Home home=new Home(driver);
	 * home.SearchCity(searchcity); home.SelectCity(searchcity); Thread.sleep(3000);
	 * Boolean status= home.assertAutocompleteText(searchcity);
	 * Assert.assertTrue(status); Thread.sleep(3000); AdventurePage adp=new
	 * AdventurePage(driver); Thread.sleep(4000); adp.selectAdventure(adventure);
	 * Thread.sleep(5000); AdventureDetails Ad=new AdventureDetails(driver);
	 * Ad.bookAdventure(guest,date,count); Thread.sleep(3000); Boolean status1=
	 * Ad.isbookingsuccessful(); Assert.assertTrue(status1);
	 * 
	 * /* if(adventure.equals("Niaboytown")) {
	 * Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Niaboytown']"))
	 * ,"Not Selected"); } else {
	 * Assert.assertTrue(driver.findElement(By.xpath("//td[text()="+adventure+"]")).
	 * isDisplayed(),"Not Selected"); }
	 */
	// History hist=new History(driver);
	// hist.ReservationHistory();
	// Thread.sleep(2000);

	// }*/

	@Test(priority = 4, dataProvider = "Booking")
	public void TestCase04(String NewUserName, String Password, String dataSet1, String dataSet2, String dataSet3)
			throws InterruptedException {
		Home home = new Home(driver);
		home.navigateToHomePage();
		Thread.sleep(2000);
		Register1 register = new Register1(driver);
		register.navigateToRegisterPage();
		home.clickregister();
		Thread.sleep(2000);
		register.registerUser(NewUserName, Password, true);
		lastGeneratedUserName = register.lastGeneratedUsername;
		String lastgeneratedUserName = lastGeneratedUserName;
		Login1 login = new Login1(driver);
		login.navigateToLoginPage();
		login.PerformLogin(lastGeneratedUserName, Password);
		Thread.sleep(3000);
		//String[] set1 = dataSet1.split(";");
		//String[] set2 = dataSet2.split(";");
		//String[] set3 = dataSet3.split(";");
		//String[][] dataSetArray1 = { set1, set2, set3 };
	     String[] dataSetArray = { dataSet1, dataSet2, dataSet3 };
		ArrayList<String> adventuresList = new ArrayList<>();
		for (int j = 0; j < dataSetArray.length; j++) {
			// System.out.println(dataSetArray[j]);
			String[] arr = dataSetArray[j].split(";");
			String cityName = arr[0];
			String adventureToBeSelected = arr[1];
			String nameOfPerson = arr[2];
			String dateOfAdventure = arr[3];
			String numberOfPerson = arr[4];
			if (j > 0) {
				home.navigateToHomePage();
				Thread.sleep(4000);
			}
			
			home.SearchCity(cityName);
			home.SelectCity(cityName);
			Boolean statusc = home.SelectCity(cityName);
			Assert.assertTrue(statusc);
			Thread.sleep(3000);
			Boolean status = home.assertAutocompleteText(cityName);
			Assert.assertTrue(status);
			Thread.sleep(3000);
			String name = nameOfPerson;
			adventuresList.add(bookingAdventures(name, dateOfAdventure, adventureToBeSelected, numberOfPerson));
		}
		History hist = new History(driver);
		hist.ReservationHistory();
		Thread.sleep(5000);
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr"));
		Thread.sleep(3000);
		int count = rows.size();
		System.out.println(count);
		int i = 1;
		/*for (String[] data : dataSetArray1) {
			
				WebElement bookingName = driver
						.findElement(By.xpath("//tbody[@id='reservation-table']/tr[" +i+ "]/td[1]"));

				WebElement adv = driver.findElement(By.xpath("//tbody[@id='reservation-table']/tr[" +i + "]/td[2]"));

				WebElement personCount = driver
						.findElement(By.xpath("//tbody[@id='reservation-table']/tr[" +i+ "]/td[3]"));
				System.out.println("Print for debug" + i);
				System.out.println(bookingName.getText());
				System.out.println(adv.getText());
				System.out.println(personCount.getText());

				Assert.assertEquals(data[1], adv.getText());
				Assert.assertEquals(data[2], bookingName.getText());
				Assert.assertEquals(data[4], personCount.getText());
				i++;
		}*/
		
        List<WebElement> BookingName = driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr/td[1]"));
        List<WebElement> adventuresOnHistoryPage = driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr/td[2]"));
        List<WebElement> persons = driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr/td[3]"));
        List<WebElement> date = driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr/td[4]"));
        int adventuresMatching = 0;
       // int i =0;
        for(int n=0;n<3;n++) {
        for (WebElement webElement : adventuresOnHistoryPage) {

            for(int j=0; j<adventuresList.size(); j++){
            	//System.out.println(adventuresList.get(2));
                if(adventuresList.get(j).equals(webElement.getText())){
                	System.out.println(webElement.getText());
                   adventuresMatching++;
                 
                    break;
                }
            }            
        }

        for (WebElement webElement1 : adventuresOnHistoryPage) {

            for(int k=0; k<adventuresList.size(); k++){
            	//System.out.println(adventuresList.get(2));
                if(adventuresList.get(k).equals(webElement1.getText())){
                	System.out.println(webElement1.getText());
                   adventuresMatching++;
                 
                    break;
                }
            }            
        }
        for (WebElement webElement2 : adventuresOnHistoryPage) {

            for(int l=0; l<adventuresList.size(); l++){
            	//System.out.println(adventuresList.get(2));
                if(adventuresList.get(l).equals(webElement2.getText())){
                	System.out.println(webElement2.getText());
                   adventuresMatching++;
                 
                    break;
                }
            }            
        }
        for (WebElement webElement4 : adventuresOnHistoryPage) {

            for(int m=0; m<adventuresList.size(); m++){
            	//System.out.println(adventuresList.get(2));
                if(adventuresList.get(m).equals(webElement4.getText())){
                	System.out.println(webElement4.getText());
                   adventuresMatching++;
                 
                    break;
                }
            }            
        }
        }
		driver.findElement(By.xpath("//div[text()='Logout']")).click();

	}

	public  String bookingAdventures(String name, String date, String adventureToBeSelected, String numberOfPerson)
			throws InterruptedException {
	
		AdventurePage adp = new AdventurePage(driver);
		adp.selectAdventure(adventureToBeSelected);
		Thread.sleep(4000);
		AdventureDetails ad = new AdventureDetails(driver);
		String adventureName = driver.findElement(By.xpath("//h1[@id='adventure-name']")).getText();
		String BookingName= driver.findElement(By.xpath("//input[@type='text']")).getText();
		String date1=driver.findElement(By.xpath("//input[@type='date']")).getText();
		String count=driver.findElement(By.xpath("//input[@type='number']")).getText();
		ad.bookAdventure(name, date, numberOfPerson);
		Thread.sleep(5000);
		Boolean status = false;
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='reserved-banner']")).isDisplayed(),
				"Booking not successful.");
		//return BookingName;
		return adventureName;
		

	}

	

	@DataProvider
	public Object[][] Booking() throws Exception {
		Object[][] test = ExcelDataSupllier
				.getData("C://Users//USER//eclipse-workspace//TestNG//DataSheet//TestData.xlsx", "TestCase04");
		return (test);
	}

	@AfterSuite
	public static void quitDriver() {
		// System.out.println("quit()");
		driver.quit();
	}
}
