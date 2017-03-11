package edu.sjsu.java.todelete;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by pjajara on 2/12/17.
 */
public final class IntStack {

    private int[] arr;
    private int top = -1;
    private int size;

    public IntStack() {
        arr = new int[15];
        size = 15;
    }

    public IntStack(int capacity) {
        arr = new int[capacity];
        this.size = capacity;
    }

    public void push(int data) {
        if (!isFull()) {
            arr[++top] = data;
        } else {
            throw new IllegalStateException("Full IntStack!");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int element = arr[top--];
            if (top >= 0) {
                arr[top] = '0';
            }
            return element;
        } else {
            throw new IllegalStateException("Empty IntStack");
        }
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("arr", arr)
                .append("top", top)
                .append("size", size)
                .toString();
    }
}