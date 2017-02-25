package edu.sjsu.java.list.linkedlist;

import edu.sjsu.java.list.linkedlist.Node;

public class LinkedListUtil {
	public static Node reverse(Node head) {
		Node current = head;
		Node newHead = null;
		while (current != null) {
			Node tmp = current;
			current = current.next;
			tmp.next = newHead;
			newHead = tmp;
		}
		return newHead;
	}
	
	public static Node reverseRecursive(Node head){
		if(head == null || head.next==null){
			return head;
		}
		
		Node secondNode = head.next;
		head.next=null;
		Node newHead = reverseRecursive(secondNode);
		secondNode.next=head;
		return newHead;
	}
	

}
