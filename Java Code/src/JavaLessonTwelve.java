// The LinkedList class is a collection based on a Linked List
// instead of an array. They are particularly good when you
// expect to perform many additions and deletions with a 
// collection. When using a linked list you don't have to 
// move items around when you add or delete an item. They 
// aren't particularly suited to providing access based off
// of index searches like an array though. Each object in a
// linked list contains a pointer to the objects that proceed
// and follow it.
// When you change an ArrayList a new array is created by it.

import java.util.Arrays;
import java.util.LinkedList; // LinkedList Library methods

public class JavaLessonTwelve {
	
	public static void main(String[] args){
		
		// Creates a LinkedList object
		LinkedList linkedListOne = new LinkedList();
		
		// Creates a LinkedList that contains Strings
		LinkedList<String> names = new LinkedList<String>();
		
		// You use add to add items to the Linked List
		names.add("Ahmed Bennani");
		names.add("Ali Syed");
		
		// addLast places the object last in the list
		names.addLast("Nathan Martin");
		
		// addLast places the object first in the list
		names.addFirst("Joshua Smith");
		
		// You can define what position to place the object in
		names.add(0, "Noah Peeters");
		
		// You replace a value in an index with set()
		names.set(2, "Paul Newman");
		
		// You remove items either by providing the index, or 
		// the value
		names.remove(4);
		names.remove("Joshua Smith");
		
		// removeFirst() removes the first element
		// removeLast() removes the last element
		// removeFirstOccurrence(Object) removes the  
		// first Object that matches what you passed
		
		// You can use the enhanced for to print them out
		for(String name : names)
		{
			System.out.println(name);
		}
		
		/* OUTPUT
		 * Noah Peeters
		 * Paul Newman
		 * Ali Syed
		 */
		
		// You can retrieve values with get()
		System.out.println("\nFirst Index: " + names.get(0));
		
		/* OUTPUT
		 * First Index: Noah Peeters
		 */
		
		// Retrieve the first value with getFirst()
		System.out.println("\nFirst Index: " + names.getFirst());
		
		/* OUTPUT
		 * First Index: Noah Peeters
		 */
		
		// Retrieve the first value with getFirst()
		System.out.println("\nLast Index: " + names.getLast());
		
		/* OUTPUT
		 * Last Index: Ali Syed
		 */
		
		LinkedList<String> nameCopy = new LinkedList<String>(names);
		
		// When you print out the LinkedList itself the toString
		// method is called
		System.out.println("\nnameCopy: " + nameCopy);
		
		/* OUTPUT
		 * nameCopy: [Noah Peeters, Paul Newman, Ali Syed]
		 */
		
		// You can check if an object is in the list with contains()
		if(names.contains("Noah Peeters"))
		{
			System.out.println("\nNoahs Here");
		}
		
		/* OUTPUT
		 * Noahs Here
		 */
		
		// You can check if everything in one list is in another
		if(names.containsAll(nameCopy))
		{
			System.out.println("\nCollections are the same");
		}
		
		/* OUTPUT
		 * Collections are the same
		 */
		
		// Return the index for an object with indexOf
		System.out.println("\nIndex of Ali is: " + names.indexOf("Ali Syed"));
		
		/* OUTPUT
		 * Index of Ali is: 2
		 */
		
		// Check if a list is empty with isEmpty()
		System.out.println("List Empty: " + names.isEmpty());
		
		/* OUTPUT
		 * List Empty: false
		 */
		
		// Get the number of items in the list with size
		System.out.println("How many values: " + names.size());
		
		/* OUTPUT
		 * How many values: 3
		 */
		
		// peek() retrieves the first element, but doesn't throw an error 
		// if there is no element to retrieve
		System.out.println("Look without error: " + names.peek());
		
		/* OUTPUT
		 * Look without error: Noah Peeters
		 */
		
		// poll() returns the first value and deletes it from the list
		System.out.println("Remove first element: " + nameCopy.poll());
		
		/* OUTPUT
		 * Remove first element: Noah Peeters
		 */
		
		// poll() returns the last value and deletes it from the list
		System.out.println("Remove last element: " + nameCopy.pollLast());
		
		/* OUTPUT
		 * Remove last element: Ali Syed
		 */
		
		// push puts a new element on the front of the list
		nameCopy.push("Noah Peeters");
		
		// pop removes an element on the front of the list
		nameCopy.pop();
		
		System.out.println("\nnameCopy: " + nameCopy);
		
		/* OUTPUT
		 * nameCopy: [Paul Newman]
		 */
		
		// Create a new array to hold values from the Linked List
		Object[] nameArray = new Object[4];
		
		// toArray converts the LinkedList into an array of objects
		nameArray = names.toArray();
		
		// toString converts items in the array into a String
		System.out.println(Arrays.toString(nameArray));
		
		/* OUTPUT
		 * [Noah Peeters, Paul Newman, Ali Syed]
		 */
		
		// clear() deletes everything in the Linked List
		names.clear();
		
		
	}
	
}