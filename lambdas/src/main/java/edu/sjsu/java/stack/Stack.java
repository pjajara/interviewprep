package edu.sjsu.java.stack;

public final class Stack {

	private int[] arr;
	private int size;
	private int top = -1;

	public Stack(int size) {
		this.size = size;
		arr = new int[size];
	}
	
	public Stack(){
		arr = new int[15];
	}

	public void push(int data) {
		if (!isFull()) {
			arr[++top] = data;
		} else {
			System.out.println("IntStack Full!");
		}
	}

	public int pop() {
		if (!isEmpty()) {
			return arr[top--];
		} else {
			System.out.println("IntStack Empty");
			//noinspection ConstantConditions
			return (Integer) null;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return arr[top];
		} else {
			System.out.println("IntStack Empty");
			return (Integer) null;
		}
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public boolean isFull() {
		return (top == size - 1);
	}
}
