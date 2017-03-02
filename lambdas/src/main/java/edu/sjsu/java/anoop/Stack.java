package edu.sjsu.java.anoop;

import java.util.NoSuchElementException;


// You won't need top pointer that points
public class Stack {

    private Node first = null;
    private int size = 0;

    public void push(Object element) {

        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;

        first = newNode;
        size++;
    }

    public Object pop() {
        if (first == null) throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        size--;
        return element;
    }

    public Object peek(){
        if (first == null){
            throw new NoSuchElementException();
        }
        else {
            return first.data;
        }
    }

    public boolean empty() {
        return first != null;
    }

    public int size(){
        return this.size;
    }

    class Node {
        private Node next;
        private Object data;
    }

    public static void main(String[] args) {

        Stack s = new Stack();
        s.push("One");
        s.push("Two");
        s.push("Three");

        System.out.println(s.peek());
        System.out.println(s.peek());
        System.out.println(s.peek());

        System.out.println("Size: " + s.size());

        System.out.println(s.pop());

        System.out.println("Size: " + s.size());
        System.out.println(s.pop());

        System.out.println("Size: " + s.size());
        System.out.println(s.pop());
        // System.out.println(s.pop());

        System.out.println("Size: " + s.size());

        System.out.println("Reached the end");

    }
}
