package pom;

import helper.ButtonHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase{
	
	/* Region - All the Web Element */
	
	private WebDriver webDriver;
	
	@FindBy(how=How.LINK_TEXT,linkText="File a Bug")
	private WebElement FilaBug;
	
	@FindBy(how=How.ID,id="quicksearch_main")
	private WebElement QuickSearchTxtBox;
	
	@FindBy(how=How.ID,id="find")
	private WebElement QuickSearchButton;
	
	@FindBy(how=How.LINK_TEXT,linkText="New")
	private WebElement New;
	
	/*private By FilaBug = By.linkText("File a Bug");
	private By QuickSearchTxtBox = By.id("quicksearch_main");
	private By QuickSearchButton = By.id("find");
	private By New = By.linkText("New");
	*/
	/* Region - All the actions */
	
	public HomePage(WebDriver _driver){
		super(_driver);
		webDriver = _driver;
	}
	
	public LoginPage ClickFileABug(){
		FilaBug.click();
		/*driver.findElement(FilaBug).click();*/
		return new LoginPage(webDriver);
	}
	
	public void QuickSearch(String searchText) {
		QuickSearchTxtBox.sendKeys(searchText);
		QuickSearchButton.click();
		/*driver.findElement(QuickSearchTxtBox).sendKeys(searchText);
		driver.findElement(QuickSearchButton).click();*/
		
	}
	
	/* Region - Naviagtion */
	
	public void NavigateToNewPage() {
		/*driver.findElement(New).click();*/
		New.click();
		
	}

}
