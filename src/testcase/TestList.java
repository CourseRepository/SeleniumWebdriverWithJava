package testcase;

import java.util.LinkedList;
import java.util.List;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestList.java
 */
public class TestList {

	
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		System.out.println("Value at 1st : " + list.get(1));
		System.err.println("Size : " + list.size());
		list.remove(2); 
		
		System.err.println("Size : " + list.size());
		list.clear();
		System.err.println("Size : " + list.size());

	}

}
