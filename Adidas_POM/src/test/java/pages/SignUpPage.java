package pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Configuration;
import data.Locators;
/** Represents Sign up page
 * for creating new user and 
 * password for user
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class SignUpPage {
	static Logger logger = Logger.getLogger(SignUpPage.class.getName());

	WebDriver driver;
	@FindBy(xpath= Locators.xpath_Header)
	 WebElement Header;
	@FindBy(xpath = Locators.xpath_userName_s)
	 WebElement userName;
	@FindBy(xpath = Locators.xpath_signUp_s)
	 WebElement signUp;
	@FindBy(xpath = Locators.xpath_password_s)
	 WebElement password;
	@FindBy(xpath = Locators.xpath_close_s)
	 WebElement close;
	/** Represents the Parameturized Constructor Test 
	 * which instantiates the Webdriver and other web elements
	 * which are located in this page
	*/
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	/** Represents the method 
	 * for verifying sign up link present on the page
	 * by element location and assertion 
	*/

	public void veryHeader() {
		String getheadertext = Header.getText().trim();
		assertEquals("Sign up", getheadertext);
	}

	public void enterFullName(String arg1) {
		Header.click();

		userName.sendKeys(arg1);
	}

	public void enterPassword(String arg1) {
		password.sendKeys(arg1);
	}
	/** Represents the method 
	 * for clicking the sign up link
	 * entering the given username 
	 * and password and clicking on sign up link
	 * and accepting the alert therefore
	 * In case user is already there then 
	 * it is handled by accepting the alert
	 * and refreshing the page
	*/
	public void signUp() {

		signUp.click();
		Configuration.threadSleep(3000);
		String text= Configuration.alertText(driver);
		if(text.contains("already")) {
			Configuration.alertAccept(driver);

			Configuration.refreshPage(driver);
		}
		else {
		Configuration.alertAccept(driver);
		}
	}
}