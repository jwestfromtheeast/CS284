// CS 284 AUTHOR: Justin Westley
// I pledge my honor that I have abided by the Stevens Honor System.

package homework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HuffmanTest {
	
	//Testing each method
	
	// Test good values
	@Test
	void test_pass() {
		String s = "some string you want to encodeb!/?";
		String abc = "abc";
		HuffmanTree t = new HuffmanTree(s);
		Boolean[] mo = t.encode(abc);
		Boolean[] bamba = t.efficientEncode(abc);
		String sheck = t.decode(mo);
		String wes = t.decode(bamba);
		assertEquals(abc, sheck);
		assertEquals(abc, wes);
	}
	
	// Test some more good values
	@Test
	void test_pass2() {
		String s = "some string you want to encodeb!/?";
		String a = "aaaaa";
		HuffmanTree t = new HuffmanTree(s);
		Boolean[] mo = t.encode(a);
		Boolean[] bamba = t.efficientEncode(a);
		String sheck = t.decode(mo);
		String wes = t.decode(bamba);
		assertEquals(a, sheck);
		assertEquals(a, wes);
	}
	
	// Test each IllegalArgumentException will throw when triggered
	@Test
	void test_fail() {
		String s = "some string you want to encodeb!/?";
		String sleepy = "zzz";
		Boolean[] bad = {false};
		Boolean[] badder = {};
		HuffmanTree t = new HuffmanTree(s);
		assertThrows(IllegalArgumentException.class, () -> t.efficientEncode(sleepy));
		assertThrows(IllegalArgumentException.class, () -> t.encode(sleepy));
		assertThrows(IllegalArgumentException.class, () -> t.decode(bad));
		assertThrows(IllegalArgumentException.class, () -> t.decode(badder));
		assertThrows(IllegalArgumentException.class, () -> t.efficientEncode(""));
		assertThrows(IllegalArgumentException.class, () -> t.encode(""));
	}
	
}
