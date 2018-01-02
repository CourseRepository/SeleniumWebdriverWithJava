package testcase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import helper.StartWebDriver;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestMethodCall.java
 */
public class TestMethodCall extends StartWebDriver {
	
	public void Add() {
		System.out.println("++++++++++++++ Addition +++++++++++++++++++");
		
	}
	
	public void Substraction() {
		System.out.println("--------------- Substraction ---------------");
	}
	
	public void Multiplication() {
		System.out.println("**************** Multiplication **************");
	}
	
	public void Division() {
		System.out.println("//////////////// Division /////////////////////");
	}
	
	@Test
	public void testCase() {
		try {
			Method name = this.getClass().getMethod(file.getMethodName());
			name.invoke(this);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}



}
