package edu.sjsu.java.anoop;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashSet 
{
    private Node[] buckets;
    private int currentSize;
    
    public HashSet(int size)
    {
        buckets = new Node[size];
        currentSize = 0;
    }
    
    public int size()
    {
        return currentSize;
    }
    
    public boolean contain(Object element)
    {
        int h = element.hashCode();
        if(h < 0) h = -h;
        h = h % buckets.length;
        Node current = buckets[h];
        while(current != null)
        {
            if(current.data.equals(element))
                return true;
            current = current.next;
        }
        return false;
    }
    
    public boolean add(Object element)
    {
        int h = element.hashCode();
        if(h < 0) h = -h;
        h = h % buckets.length;
        Node current = buckets[h];
        while(current != null)
        {
            if(current.data.equals(element)) return false;
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = buckets[h];
        buckets[h] = newNode;
        currentSize++;
        return true;
    }
    
    public boolean remove(Object element)
    {
        int h = element.hashCode();
        if(h < 0) h = -h;
        h = h % buckets.length;
        Node current = buckets[h];
        Node previous = null;
        while(current != null)
        {
            if(current.data.equals(element))
            {
                if(previous == null)
                    buckets[h] = current.next;
                else
                    previous.next = current.next;
                currentSize--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
    
    class Node 
    {
        public Object data;
        public Node next;
    }
    
    class HashIterator implements Iterator
    {
        private Node current;
        private int bucket;
        
        public HashIterator()
        {
            bucket = -1;
            current = null;
        }
        
        public boolean hasNext()
        {
            if(current != null && current.next != null)
                return true;
            for(int i=bucket+1;i<buckets.length;i++)
                if(buckets[i] != null) return true;
            return false;
        }
        
        public Object next()
        {
            if(current != null && current.next != null)
                current = current.next;
            else
            {
                do
                {
                    bucket++;
                    if(bucket == buckets.length) throw new NoSuchElementException();
                    current = buckets[bucket];
                } while(current == null);
            }
            return current.data;
        }
        
        public void remove()
        {
            
        }
        
    }
        public Iterator iterator()
        {
            return new HashIterator();
        }
    
    
    public static void main(String[] args)
    {
        HashSet names = new HashSet(101);

        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");
        names.add("Eve");
        names.add("Sarah");
        names.add("Adam");
        names.add("Tony");
        names.add("Katherine");
        names.add("Juliet");
        names.add("Romeo");
        names.add("Romeo");
        //names.remove("Romeo");
        //names.remove("George");

        Iterator    iter = names.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
}
