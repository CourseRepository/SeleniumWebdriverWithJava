/**
 * 
 */
package helper.customexceptions;


public class KeyWordNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KeyWordNotFoundException(String message){
		super(message + " Keyword Not found");
	}
}
