package edu.sjsu.java.list;

import java.util.Arrays;

public class ArrayList<T> {

	private int size = 0;
	private static final int DEFAULT_LIST_SIZE = 10;
	Object[] elements;

	public ArrayList() {
		elements = new Object[DEFAULT_LIST_SIZE];
	}
	
	public ArrayList(int size){
		elements= new Object[size];
	}

	public void add(T t) {
		if (size == elements.length) {
			increaseCapacity();
		}
		elements[size++] = t;
	}

	@SuppressWarnings({ "unchecked" })
	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (T) elements[index];
	}
	
	public void remove(int index){
		if(index <0 || index>=size){
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i=index; i< size; i++){
			elements[i] = elements[i+1];
		}
		size--;
	}

	private void increaseCapacity() {
		int newLength = size * 2;
		elements = Arrays.copyOf(elements, newLength);
	}
	
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		list.add("PK");
		list.add("Jajara");
		list.add("Varun");
		list.add("Jajara");
		list.add("Jass");
		list.add("PK");
		list.add("Jajara");
		list.add("Varun");
		list.add("Jajara");
		list.add("Jass");
		list.add("Error");
		list.remove(10);
		list.remove(1);

		for (int i=0; i<list.size;i++)
		System.out.println(list.get(i));
	}

}
