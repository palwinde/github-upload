package com.Adidas_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import  static data.Constants_ID.CHROMEDRIVER;
//import  static data.Constants_ID.DRIVERPATH;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("https://www.demoblaze.com/index.html");
    }
}
