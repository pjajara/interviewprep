package com.gf.linkedlist;

/**
 * Created by pjajara on 2/27/17.
 */
public class ReverseLinkedList {

    public static void main (String[] args) throws java.lang.Exception
    {
        LinkedListT a = new LinkedListT();
        a.addAtBegin(5);
        a.addAtBegin(10);
        a.addAtBegin(15);
        a.addAtBegin(20);
        a.addAtBegin(25);
        a.addAtBegin(30);
//		System.out.print("Original Link List 1 : ");
        a.display(a.head);
        a.reverseIterative(a.head);
        LinkedListT b = new LinkedListT();
        b.addAtBegin(31);
        b.addAtBegin(32);
        b.addAtBegin(33);
        b.addAtBegin(34);
        b.addAtBegin(35);
        b.addAtBegin(36);
        System.out.println("");
        System.out.println("___________________");
        System.out.print("Original Link List 2 : ");
        b.display(b.head);
        b.reverseRecursion(b.head,b.head.next,null);
        System.out.println("");
        //b.display(x);
    }
}
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedListT{
    public Node head;
    public LinkedListT(){
        head=null;
    }

    public void addAtBegin(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }
    public void reverseIterative(Node head){
        Node currNode = head;
        Node nextNode = null;
        Node prevNode = null;

        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;
        System.out.println("\n Reverse Through Iteration");
        display(head);
    }

    public void reverseRecursion(Node ptrOne,Node ptrTwo, Node prevNode){
        if(ptrTwo!=null){
            if(ptrTwo.next!=null){
                Node t1 = ptrTwo;
                Node t2 = ptrTwo.next;
                ptrOne.next = prevNode;
                prevNode = ptrOne;
                reverseRecursion(t1,t2, prevNode);
            }
            else{
                ptrTwo.next = ptrOne;
                ptrOne.next = prevNode;
                System.out.println("\n Reverse Through Recursion");
                display(ptrTwo);
            }
        }
        else if(ptrOne!=null){
            System.out.println("\n Reverse Through Recursion");
            display(ptrOne);
        }
    }

    public void display(Node head){
        //
        Node currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
    }
}