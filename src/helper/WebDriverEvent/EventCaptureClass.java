package helper.WebDriverEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventCaptureClass implements WebDriverEventListener {

private static int aSpeed = 0;
	
	public EventCaptureClass(int aSpeed) {
		this.aSpeed = aSpeed;
	}
	
	private void setControlSpeed(){
		try {
			Thread.sleep(aSpeed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		setControlSpeed();
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		setControlSpeed();
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		setControlSpeed();
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		setControlSpeed();
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		setControlSpeed();
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		setControlSpeed();
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		setControlSpeed();
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}


}
