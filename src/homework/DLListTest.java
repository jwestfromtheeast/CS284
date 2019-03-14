// CS 284 AUTHOR: Justin Westley

package homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DLListTest {
	
	//Testing each method
	
	@Test
	void test_add() {
		DLList<String> sicko = new DLList<String>();
		sicko.add("bamba");
		sicko.add("mo");
		sicko.add("or");
		sicko.add("mode");
		sicko.add(0, "meme");
		sicko.add(5, "ASDF");
		sicko.add(5, "sheck wes");
		assertEquals("mode", sicko.get(1));
		assertEquals("or", sicko.get(2));
		assertEquals("mo", sicko.get(3));
		assertEquals("bamba", sicko.get(4));
		assertEquals("sheck wes", sicko.get(5));
	}
	
	@Test
	void test_append() {
		DLList<String> what = new DLList<String>();
		what.append("hehe");
		what.append("xd");
		what.append("third");
		assertEquals("hehe", what.get(0));
		assertEquals("xd", what.get(1));
		assertEquals("third", what.get(2));
	}
	
	@Test
	void test_get_size() {
		DLList<String> sicko = new DLList<String>();
		sicko.add("bamba");
		sicko.add("mo");
		sicko.add("or");
		sicko.add("mode");
		assertEquals("mode", sicko.getHead());
		assertEquals("or", sicko.get(1));
		assertEquals("mo", sicko.get(2));
		assertEquals("bamba", sicko.getLast());
	}
	
	@Test
	void test_remove() {
		DLList<String> sicko = new DLList<String>();
		sicko.add("bamba"); // mode, or, bamba, does
		sicko.add("mo");
		sicko.add("or");
		sicko.add("mode");
		sicko.add("filler");
		sicko.add("more filler");
		sicko.append("does an empty string count?");
		sicko.append("let's find out");
		sicko.append("");
		assertEquals("more filler", sicko.removeAt(0));
		assertEquals("", sicko.removeAt(7));
		assertEquals("let's find out", sicko.removeLast());
		assertEquals("filler", sicko.remove());
		assertEquals("mo", sicko.removeAt(2));
		assertEquals("does an empty string count?", sicko.get(3));
		assertEquals("mode", sicko.get(0));
	}
	
	@Test
	void test_removeFind() {
		DLList<String> sicko = new DLList<String>();
		sicko.add("bamba");
		sicko.add("mo");
		sicko.add("or");
		sicko.add("mode");
		sicko.append("irony");
		assertEquals(true, sicko.remove("mode"));
		assertEquals(false, sicko.remove("sheck wes"));
		assertEquals(true, sicko.remove("irony"));
		assertEquals("bamba", sicko.getLast());
	}
	
	@Test
	void test_toString() {
		DLList<String> sicko = new DLList<String>();
		sicko.add("bamba");
		sicko.add("mo");
		sicko.add("or");
		sicko.add("mode");
		sicko.add("sicko");
		assertEquals("[sicko <--> mode <--> or <--> mo <--> bamba]", sicko.toString());
	}
	
}
