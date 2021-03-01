package com.chandu.java.collections.List;

import java.util.ArrayList;
import java.util.Iterator;

/*ArrayList is implementation of list interface.
ArrayList is not synchronized (so not thread safe)
ArrayList is implemented using array as internal data structure.
It can be dynamically resized .
ArrayList increases half of its size when its size is increased.
*/

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> employee = new ArrayList<>();
		
		// add( Object o): This method adds an object o to end of the arraylist.
		employee.add("Chandu");
		employee.add("Dada");
		employee.add("Sachin");
		employee.add("Kalyan");
		employee.add("Virat");

		// add(int index, Object o): This adds the object o to the arraylist at the
		// specified index.
		employee.add(4, "Rohit");

		// Object get(int index): It returns the object of list which is present at the
		// specified index.
		String str = employee.get(1);

		// remove(Object o): Removes the object o from the ArrayList.
		employee.remove("Kalyan");

		// remove(int index): Removes element which is present at specified index
		employee.remove(4);

		// set(int index, Object o): It is mainly used for updating an element. It
		// replaces the element present at the specified index with the object o.
		employee.set(0, "Rahul");

		// int indexOf(Object o): It is used to find index of object o. If object is not
		// present, this method returns -1
		int index = employee.indexOf("Sachin");
		System.out.println("Index of Sachin:" + index);

		// int size(): It gives the size of the ArrayList
		int size = employee.size();
		System.out.println("The size of the ArrayList:" + size);

		// boolean contains(Object o): It checks whether the given object o is present
		// in the ArrayList or not. If not present, it returns false
		boolean contains = employee.contains("Rahul");
		System.out.println("The contains method value:" + contains);

		// clear()
		// It will remove all the object of ArrayList, so above statement will remove
		// all String object from employee
		// employee.clear();

		// addAll(Collection c) - If you want to merge two ArrayList, you can use this
		// method.

		ArrayList<String> otherList = new ArrayList<>();

		otherList.add("abc");
		otherList.add("xyz");

		// addAll(Collection c) If you want to merge two ArrayList, you can use this
		// method.
		employee.addAll(otherList);
		
		// removeAll(Collection c) If you want to remove list of elements which is
		// present in other list, you can use this method.
		// employee.removeAll(otherList);
		
		// retainAll(Collection) If you want to retain only those elements which are
		// present in Collection, you can use this method.
		// employee.retainAll(otherList);
		
		
		System.out.println("Employee List is as follows: ");

		System.out.println("Iterating through For-Each loop");
		// Iterating through the ArrayList using for-each loop
		for (String empname : employee) {
			System.out.println(empname);
		}
		// Iterating through the ArrayList using Iterator

		System.out.println("Iterating through Itertor: ");

		Iterator iter = employee.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
