package config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.Locators;
/** Represents Configuration Class for common methods being used repititvely by different methods.
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class Configuration {
	/** Represents the scroll down method for locating element down on the page
	*/
public static void scrollDown(WebDriver driver,int x,int y) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy("+x+","+y+")");

}
/** Represents the scroll up method for locating element up on the page
*/
public static void scrollUp(WebDriver driver,int x,int y) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy("+x+","+y+")");

}
/** Represents the Fluent wait added to verify if element is clickable after duration of given time
*/
public static void wait(WebDriver driver,WebElement element,long time) {
WebDriverWait wait =new WebDriverWait(driver,time);
wait.until(ExpectedConditions.elementToBeClickable(element));

}

/** Represents the method for refresh the current url or page
*/
public static void refreshPage(WebDriver driver) {
	driver.navigate().to(driver.getCurrentUrl());

}
/** Represents the method for retreiving the text of alert on page
*/
public static String alertText(WebDriver driver) {
	return driver.switchTo().alert().getText();

}

/** Represents the method for accepting the alert on the page
*/
public static void alertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();

}
/** Represents the method for dismissing the alert on the page
*/
public static void alertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();

}

/** Represents the method for finding the element for given locator on the page
*/
public static WebElement findElement(WebDriver driver,By by) {
	return driver.findElement(by);
}

/** Represents the method for providing the delay of given time limit
*/
public static void threadSleep(long time) {
	
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

/** Represents the method for capturing the screenshot on page and screenshot is placed in
 * Screenshots folder of workspace with name Screen.png
*/
public static Boolean captureScreenshot(WebDriver driver){
	Boolean bool;
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));
		bool=true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		bool= false;
	}
	System.out.println("the Screenshot is taken");
	return bool;
}
}
