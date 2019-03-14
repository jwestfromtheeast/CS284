package recitation;

import java.util.Vector;

public class SLL<E> {
	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		private Node(E value) {
			data = value;
			next = null;
		}
		
		private Node(E value, Node<E> nextNode) {
			data = value;
			next = nextNode;
		}
	}
	// end of nested class

	private Node<E> head;
	private int size;
	
	public SLL() {
		head = null;
		size = 0;
	}
	public SLL(E headVal) {
		head = new Node<E>(headVal);
		size = 1;
	}
	
	public E getValByIndex(int index) {
		// returns data of Node at index "index"
		// returns null otherwise
		if(index < 0 || index >= size) {
			System.out.println("index out of bounds");
		} else if(size == 0) {
			System.out.println("List is empty");
		} else {
			Node<E> currNode = head;
			for(int i = 0; i < size; i++) {
				if(i == index) {
					return currNode.data;
				}
				currNode = currNode.next;
			}
		}
		return null;
	}
	
	public void append(E value) {
		// add a new node with data=value at the end of the list
		size++;
		if(head == null) {
			head = new Node<E>(value);
			return;
		}
		Node<E> currNode;
		for(currNode = head; currNode.next != null; currNode = currNode.next) {
		}
		currNode.next = new Node<E>(value);
	}
	
	public void remove(E value) {
		// remove the first occurrence of the node containing value from the list
		// if such node does not exist, print message and exit
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		for(Node<E> currNode = head; currNode.next != null; currNode = currNode.next) {
			if(currNode.data == value) {
				head = currNode.next; 
			} else if (currNode.next == null) {
				System.out.println("The list does not contain such value.");
				return;
			} else if (currNode.next.data == value) {
				currNode.next = currNode.next.next;
				size--;
				return;
			}
		}
	}
	
	public void insertAt(E value, int index) {
		// insert Node containing given value at index "index".
		// if index is out of bounds, print error
		// todo
		if (index > size) {
			System.out.println("Invalid index");
			return;
		}
		int count = 0;
		Node<E> trav = head;
		while (count < index - 1) {
			trav = trav.next;
			count++;
		}
		Node<E> newNode = new Node<E>(value, trav.next);
		trav.next = newNode;
		size++;
	}
	
	public void removeAt(int index) {
		// remove Node at given index
		// if index is out of bounds, print error
		if (index >= size) {
			System.out.println("Invalid index");
			return;
		}
		int count = 0;
		Node<E> trav = head;
		while (count < index - 1) {
			trav = trav.next;
			count++;
		}
		trav.next = trav.next.next;
		size--;
	}
	
	public void removeDup() {
		// Remove duplicates, so that all Nodes in the list contain UNIQUE data
		// todo.
		Vector<E> data = new Vector<E>();
		Node<E> trav = head;
		data.addElement(trav.data);
		while (trav.next != null) {
			if (data.contains(trav.next.data)) {
				trav.next = trav.next.next;
				size--;
			}
			else {
				data.addElement(trav.next.data);
			}
			trav = trav.next;
		}
	}
	
	public void multiply(int n) {
		// multiply each Node n times
		// ex: 	l1 = [ 1, 2, 3, 3 ]
		//		l1.multiply(3)
		//		l1 = [ 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3 ]
		// todo
		int todo = size, count = 0;
		Node<E> trav = head;
		while(todo > 0) {
			while(count < n - 1) {
				Node<E> ins = new Node<E>(trav.data, trav.next);
				trav.next = ins;
				trav = trav.next;
				count++;
				size++;
			}
			trav = trav.next;
			todo--;
			count = 0;
		}
	}
	
	public void printList() {
		System.out.print("[");
		for(Node<E> currNode = head; currNode != null; currNode = currNode.next) {
			if(currNode != head) {
				System.out.print(" -> ");
			}
			System.out.print(currNode.data);
		}
		System.out.println("] size: " + size);
	}
	
	
	public static void main(String[] args) {
//		SLL<String> l1 = new SLL<String>();
//		l1.append("abc");
//		l1.printList();
//		l1.append("A");
//		l1.append("B");
//		l1.append("A");
//		l1.printList();
//		l1.remove("A");
//		l1.printList();
//		l1.append("A");
//		l1.append("A");
//		l1.append("A");
//		l1.printList();
//		l1.removeDup();
//		l1.printList();
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
		l2.printList();
		// should be ["b","c","xd","d"]
		l2.removeAt(1);
		// should be ["b","xd","d"]
		l2.printList();
	}

}
