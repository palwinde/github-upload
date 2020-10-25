package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Configuration;
import data.Locators;
/** Represents Place Order Class 
 * for placing order of 
 * items added in cart by logged on user
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class PlaceOrderPage {
	static Logger logger = Logger.getLogger(PlaceOrderPage.class.getName());
	WebDriver driver;
	@FindBy(xpath = Locators.xpath_cart)
	WebElement cart;
	@FindBy(xpath = Locators.xpath_home)
	WebElement home;
	
	@FindBy(xpath = Locators.xpath_placeOrder)
	 WebElement placeOrder;
	@FindBy(xpath = Locators.xpath_purchase)
	 WebElement purchase;
	@FindBy(xpath = Locators.xpath_okButton)
	 WebElement okButton;
	@FindBy(id = Locators.id_name)
	 WebElement name;
	@FindBy(xpath = Locators.xpath_creditCard)
	 WebElement creditCard;

	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/** Represents the method 
	 * for put the commond method of
	 * clicking the links again 
	 * fo handling the StaleElement Reference Exception 
	*/
public void allClicksPlaceOrder(String arg0,String arg1) {
	placeOrder.click();
	Configuration.scrollDown(driver, 0, 1000);
	purchase.click();
	Configuration.threadSleep(2000);
	Configuration.alertAccept(driver);
	name.sendKeys(arg0);
	creditCard.sendKeys(arg1);
	Configuration.scrollDown(driver, 0, 1000);
	purchase.click();
	Configuration.threadSleep(1000);

	
}

/** Represents the method 
 * for placing the order
 * by clicking the place order on web page
 * @exception: StaleElementReferenceException
*/
	public Boolean placeOrder(String arg0, String arg1) {

		// using loops to attempt clicking on element

		for(int attempts=0;attempts<10;attempts++) {
			try {
				if (attempts==0) {
					allClicksPlaceOrder(arg0,arg1);
					}
				else {
					System.out.println("attempts>1..."+attempts);
					cart.click();
					Configuration.threadSleep(2000);
					home.click();
					Configuration.threadSleep(200);
					allClicksPlaceOrder(arg0,arg1);
				}
				break;
				

			} catch (StaleElementReferenceException e) {
				//handling Stale element exception
				logger.info(e);
				Configuration.threadSleep(200);
				Configuration.refreshPage(driver);

continue;
			}
			catch (Exception e) {
				logger.info(e);
				Configuration.threadSleep(200);
				Configuration.refreshPage(driver);


				continue;

			}
		}
		
		//captures screenshot
		Boolean bool=Configuration.captureScreenshot(driver);
		okButton.click();
		return bool;

	}

}
