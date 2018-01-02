package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ElementRepositry {
	
	@FindBy(how=How.XPATH,using="//div[@id='header']//ul[@class='links']/li[1]//a")
	public static WebElement home_link;
	
	@FindBy(how=How.LINK_TEXT,using="File a Bug")
	//@CacheLookup
	public static WebElement file_a_Bug; //id or value of name attribute
	
	@FindBy(how=How.ID, using="Bugzilla_login")
	public static WebElement Bugzilla_login;
	
	@FindBy(how=How.ID,using="Bugzilla_password")
	public static WebElement Bugzilla_password;
	
	@FindBy(how=How.ID,using="log_in")
	//@CacheLookup
	public static WebElement log_in;
	
	@FindBy(how=How.XPATH,using="//div[@id='header']/ul[1]/li[11]/a")
	//@CacheLookup // this will l\do a lookup from the cache of browser for the element
	public static WebElement logout_button;
}
