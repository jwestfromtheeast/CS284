// CS 284 AUTHOR: Justin Westley

package homework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class SortTest {

	// Test good values
	@Test
	void int_pass() {
		int size = 10000;
		Integer[] list1 = new Integer[size];
		Integer[] list2 = new Integer[size];
		Random rand = new Random();
		for(int i = 0; i < size; i ++) {
			list1[i] = rand.nextInt(1000);
			list2[i] = list1[i];
		}
		Arrays.sort(list1);
		Sort.sort(list2);
		assertEquals(true, Arrays.deepEquals(list1, list2));
	}
	
	@Test
	void edge_cases() {
		Integer[] empty = {};
		Integer[] empty2 = {};
		Sort.sort(empty);
		assertEquals(true, Arrays.deepEquals(empty, empty2));
		Integer[] sorted = {1, 2, 3, 4, 5};
		Integer[] alsoSorted = {1, 2, 3, 4, 5};
		assertEquals(true, Arrays.deepEquals(sorted, alsoSorted));
		Integer[] backwards = {5, 4, 3, 2, 1};
		Integer[] alsoBackwards = {5, 4, 3, 2, 1};
		assertEquals(true, Arrays.deepEquals(backwards, alsoBackwards));
	}
	
	@Test
	void strings() {
		String[] names = {"Justin", "Bobby", "Sheck Wes", "Andy", "Jamie", "Evelynn", "Maria", "Isabella", "Norman", "Ray", "Emma", "Hannah"};
		String[] names2 = {"Justin", "Bobby", "Sheck Wes", "Andy", "Jamie", "Evelynn", "Maria", "Isabella", "Norman", "Ray", "Emma", "Hannah"};
		Arrays.sort(names);
		Sort.sort(names2);
		assertEquals(true, Arrays.deepEquals(names, names2));
	}
		
}
