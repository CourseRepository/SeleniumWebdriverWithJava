package testcase.reflection;

import java.lang.reflect.Method;

public class TestRef {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("helper.ButtonHelper");
			Object obj = cls.newInstance();
			Method m[] = cls.getDeclaredMethods();
			for (Method method : m) {
				System.out.println("Name : = " + method.getName());
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
