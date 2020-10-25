package data;
/** Represents Locators Class for
 * collection of various locators to
 * be used by application 
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class Locators {
	public static final  String xpath_laptop="//a[contains(text(),'Laptops')]";
	public static final  String xpath_phones="//a[contains(text(),'Phones')]";
	public static final  String xpath_monitors="//a[contains(text(),'Monitors')]";
	public static final  String xpath_cart="//a[contains(text(),'Cart')]";
	public static final  String xpath_addToCart="//a[contains(text(),'Add to cart')]";
	public static final  String xpath_home="//a[contains(text(),'Home ')]";
	public static final  String xpath_delete="//td[contains(text(),'Dell i7 8gb')]/following-sibling::td//a[contains(text(),'Delete')]";
	public static final  String xpath_nameofuser="//a[@id='nameofuser']";
	public static final  String xpath_Sony_vaio_i5="//a[contains(text(),'Sony vaio i5')]";
	public static final  String xpath_Dell_i7_8gb="//a[contains(text(),'Dell i7 8gb')]";
	public static final  String xpath_logIn="//a[@id='login2']";
	public static final  String xpath_userName="//*[@id='loginusername']";
	public static final  String xpath_submitLogIn="//button[contains(text(),'Log in')]";
	public static final  String xpath_password="//*[@id='loginpassword']";
	public static final  String xpath_logOut="//a[contains(text(),'Log out')]";
	public static final  String xpath_placeOrder="//button[contains(text(),'Place Order')]";
	public static final  String xpath_purchase="//button[contains(text(),'Purchase')]";
	public static final  String xpath_okButton="//button[contains(text(),'OK')]";
	public static final  String id_name="name";
	public static final  String xpath_creditCard="//label[contains(text(),'Credit card:')]/following-sibling::input[@id='card']";
	public static final String id_Header = "signin2";
	public static final String xpath_Header ="//a[contains(text(),'Sign up')]";
	
	public static final String xpath_userName_s = "//*[@id='sign-username']";
	public static final String xpath_signUp_s = "//button[contains(text(),'Sign up')]";
	public static final String xpath_password_s = "//*[@id='sign-password']";
	public static final String xpath_close_s = "//button[contains(text(),'Close')]";
}
