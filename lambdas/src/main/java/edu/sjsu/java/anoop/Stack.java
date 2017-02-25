package edu.sjsu.java.anoop;

import java.util.NoSuchElementException;


public class Stack 
{
    private Node first;
    
    public Stack()
    {
        first = null;
    }
    
    public void push(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }
    
    public Object pop()
    {
        if(first == null) throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;    
        return element;
    }
    
    public boolean empty()
    {
        return first != null;
    }
    
    class Node
    {
        public Node next;
        public Object data;        
    }
}
