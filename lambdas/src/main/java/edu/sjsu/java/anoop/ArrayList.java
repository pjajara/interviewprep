package edu.sjsu.java.anoop;

public class ArrayList<T> {

    private Object[] array;
    private int size;

    public ArrayList() {
        this.size = 0;
        array = new Object[10];
    }

    public ArrayList(int arraySize) {
        this.size = 0;
        array = new Object[arraySize];
    }

    public int size() {
        return this.size;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object get(int index) {
        checkBounds(index);
        return array[index];
    }

    public void add(int index, T t) {
        checkBounds(index);
        array[index] = t;
    }

    public Object remove(int index) {
        checkBounds(index);
        Object removed = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;

        return removed;
    }

    public boolean addLast(Object element) {
        growIfNecessary();
        array[size] = element;
        size++;
        return true;
    }

    public void growIfNecessary() {
        if (size == array.length) {
            Object[] newBuffer = new Object[2 * array.length];
            for (int i = 0; i < array.length; i++) {
                newBuffer[i] = array[i];
            }
            array = newBuffer;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(2);
        list.addLast(1);
        System.out.println(list.size());
        list.addLast(2);
        System.out.println(list.size());
        list.addLast(3);
        System.out.println(list.size());
        list.addLast(4);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(6);
        System.out.println(list.size());
        list.addLast(88);
        list.remove(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "->");
        }
    }
}
