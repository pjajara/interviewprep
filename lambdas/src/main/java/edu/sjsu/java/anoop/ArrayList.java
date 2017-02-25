package edu.sjsu.java.anoop;

public class ArrayList<T> {

	private Object[] array;
	private int size;

	public ArrayList() {
		size = 0;
		array = new Object[10];
	}
	
	public ArrayList(int size) {
		this.size = size;
		array = new Object[size];
	}

	public int size() {
		return size;
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
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.addLast(1);
		al.addLast(2);
		al.addLast(3);
		al.addLast(4);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(6);
		al.addLast(88);
		al.remove(al.size() - 1);
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + "->");
		}
	}
}
