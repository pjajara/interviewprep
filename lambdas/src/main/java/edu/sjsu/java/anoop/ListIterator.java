package edu.sjsu.java.anoop;

public interface ListIterator {
    
    Object next();
    boolean hasNext();
    Object previous();
    boolean hasPrevious();
    void add(Object element);
    void remove();
    void set(Object element);
}
