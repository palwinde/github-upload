package tests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.Constants_ID;
import junit.framework.Assert;
import pages.HomePage;
import pages.LogInOutPage;
import pages.PlaceOrderPage;
import pages.SignUpPage;
/** Represents Tests Class to
 * execute Tests of framework
 * Tests of this class are clled using testng xml
 * of maven POM frameowrk
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class ShopTests  {
	WebDriver driver;
	HomePage objHomePage;
	SignUpPage objSignUpPage;
	LogInOutPage objLogInOut;
	PlaceOrderPage objPlaceOrder;
	
	/** Represents the Before Test method called by 
	 * Test method before executing itself
	 * @BeforeTest is annotation used for same.
	*/
	@BeforeTest
	public void setup() {
	System.setProperty(Constants_ID.CHROMEDRIVER,Constants_ID.DRIVERPATH);
	driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Constants_ID.URL);
	}
	
	/** Represents the Test method called by 
	 * testng xml for execution
	 * @Test is annotation used for same.
	*/
	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() {
		Random rand = new Random(); 
		  
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(10000); 
        String user=Constants_ID.USERNAME+rand_int1;
		objSignUpPage=new SignUpPage(driver);
		objSignUpPage.veryHeader();
		objSignUpPage.enterFullName(user);
		objSignUpPage.enterPassword(Constants_ID.PASSWORD);
		objSignUpPage.signUp();
		objLogInOut=new LogInOutPage(driver);
		objLogInOut.clickLogIn();
		objLogInOut.enterFullName(user);
		objLogInOut.enterPassword(Constants_ID.PASSWORD);
		objLogInOut.enterSubmit();
		
		objHomePage = new HomePage(driver);
		objHomePage.addToCart();
		
		objPlaceOrder=new PlaceOrderPage(driver);
		Boolean bool=objPlaceOrder.placeOrder("Palwinder", "1234567890");
		Boolean bool1=true;
		Assert.assertEquals(bool1, bool);
	}
	
	/** Represents the After Test method called by 
	 * Test method after executing itself
	 * @AfterTest is annotation used for same.
	*/
	@AfterTest
	public void logout() {
		objLogInOut.logOut();
		driver.quit();
		
	}
	
}
