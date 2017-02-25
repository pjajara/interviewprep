package edu.sjsu.java.garbage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Garbage extends AbstractClass implements Runnable {

	private static int garbageId;
	private static Object o;

	@Override
	public void finalize() {
		Queue q = new PriorityQueue();
	}

	public static void Garbage() throws InterruptedException {
		Stack s = new Stack();
		s.push("123");
		s.push(44);

		List list = new ArrayList();

		list.add("CA");
		list.add("TX");
		list.add("CA");
		list.remove(2);

		Set set = new HashSet(list);
		System.out.println(set.size());
		System.out.println(set);

		List list1 = new ArrayList(set);
		System.out.println(list1);

		String[] arr = new String[list1.size()];
		list1.toArray(arr);

		for (String str : arr) {
			System.out.println(str);
		}
		String str = "This is going to be crazy";
		/*
		 * for (int i = Integer.MIN_VALUE; i< Integer.MAX_VALUE; i++){ str = str
		 * + "f"; System.out.println(str); Thread.sleep(100); }
		 */
		Vector v = new Vector();

		Init init = new Init() {
			public void initialize() {
				System.out.println("Hello World");
			}
		};
	}

	public static void method4(Init i) {
		System.out.println(i);
	}

	public static void removeDuplicates(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		int index = 0, i, j;

		for (i = 0; i < arr1.length; i++) {
			if (!contains(arr, arr1[i])) {
				arr[index++] = arr1[i];
			}
		}

		for (j = 0; j < arr2.length; j++) {
			if (!contains(arr, arr2[j])) {
				arr[index++] = arr2[j];
			}
		}

		for (int a : arr)
			System.out.println(a);
	}

	private static boolean contains(int[] arr, int i) {
		for (int a : arr) {
			if (a == i)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int i = 4;
		Integer myInt = new Integer(i);

		List<? extends Collection> l = new ArrayList<TreeSet>(); // compiles

		gc();
		Garbage g = new Garbage();
		Thread thread1 = new Thread(g);
		thread1.start();
		// Garbage();
		/*
		 * method4(new Init() { public void initialize() {
		 * System.out.println("Hello World"); } });
		 */

		System.out.println(Garbage.value);
		int[] array = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7 };
		int[] array1 = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7 };

		// removeDuplicates(array, array1);

		/*
		 * int array_first[] = {1,2,3,4,5,6,7,8,9,10}; int array_second[] =
		 * {11,12,13,14,15,2,4,1,3,6}; int temp[]= new int[40]; int i,j,k=0; for
		 * (i=0 ;i<array_first.length;i++) { for (j=0;j<array_second.length;j++)
		 * { if (array_first[i] == array_second[j]) { temp[k] = array_first[i];
		 * System.out.print(temp[k]); k++; }
		 * 
		 * } }
		 */

		System.out.println("MyOwnString".indexOf("Own"));

	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method1(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void method2(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void method3(int j) {
		// TODO Auto-generated method stub

	}

	@Override
	public void method4(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void method5(int m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		System.out.println("Hey! I am running in thread");
	}

	public static void gc() {
		Object obj = new Object();
		java.lang.ref.WeakReference ref = new java.lang.ref.WeakReference<Object>(
				obj);
		obj = null;
		while (ref.get() != null) {
			System.out.println("garbage collector");
			System.gc();
		}
	}

}
