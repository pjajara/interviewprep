package edu.sjsu.java.anoop;

import java.util.NoSuchElementException;


public class CircularArrayQueue 
{
    private Object[] buffer;
    private int currentSize;
    private int head, tail;
    
    public CircularArrayQueue()
    {
        currentSize = 0;
        buffer = new Object[10];
        head = 0;
        tail = 0;
    }
    
    public int size()
    {
        return currentSize;
    }

    public Object remove()
    {
        if(currentSize == 0) throw new NoSuchElementException();
        Object removed = buffer[head];
        head = (head+1) % buffer.length;
        currentSize--;
        return removed;
    }
    
    public void add(Object element)
    {
        growIfNecessary();
        buffer[tail] = element;
        tail = (tail+1) % buffer.length;
        currentSize++;
    }
    
    public void growIfNecessary()
    {
        if(currentSize == buffer.length)
        {
            Object[] newBuffer = new Object[2 * buffer.length];
            for(int i=0;i<buffer.length;i++)
                newBuffer[i] = buffer[(head+i)%buffer.length];
            buffer = newBuffer;
            head = 0;
            tail = currentSize;
        }
    }    
    
    
    public static void main(String[] args)
    {
        CircularArrayQueue al = new CircularArrayQueue();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);
        al.add(10);
        al.add(11);
        al.add(12);
        al.add(13);
        //al.remove();
        int size = al.size();
        for(int i=0;i<size-6;i++)
            System.out.print(al.remove() + "->");
    }      
}
