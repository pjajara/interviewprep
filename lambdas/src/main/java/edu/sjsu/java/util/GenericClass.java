package edu.sjsu.java.util;

public class GenericClass<T> {
	
	private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t){
		this.t = t;
	}

	public static void main(String[] args) {

		GenericClass<String> type = new GenericClass<>();
		type.set("Paawan");
		type.set("PK");
		
		GenericClass type1 = new GenericClass();
		type1.set("Pawankumar Jajara");
		type1.set(new Integer(5));
	}

}
