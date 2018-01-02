package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitHelper {
	
	private FluentWait<WebDriver> fluentWait;
	private WebDriver webDriver;
	private List<Class> ignoreException = new ArrayList<Class>();
	
	public FluentWaitHelper setIgnoreExceptionList(List<Class> ignoreException) {
		this.ignoreException = ignoreException;
		return this;
	}
	public FluentWaitHelper setDriver(WebDriver driver) {
		this.webDriver = driver;
		return this;
	}
	public FluentWaitHelper setPollingInterval(int pollingInterval) {
		this.pollingInterval = pollingInterval;
		return this;
	}
	public FluentWaitHelper setTimeOut(int timeOut) {
		this.timeOut = timeOut;
		return this;
	}
	
	private int pollingInterval;
	private int timeOut;
	
	public void build(){
		fluentWait = new FluentWait<WebDriver>(this.webDriver);
		fluentWait.pollingEvery(this.pollingInterval, TimeUnit.MILLISECONDS);
		fluentWait.withTimeout(this.timeOut, TimeUnit.SECONDS);
		addIgnoreExceptionType();
	}
	
	private void addIgnoreExceptionType() {
		if(!this.ignoreException.isEmpty()){
			for (Class class1 : ignoreException) {
				fluentWait.ignoring(class1);
			}
		}
	}
	
	public <R> R waitFor(Function<WebDriver, R> waitFunction){
		return fluentWait.until(waitFunction);
	}
	
}
