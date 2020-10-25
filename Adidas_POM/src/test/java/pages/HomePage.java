package pages;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Configuration;
import config.LoggerClass;
import data.Locators;
/** Represents Home Page Class 
 * in Page Object Model framework
 * It represents page when user is logged 
 * on in application, so this page
 * is visible to user
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class HomePage {
	static Logger logger = LoggerClass.getLogger(HomePage.class.getName());
	WebDriver driver;
	@FindBy(xpath = Locators.xpath_laptop)
	WebElement laptops;
	@FindBy(xpath = Locators.xpath_phones)
	WebElement phones;
	@FindBy(xpath = Locators.xpath_monitors)
	WebElement monitors;
	@FindBy(xpath = Locators.xpath_cart)
	WebElement cart;
	@FindBy(xpath = Locators.xpath_addToCart)
	WebElement addToCart;
	@FindBy(xpath = Locators.xpath_home)
	WebElement home;
	@FindBy(xpath = Locators.xpath_delete)
	WebElement delete;
	@FindBy(xpath = Locators.xpath_nameofuser)
	WebElement nameOfUser;
	@FindBy(xpath = Locators.xpath_Sony_vaio_i5)
	WebElement sonyVaioI5;
	@FindBy(xpath = Locators.xpath_Dell_i7_8gb)
	WebElement dellI78gb;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/** Represents the method 
	 * for handling the stale elemnt exception
	 * and use it as common method 
	 * for any element
	 * 
	*/
	public void handleClick(WebElement element) {
		for(int attempts=0;attempts<10;attempts++) {
			try {
				if(attempts==0)
					element.click();

				
				
				if(attempts>0) {
					System.out.println("attempts>1"+attempts);
					cart.click();
					Configuration.threadSleep(2000);
					home.click();
					Configuration.threadSleep(200);

					element.click();

				}
				
				
				
				break;

			} catch (StaleElementReferenceException e) {
				logger.info(e);
				Configuration.threadSleep(200);
				Configuration.refreshPage(driver);

				monitors.click();
	continue;
			}
			catch (Exception e) {
				logger.info(e);
				Configuration.threadSleep(200);
				Configuration.refreshPage(driver);

				monitors.click();

				continue;

			}
		}
		
	}
public void addToCart() {
		//click on laptop link
	handleClick(laptops);
	//select laptop
	handleClick(sonyVaioI5);
//wait for adding to cart
	Configuration.wait(driver, addToCart, 2000);
	//adding slected latop to cart
	addToCart.click();
	//delay
	Configuration.threadSleep(2000);
	//accept the added alert
	Configuration.alertAccept(driver);
	//wait for home link to be clickable
	Configuration.wait(driver, home, 2000);
//go to home page
	home.click();
// wait for laptop link to be clickable
	Configuration.wait(driver, laptops, 40);
	
	// handling for laptop link to be clickable

	handleClick(laptops);

	// wait for selected laptop link to be clickable

	Configuration.wait(driver, dellI78gb, 400);
//scrolling down
	Configuration.scrollDown(driver, 0, 1000);
	dellI78gb.click();
	Configuration.wait(driver, addToCart, 2000);

	addToCart.click();
	Configuration.threadSleep(2000);

	Configuration.alertAccept(driver);

	Configuration.threadSleep(2000);
	Configuration.scrollUp(driver, 1000, 0);
	Configuration.wait(driver, cart, 2000);

	cart.click();

	Configuration.wait(driver, delete, 40);

	delete.click();
	Configuration.threadSleep(1000);
}
public void allClicks() {

	laptops.click();

	sonyVaioI5.click();
	Configuration.wait(driver, addToCart, 2000);
	addToCart.click();
	Configuration.threadSleep(2000);
	Configuration.alertAccept(driver);
	Configuration.wait(driver, home, 2000);

	home.click();

	Configuration.wait(driver, laptops, 2000);

				laptops.click();

			
			
	Configuration.wait(driver, dellI78gb, 400);

	Configuration.scrollDown(driver, 0, 1000);
	dellI78gb.click();
	Configuration.wait(driver, addToCart, 2000);

	addToCart.click();
	Configuration.threadSleep(2000);

	Configuration.alertAccept(driver);

	Configuration.threadSleep(2000);
	Configuration.scrollUp(driver, 1000, 0);
	Configuration.wait(driver, cart, 2000);

	cart.click();

	Configuration.wait(driver, delete, 40);

	delete.click();
	Configuration.threadSleep(1000);
}
	public void addToCartTest() {
		// home.click();

		for(int attempts=0;attempts<10;attempts++) {
			try {
				if (attempts==0) {
					allClicks();
					}
				else {
					System.out.println("attempts>1..."+attempts);
					cart.click();
					Configuration.threadSleep(2000);
					home.click();
					Configuration.threadSleep(200);
					allClicks();
				}
				break;
				

			} catch (StaleElementReferenceException e) {
				logger.info(e);
				Configuration.threadSleep(200);
				Configuration.refreshPage(driver);

				monitors.click();
continue;
			}
			catch (Exception e) {
				logger.info(e);
				Configuration.threadSleep(200);
				Configuration.refreshPage(driver);

				monitors.click();

				continue;

			}
		}
		
	}

}
