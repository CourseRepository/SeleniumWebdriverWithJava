/**
 * 
 */
package testcase.testOne;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 23-May-2015
 * @project - Webdriver
 * @package - testcase.testOne
 * @file name - MainClass.java
 */

class a{
	public int getInt(){
		return 1;
	}
}
public class MainClass {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("@AfterClass");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("@AfterSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}
	@AfterTest
	public void AfterTest() {
		System.out.println("@AfterTest");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}
	
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("@BeforeGroups");
	}
	@AfterGroups
	public void AfterGroups() {
		System.out.println("@AfterMethod");
	}
	
	@Test(groups="A")
	public void testCaseOne() {
		System.out.println("Test Case One");
	}
	
	@Test(groups="B")
	public void testCaseTwo() {
		throw new RuntimeException("Error");
	}
	/*@DataProvider(name="name")
	public Object[][] name() {
		Object[][] data = new Object[2][2];
		data[0][0] = "a";
		data[0][1] = new a();
		data[1][0] = "c";
		data[1][1] = new a();
		
		return data;
	}
	@Test(dataProvider="name")
	public void testCaseOne(String a,a obj) {
		System.out.println("Test Case One : " + a + obj.getInt());
	}*/

}
