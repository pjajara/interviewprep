package edu.sjsu.java.list.linkedlist;

public class Node {

	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void appendToTail(int data) {
		Node end = new Node(data);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public static void main(String[] args) {
		Node n = new Node(5);
		System.out.println(n.getData());
		n.appendToTail(1);
		System.out.println(n.getData());
		n.appendToTail(2);
		System.out.println(n.getData());
		n.appendToTail(3);
		System.out.println(n.getData());
		n.appendToTail(4);
		System.out.println(n.getData());
		n.appendToTail(7);
		System.out.println(n.getData());
		n.appendToTail(8);
		System.out.println(n.getData());

		System.out.println(n.getData());
	}

}
