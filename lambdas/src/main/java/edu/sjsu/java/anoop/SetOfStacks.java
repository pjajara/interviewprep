package edu.sjsu.java.anoop;

import java.util.ArrayList;

public class SetOfStacks 
{
    public int capacity;
    public ArrayList<CustomStack> stacks = new ArrayList<CustomStack>();
    
    public CustomStack getLastStack()
    {
        if(stacks.isEmpty())
            return null;
        else
            return stacks.get(stacks.size()-1);
    }
    
    public void push(int value)
    {
        CustomStack stack = getLastStack();
        if(stack == null || stack.isFull())
        {
            stack = new CustomStack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
        else
        {
            stack.push(value);
        }
    }
    
    public int pop()
    {
        CustomStack stack = getLastStack();
        if(stack == null) return -1;
        int value = stack.pop();
        if(stack.isEmpty())
            stacks.remove(stacks.size()-1);
        return value;
    }
    
    public int popAt(int index)
    {
        return rearrangeStack(index, true);
    }

    public int rearrangeStack(int index, boolean removeTop)
    {
        CustomStack stack = getLastStack();
        if(stack == null) return -1;
        int value = -1;
        if(removeTop)
            value = stack.pop();
        else
            value = stack.removeBottom();
        return value;
    }
}

class CustomStack
{
    private int capacity;
    public int size;
    public Node top, bottom;
    
    public CustomStack(int capacity)
    {
        this.capacity = capacity;
    }
    
    public boolean isFull()
    {
        return size == capacity;
    }
    
    public int removeBottom()
    {
        int value = bottom.data;
        bottom = bottom.below;
        size--;
        return value;
    }
    
    public void join(Node above, Node below)
    {
        if(above != null)
            above.below = below;
        if(below != null)
            below.above = above;
    }
    
    public int pop()
    {
        int value = top.data;
        top = top.below;
        size--;
        return value;
    }
    
    public boolean push(int value)
    {
        if(size >= capacity) return false;
        size++;
        Node newNode = new Node(value);
        if(size == 1)
            bottom = newNode;
        join(newNode, top);
        top = newNode;
        return true;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
}

class Node
{
    public int data;
    public Node above;
    public Node below;
    
    public Node(int value)
    {
        this.data = value;
    }
}
