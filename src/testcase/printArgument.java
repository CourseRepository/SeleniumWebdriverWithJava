package testcase;

public class printArgument {

	/**
	 * @param args
	 */
	public static void main(String[] arg) {
		String [] args = arg[0].split(",");
		for(int i = 0; i < args.length; i++)
			System.out.println("Argumet : " + args[i]);

	}

}
