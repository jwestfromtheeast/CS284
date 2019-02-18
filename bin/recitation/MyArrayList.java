import java.util.Arrays;

public class MyArrayList<E> {
	/*
	 * What the heck is E??
	 * E is whatever we want it to be when we "make" an instance of our class.
	 * Example: MyArrayList<Integer> intArray = new MyArrayList<Integer>(...);
	 */
	
	
	// Data fields;
	// size of our array when we make it
	private static final int INITIAL_CAPACITY = 10; 
	
	// The actual data
	private E[] theData;
	
	// Actual size of array
	private int size = 0;
	
	// Talk about this later
	private int capacity = 0;
	
	// Constructors
	public MyArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity]; // Just make an array of E
	}
	
	// Methods
	public void add (int index, E anEntry) {
		// check bounds
		if (index < 0 || index >= capacity) {
			throw new ArrayIndexOutOfBoundsException(index); 
			// throw an error!!!
			// You broke everything idiot!!!
		}
		// Make sure there is room
		if (size >= capacity) {
			reallocate(); // we haven't made this yet
		}
		// shift data
		for (int i = size; i > index; i--) {
			theData[i] = theData[i - 1];
		}
		
		// insert item
		theData[index] = anEntry;
		size++;
	}
	
	public E get(int index) {
		// Check for errors
		if (index < 0 || index >= capacity) {
			throw new ArrayIndexOutOfBoundsException(index); 
			// throw an error!!!
			// You broke everything idiot!!!
		}
		return theData[index];
	}
	
	public E set(int index, E newValue) {
		if (index < 0 || index >= capacity) {
			throw new ArrayIndexOutOfBoundsException(index); 
			// throw an error!!!
			// You broke everything idiot!!!
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= capacity) {
			throw new ArrayIndexOutOfBoundsException(index); 
			// throw an error!!!
			// You broke everything idiot!!!
		}
		
		E returnValue = theData[index];
		for (int i = index; i < size - 1; i++) {
			theData[i] = theData[i+1];
		}
		size--;
		return returnValue;
	}
	
	// Make our array bigger
	private void reallocate() {
		int oldcapacity = capacity;
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
		//System.out.println("Reallocating space. Old capacity is " + oldcapacity + " New Capacity is " + capacity);
	}
	
	public void concatenate(MyArrayList<E> newarry) {
		//TODO write this if you want to practice...
	}
	
	public String toString() {
		String s = "[";
		for (int i = 0; i < size; i++) {
			s += theData[i].toString();
			if (i != size - 1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	
	public static void main(String[] args) {
		// make a new arraylist
		MyArrayList<Integer> arr = new MyArrayList();
		arr.add(0, 2);
		arr.add(1, 3);
		arr.add(2, 4);
		System.out.println("First Array: " + arr);
		arr.add(0, 1); // Add at head
		System.out.println("Second Array: " + arr);
		arr.remove(1); // Remove Second item in list
		System.out.println("Third Array: " + arr);
		// Add more stuff, notice our array is now larger then INITIAL_CAPACITY, so we end up reallocating space
		for(int i = 0; i < 10; i++) {
			arr.add(i, i);
		}
		// TODO go and uncomment the print line inside reallocate to see when we reallocate more space.
		System.out.println("Fourth Array: " + arr);
		
		/*
		 * Exercise Idea: Try creating a concatenate method. Which takes in an array of E, 
		 * and adds that to the end of your current array.
		 * Method declaration: public void concatenate(MyArrayList<E> newarray) {...}
		 * Example of use bellow.
		 */
//		MyArrayList<Integer> list1 = new MyArrayList();
//		list1.add(0,0);
//		list1.add(1, 1);
//		System.out.println("List1 is " + list1);
//		MyArrayList<Integer> list2 = new MyArrayList();
//		list2.add(0,2);
//		list2.add(1,3);
//		System.out.println("List2 is " + list2);
//		list1.concatenate(list2);
//		System.out.println("List1 now is " + list1);
		
	}
}
