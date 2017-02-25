package edu.sjsu.java.anoop;

import java.util.NoSuchElementException;


public class SingleLinkedList 
{
    private Node first;
    
    public SingleLinkedList()
    {
        first = null;
    }
    
    public Object getFirst()
    {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    
    public Object removeFirst()
    {
        if(first == null) throw new NoSuchElementException();
        Object data = first.data;
        first = first.next;
        return data;
        
    }
    
    public Node getHead()
    {
        if(first == null) throw new NoSuchElementException();
        return first;
        
    }
    
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }
    
    class Node
    {
        public Object data;
        public Node next;
    }
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
    
    class LinkedListIterator implements ListIterator
    {
        public Node previous;
        public Node position;
        public boolean isAfterNext;
        
        public Object next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            previous = position; // for removal
            isAfterNext = true;
            
            if(position == null)
                position = first;
            else
                position = position.next;
            
            return position.data;
        }
        
        public boolean hasNext()
        {
            if(position == null)
                return first != null;
            else
                return position.next != null;
        }
        
        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;                
            }
            isAfterNext = false;
        }
        
        public void remove()
        {
            if(!isAfterNext) throw new IllegalStateException();
            if(position == first)
                removeFirst();
            else
                previous.next = position.next;
            position = previous;
            isAfterNext = false;
        }
        
        public void set(Object element)
        {
            if(!isAfterNext) throw new IllegalStateException();
            position.data = element;
        }

        @Override
        public Object previous() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public void reverseFirstN(int count)
    {
        if(first != null)
        {
            Node before = first;
            Node current = null;
            if(first.next != null)
                current = first.next;
            Node after = null;
            if(current != null && current.next != null)
                after = current.next;

            while(count >= 2 && current != null)
            {
                current.next = first;
                before.next = after;
                first = current;
                current = after;
                if(after != null)
                    after = after.next;
                count--;
            }
        }
    }
    
    public static void isCircular(SingleLinkedList names)
    {
        Node slow = names.getHead();
        Node fast = names.getHead();
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        
        if(fast == null || fast.next == null)
            return;
        
        slow = names.getHead();
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("------> " + slow.data);
    }
    
    public static void main(String[] args)
    {
      /*SingleLinkedList names = new SingleLinkedList();
      names.addFirst(9);
      names.addFirst(8);
      names.addFirst(7);
      names.addFirst(6);
      names.addFirst(5);
      names.addFirst(4);
      names.addFirst(3);
      names.addFirst(2);
      names.addFirst(1);
      names.addFirst(0);

      Node head = names.getHead();
      
      while(head.next != null)
      {
          head = head.next;
      }
      head.next = names.getHead().next.next.next.next;
      System.out.println(head.next.data);
      
      isCircular(names);*/
System.out.println(4/10);
     // ListIterator iter1 = names.listIterator();
     // while (iter1.hasNext()) System.out.print(iter1.next() + "->");
    }
}
