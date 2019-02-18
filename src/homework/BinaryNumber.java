// CS 284 AUTHOR: Justin Westley
// I pledge my honor that I have abided by the Stevens Honor System.

package homework;

import java.util.Arrays;

public class BinaryNumber {
	
	private int[] data;
	private boolean overflow = false;
	
	/**
	 * Creates a new binary number with all digits initialized to 0
	 * @param length length of new binary number
	 */
	public BinaryNumber(int length) {
		if(length < 1) {
			System.out.println("Invalid input.");
			data = new int[1];
			data[0] = -1;
			return;
		}
			data = new int[length];
	}
	
	/**
	 * Creates a new binary number equivalent to the given string of 0s and 1s
	 * @param str binary number to be created, 0s and 1s
	 */
	public BinaryNumber(String str) {
		if(str.length() == 0) {
			System.out.println("Invalid input.");
			data = new int[1];
			data[0] = -1;
			return;
		}
		data = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			int next = Character.getNumericValue(str.charAt(i));
			if(next != 0 && next != 1) {
				System.out.println("Invalid input.");
				data[0] = -1;
				return;
			}
			data[i] = next;
		}
	}
	
	/**
	 * Returns the length of a binary number
	 * @return length of the binary number
	 */
	public int getLength() {
		if(data[0] == -1) return -1;
		return data.length;
	}
	
	/**
	 * Obtains the digit of the binary number at the given index
	 * @param index integer index to grab the value of
	 * @return the 0 or 1 of the digit at the index
	 */
	public int getDigit(int index) {
		if(index > -1 && index < data.length) return data[index];
		System.out.println("Invalid index.");
		return -1;
	}
	
	/**
	 * Returns the decimal equivalent integer value of the binary number
	 * @return decimal equivalent of the binary number
	 */
	public int toDecimal() {
		if(data[0] == -1) return -1;
		int sum = data[0], powr = 1;
		for(int i = 1; i < data.length; i++) {
			if(data[i] == 1) sum += Math.pow(2, powr);
			powr++;
		}
		return sum;
	}
	
	/**
	 * Shifts the binary number to the right by the given amount
	 * @param s positive integer amount to shift right by
	 */
	public void shiftRight(int s) {
		if(s < 0) {
			System.out.println("Invalid shift amount.");
			return;
		}
		if(s == 0) return;
		int[] helper = Arrays.copyOf(data, data.length + s);
		for(int i = 0; i < data.length; i++) {
			if(data[i] == 1) {
				helper[i+s] = data[i];
				helper[i] = 0;
			}
		}
		data = helper.clone();
	}
	
	/**
	 * Sums a binary number with another
	 * @param aBinaryNumber Binary number to be added to the one called on
	 */
	public void add(BinaryNumber aBinaryNumber) {
		if(data[0] != -1 && aBinaryNumber.getDigit(0) != -1 && this.getLength() == aBinaryNumber.getLength()) {
			boolean carry = false;
			for(int i = 0; i < this.getLength(); i++) {
				if(data[i] == 1 && aBinaryNumber.getDigit(i) == 1) {
					if(!carry) {
						data[i] = 0;
						carry = true;
					}
				}
				else if(data[i] == 1 && aBinaryNumber.getDigit(i) == 0) {
					if(carry) {
						data[i] = 0;
					}
				}
				else if(data[i] == 0 && aBinaryNumber.getDigit(i) == 1) {
					if(!carry) {
						data[i] = 1;
					}
				}
				else {
					if(carry) {
						data[i] = 1;
						carry = false;
					}
				}
			}
			if(carry) overflow = true;
		}
		else {
			System.out.println("Invalid operation. Lengths are not equal or invalid number.");
		}
	}
	
	/**
	 * Sets the overflow of a binary number to false
	 */
	public void clearOverflow() {
		overflow = false;
	}
	
	/**
	 * @return a String equivalent of the binary number
	 */
	@Override 
	public String toString() {
		if(overflow) return "Overflow";
		String binString = "";
		for(int i : data) {
			binString += i;
		}
		return binString;
	}
	
}
