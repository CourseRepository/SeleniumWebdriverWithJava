/**
 * 
 */
package customeexception;

/**
 * @author - rahul.rathore
 * @date - 20-Jun-2015
 * @project - Webdriver
 * @package - customeexception
 * @file name - NoKeywordFoundException.java
 */
public class NoKeywordFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoKeywordFoundException(String message){
		super(message);
	}

}
