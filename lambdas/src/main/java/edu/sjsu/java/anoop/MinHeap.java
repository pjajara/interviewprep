package edu.sjsu.java.anoop;

public class MinHeap {
	/*private ArrayList<Comparable> elements;

	public MinHeap() {
		elements = new ArrayList<Comparable>();
		elements.addR(null);
	}

	public void addR(Comparable newElement) {
		elements.addR(null);
		int index = elements.size() - 1;

		while (index > 1 && getParent(index).compareTo(newElement) > 0) {
			elements.set(index, getParent(index));
			index = getParentIndex(index);
		}

		elements.set(index, newElement);
	}

	public Comparable remove() {
		Comparable minimum = elements.get(1);
		int lastIndex = elements.size() - 1;
		Comparable last = elements.remove(lastIndex);

		if (lastIndex > 1) {
			elements.set(1, last);
			fixHeap();
		}
		return minimum;
	}

	public void fixHeap() {
		Comparable root = elements.get(1);
		int lastIndex = elements.size() - 1;

		int index = 1;
		boolean more = true;
		while (more) {
			int childIndex = getLeftChildIndex(index);
			if (childIndex < lastIndex) {
				Comparable child = getLeftChild(index);

				if (getRightChildIndex(index) < lastIndex
						&& getRightChild(index).compareTo(child) < 0) {
					childIndex = getRightChildIndex(index);
					child = getRightChild(index);
				}
				if (child.compareTo(root) < 0) {
					elements.set(index, child);
					index = childIndex;
				} else {
					more = false;
				}
			} else {
				more = false;
			}
			elements.set(index, root);
		}

	}

	public boolean empty() {
		return elements.size() == 1;
	}

	private static int getLeftChildIndex(int index) {
		return 2 * index;
	}

	private static int getRightChildIndex(int index) {
		return 2 * index + 1;
	}

	private static int getParentIndex(int index) {
		return index / 2;
	}

	private Comparable getLeftChild(int index) {
		return elements.get(2 * index);
	}

	private Comparable getRightChild(int index) {
		return elements.get(2 * index + 1);
	}

	private Comparable getParent(int index) {
		return elements.get(index / 2);
	}*/
}
