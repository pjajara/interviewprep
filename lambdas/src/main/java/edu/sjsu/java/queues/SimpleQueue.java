package edu.sjsu.java.queues;

import java.util.NoSuchElementException;

/**
 * Created by pjajara on 2/14/17.
 */
public class SimpleQueue implements Queue {

    private Object[] array;
    private int size = 0;
    private int head =0;
    private int tail=0;

    public SimpleQueue(int initialSize){
        array = new Object[initialSize];
    }

    public SimpleQueue(){
        array = new Object[16];
    }

    public void enqueue(Object item){

        if (size == array.length){
            throw new IllegalStateException("Cannot addR to full queue");
        }

        array[tail] = item;
        tail = (tail + 1 ) % array.length;
        size++;
    }

    public Object dequeue(){

        if(isEmpty()){
            throw new NoSuchElementException("Empty queue");
        }

        Object item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return item;

    }

    public Object peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Empty Queue");
        }
        return array[head];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Queue q = new MySimpleQueue(4);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.dequeue();
        q.enqueue("D");
        q.dequeue();
        q.enqueue("E");
        q.enqueue("F");
    }
}
