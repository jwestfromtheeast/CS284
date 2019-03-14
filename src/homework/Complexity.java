// CS 284 AUTHOR: Justin Westley
// I pledge my honor that I have abided by the Stevens Honor System.

package homework;

public class Complexity {

	/**
	 * Method with time complexity O(n^2). Prints approximately n^2 times
	 * @param n input for testing time complexity
	 */
	public static void cpx1(int n) {
		int counter = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}
	
	/**
	 * Method with time complexity O(n^4). Prints approximately n^4 times
	 * @param n input for testing time complexity
	 */
	public static void cpx2(int n) {
		int counter = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					for(int l = 0; l < n; l++) {
						System.out.println("Operation " + counter);
						counter++;
					}
				}
			}
		}
	}

	/**
	 * Method with time complexity O(logn)
	 * @param n input for testing time complexity
	 */
	public static void cpx3(int n) {
		int counter = 1;
		for(int i = 1; i < n; i *= 2) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	/**
	 * Method with time complexity O(nlogn)
	 * @param n input for testing time complexity
	 */
	public static void cpx4(int n) {
		int counter = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j*= 2) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	/**
	 * Method with time complexity O(loglogn)
	 * @param n input for testing time complexity
	 */
	public static void cpx5(int n) {
		int counter = 1;
		for(int i = 2; i < n; i *= i) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	/**
	 * Method with time complexity O(2^n). Returns the number of the
	 * Fibonacci sequence equal to n.
	 * @param n Fibonacci index to find
	 */
	public static int cpx6(int n) {
		if(n <= 1) {
			return n;
		}
		return cpx6(n - 1) + cpx6(n - 2);
	}
	
}
