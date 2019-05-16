package HW5;

// Anthony Orrico 4/29/19
// QuickSort HW5
// I pledge my honor that I have abided by Stevens Honor System

import java.util.*;

public class Sort {
	private static class Interval {
		private int lower;
		private int upper;
		
		public Interval (int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}
		
		public int getLower() {
			return lower;
		}
		
		public int getUpper() {
			return upper;
		}
		
		public boolean equals(Object o) {
			// returns true if this interval and given interval have same upper and lower bounds
			if (o instanceof Interval)
				return (this.lower == ((Interval)o).lower && this.upper == ((Interval)o).upper);
			else
				return false;
		}
		
		public int hashCode() {
			// returns lower + lower + upper
			return lower + lower + upper;
		}
	}
	/**
	* Lamport's Iterative Quick Sort Implementation
	* @param array to be sorted
	*/
	public static <T extends Comparable<T>> void sort (T[] array) {
		Interval total = new Interval(0,array.length-1);		// whole array
		Set<Interval> bounds = new HashSet<Interval>();			// bounds we need to save in sets
		bounds.add(total);  									//add array to list of things to sort
		
		Iterator<Interval> it = bounds.iterator();				// set up Iterator
		while (it.hasNext()) { 									// while there are still bounds in the set
		//	for (int i = 0; i < array.length; i++)
			//	System.out.print(" " + array[i] + ",");
			System.out.println(" ");
			Interval i = it.next();
			int first = i.lower;
			int last = i.upper;
			
			// Nothing to sort
			if (first >= last) {
				bounds.remove(i);
				it = bounds.iterator(); 						// reset iterator
				//System.out.println("Interval is (" + i.lower + ", " + i.upper + ") Nothing to sort");
				continue;
			}
			
			// Only 2 elements in array
			if (last - first == 1) {
				if(array[first].compareTo(array[last]) > 0) { 	// if first > last and array only 2 elements swap
					swap(array,first, last);
				}
				bounds.remove(i);
				it = bounds.iterator(); 						// reset iterator
				//System.out.println("Interval is (" + i.lower + ", " + i.upper + ") Two elements");
				continue;
			}
			
			// Get pivot using median of first, last, mid
			int middle = ((last-first)/2)+first;				// example: 10-8 = 2 / 2 = 1 + 8 = 9
			if(array[first].compareTo(array[middle]) > 0)
				swap(array,first,middle);
			if(array[middle].compareTo(array[last]) > 0)		// end of iteration 1 of bubble sort for size 3
				swap(array,middle,last);
			if(array[first].compareTo(array[middle]) > 0)		// end of bubble sort for median
				swap(array,first,middle);
			
			// Now the median should be at middle of first and last
			if (last - first == 2) {							// if size of array is 3 then should be done
				bounds.remove(i);
				it = bounds.iterator(); 						// reset iterator
				//System.out.println("Interval is (" + i.lower + ", " + i.upper + ") Three elements");
				continue;
			}
			
			// median at middle and array > 3 so do quick sort with pivot and partition
			swap(array, first, middle);							// pivot now at first index
			T pivot = array[first];
			int up = first;
			int down = last;
			do {
				while (up != last && pivot.compareTo(array[up]) >= 0)
					up++;
				while (pivot.compareTo(array[down]) < 0)
					down--;
				if (up < down)
					swap(array, up, down);
			} while(up < down);
			swap(array, down, first);
			bounds.add(new Interval(first,down-1));				// add two new intervals for subarrays
			bounds.add(new Interval(down+1,last));				// created by partitioning
			bounds.remove(i);
			it = bounds.iterator(); 							// reset iterator
			//System.out.println("Interval is (" + i.lower + ", " + i.upper + ") Normal Quick sort");
			continue;
		}
	}
	
	public static<T extends Comparable<T>> void swap(T[] array, int a, int b) {
		T tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	public static void main(String[] args) {
		Integer[] array = {10,9,8,7,6,5,4,3,2,1,0};
		sort(array);
		System.out.print("[");
		for (int i = 0; i < array.length-1; i++)
			System.out.print(" " + array[i] + ",");
		System.out.print(" " + array[array.length-1]);
		System.out.print(" ]\n");
		/*Integer[] list = new Integer[1000];
	    Random random = new Random();
	    for (int i = 0; i < 1000; i++)
	    {
	        list[i] = (random.nextInt(1000));
	    }
	    sort(list);*/
	}
	
}

