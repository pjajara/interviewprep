package edu.sjsu.java.staticops;

public class StaticBlock {

	private static String str;

	static{
		str = "static string from block";
		System.out.println("INside static block");
	}
	static {
		System.out.println("Inside instance initializer");
	}
	public StaticBlock() {
		System.out.println("Inside constructor");
		str="33";
	}

	public static void main(String[] args) {
		StaticBlock sb = new StaticBlock();
		System.out.println(str);
	}

}
