package pages;

import data.Locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.LoggerClass;

/** Represents Initial Page of POM
 * when users start the given url of application
 * It has login and logout methods replication
 * in this class
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class LogInOutPage {
	static Logger logger = LoggerClass.getLogger(LogInOutPage.class.getName());

WebDriver driver;
@FindBy(xpath =Locators.xpath_logIn )
WebElement logIn;
@FindBy(xpath = Locators.xpath_userName)
WebElement userName;
@FindBy(xpath = Locators.xpath_submitLogIn)
WebElement submitLogIn;
@FindBy(xpath = Locators.xpath_password)
WebElement password;
@FindBy(xpath = Locators.xpath_logOut)
WebElement logOut;
public LogInOutPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}
public void clickLogIn() {
	logIn.click();
	
}

public void logOut() {
	logOut.click();
}
public void enterFullName(String arg1) {
userName.sendKeys(arg1);
}

public void enterPassword(String arg1) {
password.sendKeys(arg1);
}

public void enterSubmit() {

	submitLogIn.click();
}
}