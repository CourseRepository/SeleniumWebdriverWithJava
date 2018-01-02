package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper.StartWebDriver;

public class LoginPage extends PageBase  {
	
	/*private By Bugzilla_login = By.id("Bugzilla_login");
	private By Bugzilla_password = By.id("Bugzilla_password");
	private By LoginBtn = By.id("LoginBtn");
	private By Home = By.linkText("Home");*/
	
	private WebDriver webDriver;
	
	@FindBy(how=How.LINK_TEXT,linkText="Home")
	private WebElement Home;
	
	@FindBy(how=How.ID,id="Bugzilla_login")
	private WebElement Bugzilla_login;
	
	@FindBy(how=How.ID,id="Bugzilla_password")
	private WebElement Bugzilla_password;
	
	@FindBy(how=How.ID,id="log_in")
	private WebElement LoginBtn;
	
	public LoginPage(WebDriver _driver){
		super(_driver);
		webDriver = _driver;
	}
	
	public EnterBug Login(String user,String pass) {
		Bugzilla_login.sendKeys(user);
		Bugzilla_password.sendKeys(pass);
		LoginBtn.click();
		/*driver.findElement(Bugzilla_login).sendKeys(user);
		driver.findElement(Bugzilla_password).sendKeys(pass);
		driver.findElement(LoginBtn).click();*/
		return new EnterBug(webDriver);
	}
	
	public void NavigateToHome() {
		/*driver.findElement(Home).click();*/
		Home.click();
	}

}
