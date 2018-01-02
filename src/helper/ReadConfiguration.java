package helper;

import org.openqa.selenium.TimeoutException;

interface ReadConfiguration {
	
	/**
	 * @return the url from file
	 */
	public String getUrl();
	
	/**
	 * @return the browser name from file
	 */
	public String getBrowser();
	
	/**
	 * @return the username of the application from file
	 */
	public String getUsername();
	
	/**
	 * @return the password of the application from file
	 */
	public String getPassword();
	
	/**
	 * @return the default implicit wait for element
	 */
	public int getElementWait();
	
	/**
	 * @return the page load time out 
	 */
	public int getPageWait() throws TimeoutException;
	
	/**
	 * @return the data base name from the file	
	 */
	public String getDbName();
	
	/**
	 * @return the data base user name from the file
	 */
	public String getDbUserName();
	
	/**
	 * @return the data base password from the file
	 */
	public String getDbPassword();
	
	/**
	 * @return the host ip from the file	
	 */
	public String getHost();
	
	/**
	 * @return true/false for the grid
	 */
	public boolean isGridPresent();
	
	/**
	 * @return the grid url from the file
	 */
	public String getGridUrl();
}
