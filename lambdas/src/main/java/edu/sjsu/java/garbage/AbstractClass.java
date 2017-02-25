package edu.sjsu.java.garbage;

public abstract class AbstractClass implements MyInterface {

	public AbstractClass() {

	}

	public abstract void method1();

	public abstract void method2();

	public abstract void method3();

	public void method4() {
		String s = "sdfdsf";
		System.out.println(s);
	}

	public static void main(String[] args) {
		System.out.println("Inside main method of AbstractClass");
	}

}
