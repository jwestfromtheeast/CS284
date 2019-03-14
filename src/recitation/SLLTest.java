package recitation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SLLTest {
	
	// IMPORTANT!!!!!!!!!!!!!!!
	// change the visibility of every method in "SLL" from private to public
	
	@Test
	void test_insertAt() {
		SLL<String> l1 = new SLL<String>();
		l1.append("a");
		l1.append("b");
		l1.append("c");
		l1.append("d");
		l1.append("e");
		l1.insertAt("xd", 3);
		// should be ["a","b","c","xd","d","e"]
		assertEquals("xd", l1.getValByIndex(3));
		assertEquals("d", l1.getValByIndex(4));
	}
	
	@Test
	void test_removeAt() {
		SLL<String> l2 = new SLL<String>();
		l2.append("a");
		l2.append("b");
		l2.append("c");
		l2.append("xd");
		l2.append("d");
		l2.append("e");
		l2.removeAt(5);
		// should be ["a","b","c","xd","d"]
		l2.removeAt(0);
		// should be ["b","c","xd","d"]
		l2.removeAt(1);
		// should be ["b","xd","d"]
		assertEquals("b", l2.getValByIndex(0));
		assertEquals("xd", l2.getValByIndex(1));
		assertEquals("d", l2.getValByIndex(2));
	}

	@Test
	void test_removeDup() {
		SLL<String> l3 = new SLL<String>();
		l3.append("A");
		l3.append("A");
		l3.append("B");
		l3.append("B");
		l3.append("A");
		l3.append("B");
		l3.append("B");
		l3.append("A");
		l3.append("A");
		l3.removeDup();
		// should be ["A","B"]
		// Note: depending on your implementation, the result of removeDup could also be
		//			["B","A"]
		// 			order doesn't matter
		assertEquals("A", l3.getValByIndex(0));
		assertEquals("B", l3.getValByIndex(1));
	}
	
	@Test
	void test_multiply() {
		SLL<String> l4 = new SLL<String>();
		l4.append("1");
		l4.append("2");
		l4.append("3");
		l4.multiply(3);
		// should be ["1","1","1","2","2","2","3","3","3"]
		assertEquals("1", l4.getValByIndex(0));
		assertEquals("1", l4.getValByIndex(1));
		assertEquals("1", l4.getValByIndex(2));
		assertEquals("2", l4.getValByIndex(3));
		assertEquals("2", l4.getValByIndex(4));
		assertEquals("2", l4.getValByIndex(5));
		assertEquals("3", l4.getValByIndex(6));
		assertEquals("3", l4.getValByIndex(7));
		assertEquals("3", l4.getValByIndex(8));
		
		SLL<String> l5 = new SLL<String>();
		l5.append("1");
		l5.append("2");
		l5.append("3");
		l5.multiply(1);
		assertEquals("1", l5.getValByIndex(0));
		assertEquals("2", l5.getValByIndex(1));
		assertEquals("3", l5.getValByIndex(2));
	}
	
}
