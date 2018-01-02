package testcase;

import helper.GenericHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TakeScreenShot extends StartWebDriver {
	
	private byte[] appendToArray(byte dest[],byte src[]) {
		
		int index = 0;
		byte array[] = new byte[1];
		
		System.out.println("Destination Length : " + dest.length );
		System.out.println("Source Length : " + src.length );
		
		if(dest.length == 0){
			index = 0;
			array = new byte[src.length];
		}else{
			index = dest.length;
			array = new byte[(dest.length + src.length)];
		}
		
		for (int i = 0; i < dest.length; i++) {
			array[i] = dest[i];
		}
		
		for (int j = 0; j < src.length; j++) {
			array[index + j] = src[j];
		}
		
		return array;
	}
	
	@Test
	public void takeMultipleScreenShot() {
		WindowHelper.navigateToPage("https://www.udemy.com/bdd-with-selenium-webdriver-and-speckflow-using-c/");
		byte scrShot[] = new byte[0];
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollTo(0,0)");
		Boolean a = (Boolean) exe.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
		Long clientH = (Long)exe.executeScript("return document.documentElement.clientHeight");
		Long scrollH = (Long)exe.executeScript("return document.documentElement.scrollHeight");
		int index = 1;
		if(a.booleanValue() && !"firefox".equalsIgnoreCase(file.getBrowser())){
			while(scrollH.intValue() > 0){
				byte imgArray[] = GenericHelper.takeScreenShot();
				scrShot = appendToArray(scrShot, imgArray);
				System.out.println("scrShot Length : " + scrShot.length );
				GenericHelper.executeScript("window.scrollTo(0," + clientH * index + ")");
				scrollH = scrollH - clientH;
				index++;
			}
			System.err.println("scrShot :- "+scrShot.length);
			InputStream in = new ByteArrayInputStream(scrShot);
			try {
				BufferedImage img = ImageIO.read(in);
				ImageIO.write(img, "jpg", new File("C:\\downloads\\screen.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else
			GenericHelper.takeScreenShot("SceenShot");
		
	}
}
