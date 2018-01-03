package testcase;

import helper.GridHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.testng.annotations.Test;

public class TestWebTable extends StartWebDriver {
	
	
	@Test
	public void testGrid() {
		
		/*for (int row = 1; row <= 6; row++) {
			for (int col = 1; col <= 5; col++) {
				String xpath = "//table[@id='wb-auto-1']//tbody//tr[" + row + "]//td[" + col + "]";
				//System.out.println(xpath);
				WebElement col1 =  driver.findElement(By.xpath(xpath));
				System.out.print(col1.getText() + " ");
				
			}
			System.out.println();
		}*/
		
		/*System.out.println(GridHelper.getColumnValue("//table[@id='wb-auto-1']", 1, 4));
		List<String> data = GridHelper.getAllValues("//table[@id='wb-auto-1']");
		
		for (String string : data) {
			System.out.println(string);
		}
		System.out.println();*/
		WindowHelper.navigateToPage("http://demos.telerik.com/kendo-ui/grid/custom-command");
		GridHelper.clickButtonInGrid("//div[@class='k-grid-content k-auto-scrollable']//table[@role='grid']", 2, 3);
	}

}
