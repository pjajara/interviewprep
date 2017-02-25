package edu.sjsu.java.stack;

public class StackClient {

	public static void main(String[] args) {
		Stack s = new Stack(3);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
