package pom;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper.StartWebDriver;

public class EnterBug extends PageBase {
	
	private WebDriver webDriver;
	
	@FindBy(how=How.LINK_TEXT,linkText="Testng")
	private WebElement Testng;
	
	@FindBy(how=How.LINK_TEXT,linkText="New Run")
	private WebElement NewRun;
	
	/*private By Testng = By.linkText("Testng");
	private By NewRun = By.linkText("New Run");*/
	
	public EnterBug(WebDriver _driver){
		super(_driver);
		webDriver = _driver;
	}
	
	public BugDetail ClickTestNg() {
		/*driver.findElement(Testng).click();*/
		Testng.click();
		return new BugDetail(webDriver);
	}
	
	public void Logout(){
		LogOut();
	}
	
	public void NavigateToNewRun() {
		NewRun.click();
		/*driver.findElement(NewRun).click();*/
	}

}
