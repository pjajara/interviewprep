package edu.sjsu.java.anoop;

public class sds {

	public static void main(String[] args) {
		HashSet names = new HashSet(101);

		names.add("Harry");
		names.add("Sue");
		names.add("Nina");
		names.add("Susannah");
		names.add("Larry");
		names.add("Eve");
		names.add("Sarah");
		names.add("Adam");
		names.add("Tony");
		names.add("Katherine");
		names.add("Juliet");
		names.add("Romeo");
		names.remove("Romeo");
		names.remove("George");

		/*HashSet.HashSetIterator iter = names.new HashSetIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}*/
	}

}
