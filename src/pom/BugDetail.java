package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helper.StartWebDriver;

public class BugDetail extends PageBase {
	
	private WebDriver webDriver;
	
	@FindBy(how=How.LINK_TEXT,linkText="New Case")
	private WebElement NewCase;
	
	@FindBy(how=How.ID,id="bug_severity")
	private WebElement Severity;
	
/*	private By Severity = By.id("bug_severity");
	private By NewCase = By.linkText("New Case");*/
	
	public BugDetail(WebDriver _driver){
		super(_driver);
		webDriver = _driver;
		
	}
	
	public void SelectSeverity(String value) {
		/*Select select = new Select(driver.findElement(Severity));*/
		Select select = new Select(Severity);
		select.selectByVisibleText(value);
	}
	
	public void NaviagteToNewCase() {
		/*driver.findElement(NewCase).click();*/
		NewCase.click();
	}
	
	public void Logout(){
		LogOut();
	}

}
