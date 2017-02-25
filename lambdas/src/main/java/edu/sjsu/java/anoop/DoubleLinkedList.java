package edu.sjsu.java.anoop;

import java.util.NoSuchElementException;


public class DoubleLinkedList 
{
    private Node first;
    private Node last;
    
    public DoubleLinkedList()
    {
        first = null;
        last = null;
    }
    
    public Object getFirst()
    {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    
    public Object removeFirst()
    {
        if(first == null) throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        if(first == null)
            last = null;
        else
            first.previous = null;
        return element;
    }
    
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.previous = null;
        newNode.next = first;
        if(first == null)
            last = newNode;
        else
            first.previous = newNode;
        first = newNode;
    }
    
    public Object getLast()
    {
        if(last == null) throw new NoSuchElementException();
        return last.data;
    }
    
    public Object removeLast()
    {
        if(last == null) throw new NoSuchElementException();
        Object element = last.data;
        last = last.previous;
        if(last == null)
            first = null;
        else
            last.next = null;
        return element;
    }
    
    public void addLast(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.previous = last;
        newNode.next = null;
        if(last == null)
            first = newNode;
        else
            last.next = newNode;
        last = newNode;
    }
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
    
    class Node
    {
        public Node previous;
        public Node next;
        public Object data;
    }
    
    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private boolean isAfterPrevious;
        private boolean isAfterNext;
        
        public LinkedListIterator()
        {
            position = null;
            isAfterPrevious = false;
            isAfterNext = false;
        }
        
        public boolean hasNext()
        {
            if(position == null)
                return first != null;
            else
                return position.next != null;
        }
        
        public Object next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            if(position == null)
                position = first;
            else
                position = position.next;
            isAfterPrevious = false;
            isAfterNext = true;
            return position.data;
        }
        
        public boolean hasPrevious()
        {
            return position != null;
        }

        public Object previous()
        {
            if(!hasPrevious()) throw new NoSuchElementException();
            Object element = position.data;
            position = position.previous;
            isAfterPrevious = true;
            isAfterNext = false;
            return element;
        }
        
        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element);
                position = first;
            }
            else if(position == last)
            {
                addLast(element);
                position = last;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                position.next.previous = newNode;
                newNode.next = position.next;
                position.next = newNode;
                newNode.previous = position;
                position = newNode;
            }
            isAfterPrevious = false;
            isAfterNext = false;
        }
        
        public void remove()
        {
            Node positionToRemove = lastPosition();
            if(positionToRemove == first)
                removeFirst();
            else if(positionToRemove == last)
                removeLast();
            else
            {
                positionToRemove.previous.next = positionToRemove.next;
                positionToRemove.next.previous = positionToRemove.previous;
            }
            if(isAfterNext)
               position = position.previous;
            isAfterPrevious = false;
            isAfterNext = false;
        }
        
        public void set(Object element)
        {
            Node positionToSet = lastPosition();
            positionToSet.data = element;
        }
        
        public Node lastPosition()
        {
            if(isAfterNext)
                return position;
            else if(isAfterPrevious)
            {
                if(position == null)
                    return first;
                else
                    return position.next;
            }
            else
                throw new IllegalStateException();
        }
    }
    
    
    
public static void main(String[] args)
   {
      DoubleLinkedList lst = new DoubleLinkedList();
      check("", lst, "Constructing empty list");
      lst.addLast("A"); 
      check("A", lst, "Adding last to empty list");
      lst.addLast("B"); 
      check("AB", lst, "Adding last to non-empty list");

      lst = new DoubleLinkedList();
      lst.addFirst("A"); 
      check("A", lst, "Adding first to empty list");
      lst.addFirst("B"); 
      check("BA", lst, "Adding first to non-empty list");

      assertEquals("B", lst.removeFirst());
      check("A", lst, "Removing first, yielding non-empty list");
      assertEquals("A", lst.removeFirst());
      check("", lst, "Removing first, yielding empty list");

      lst = new DoubleLinkedList();
      lst.addLast("A"); 
      lst.addLast("B"); 
      check("AB", lst, "");

      assertEquals("B", lst.removeLast());
      check("A", lst, "Removing last, yielding non-empty list");
      assertEquals("A", lst.removeLast());
      check("", lst, "Removing last, yielding empty list");

      lst = new DoubleLinkedList();
      lst.addLast("A"); 
      lst.addLast("B"); 
      lst.addLast("C"); 
      check("ABC", lst, "");      

      ListIterator iter = lst.listIterator();
      assertEquals("A", iter.next());
      iter.set("D");
      check("DBC", lst, "Set element after next");
      assertEquals("D", iter.previous());
      iter.set("E");
      check("EBC", lst, "Set first element after previous");
      assertEquals("E", iter.next());
      assertEquals("B", iter.next());
      assertEquals("B", iter.previous());
      iter.set("F");
      check("EFC", lst, "Set second element after previous");      
      assertEquals("F", iter.next());
      assertEquals("C", iter.next());
      assertEquals("C", iter.previous());
      iter.set("G");
      check("EFG", lst, "Set last element after previous");      

      lst = new DoubleLinkedList();
      lst.addLast("A"); 
      lst.addLast("B"); 
      lst.addLast("C"); 
      lst.addLast("D"); 
      lst.addLast("E"); 
      check("ABCDE", lst, "");      
      iter = lst.listIterator();
      assertEquals("A", iter.next());
      iter.remove();
      check("BCDE", lst, "Remove first element after next");
      assertEquals("B", iter.next());
      assertEquals("C", iter.next());
      iter.remove();
      check("BDE", lst, "Remove middle element after next");
      assertEquals("D", iter.next());
      assertEquals("E", iter.next());
      iter.remove();
      check("BD", lst, "Remove last element after next");
      
      lst = new DoubleLinkedList();
      lst.addLast("A"); 
      lst.addLast("B"); 
      lst.addLast("C"); 
      lst.addLast("D"); 
      lst.addLast("E"); 
      check("ABCDE", lst, "");      
      iter = lst.listIterator();
      assertEquals("A", iter.next());
      assertEquals("B", iter.next());
      assertEquals("C", iter.next());
      assertEquals("D", iter.next());
      assertEquals("E", iter.next());
      assertEquals("E", iter.previous());
      iter.remove();
      check("ABCD", lst, "Remove last element after previous");
      assertEquals("D", iter.previous());
      assertEquals("C", iter.previous());
      iter.remove();
      check("ABD", lst, "Remove middle element after previous");
      assertEquals("B", iter.previous());
      assertEquals("A", iter.previous());
      iter.remove();
      check("BD", lst, "Remove first element after previous");

      lst = new DoubleLinkedList();
      lst.addLast("B"); 
      lst.addLast("C"); 
      check("BC", lst, "");      
      iter = lst.listIterator();
      iter.add("A");
      check("ABC", lst, "Add first element");
      assertEquals("B", iter.next());
      iter.add("D");
      check("ABDC", lst, "Add middle element");
      assertEquals("C", iter.next());
      iter.add("E");
      check("ABDCE", lst, "Add last element");      
   }

   /**
      Checks whether two objects are equal and throws an exception if not.
      @param expected the expected value
      @param actual the actual value
   */
   public static void assertEquals(Object expected, Object actual)
   {
      if (expected == null && actual != null ||
         !expected.equals(actual))
      {
         throw new AssertionError("Expected " + expected + " but found " + actual);
      }
   }

   /**
      Checks whether a linked list has the expected contents, and throws
      an exception if not.
      @param expected the letters that are expected in each node
      @param actual the linked list
      @param what a string explaining what has been tested. It is 
      included in the message that is displayed when the test passes.
   */
   public static void check(String expected, DoubleLinkedList actual, String what)
   {
      int n = expected.length();
      if (n > 0)
      {
         // Check first and last reference       
         assertEquals(expected.substring(0, 1), actual.getFirst());
         assertEquals(expected.substring(n - 1), actual.getLast());

         // Check next references
         ListIterator iter = actual.listIterator();
         for (int i = 0; i < n; i++)
         {
            assertEquals(true, iter.hasNext());
            assertEquals(expected.substring(i, i + 1), iter.next());
         }
         assertEquals(false, iter.hasNext());

         // Check previous references
         for (int i = n - 1 ; i >= 0; i--)
         {
            assertEquals(true, iter.hasPrevious());
            assertEquals(expected.substring(i, i + 1), iter.previous());
         }
         assertEquals(false, iter.hasPrevious());
      }
      else
      {
         // Check that first and last are null
         try
         {
            actual.getFirst();
            throw new IllegalStateException("first not null");
         }
         catch (NoSuchElementException ex) 
         {
         }

         try
         {
            actual.getLast();
            throw new IllegalStateException("last not null");
         }
         catch (NoSuchElementException ex)
         {
         }                
      }
      if (what.length() > 0)
      {
         System.out.println("Passed \"" + what + "\"."); 
      }
   }    
}
