// CS 284 AUTHOR: Justin Westley
// I pledge my honor that I have abided by the Stevens Honor System.

package homework;

public class DLList<E> {
	
	// Create the Nodes to use in our DLL. Each must have a next and prev pointer.
	private static class Node<E> {
		
		// Data fields
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		// Constructors	
		private Node(E elem) {
			data = elem;
			prev = null;
			next = null;
		}
		
		private Node(E elem, Node<E> prev, Node<E> next) {
			data = elem;
			this.prev = prev;
			this.next = next;
		}
	}
	
	// Data fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	// Constructors	
	public DLList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// Methods
	
	/**
	 * Adds a node with data elem at position index
	 * @param index position to insert
	 * @param elem object to insert
	 * @return true if the operation is successful, else false
	 */
	public boolean add(int index, E elem) {
		// Case 1: index out of bounds or invalid
		if(index > size || index < 0) throw new IllegalArgumentException("Index out of bounds");
		
		// Case 2: empty list
		if(head == null) {
			head = new Node<E>(elem);
			tail = head;
			size++;
			return true;
		}
		
		// Case 4: start of list
		if(index == 0) {
			Node<E> temp = new Node<E>(elem, null, head);
			head.prev = temp;
			head = temp;
			size++;
			return true;
		}
		
		// Case 5: end of list
		if(index == size) {
			Node<E> temp = new Node<E>(elem, tail, null);
			tail.next = temp;
			tail = temp;
			size++;
			return true;
		}
		
		// Case 6: somewhere in the middle
		Node<E> trav = head;
		int currInd = 0;
		while(currInd < index - 1) {
			trav = trav.next;
			currInd++;
		}
		Node<E> temp = new Node<E>(elem, trav, trav.next);
		trav.next.prev = temp;
		trav.next = temp;
		size++;
		return true;
	}
	
	/**
	 * Adds a node with data elem at the front of the list
	 * @param elem object to insert
	 * @return true if the operation is successful, else false
	 */
	public boolean add(E elem) {
		if(head == null) {
			head = new Node<E>(elem);
			tail = head;
			size++;
			return true;
		}
		Node<E> temp = new Node<E>(elem, null, head);
		head.prev = temp;
		head = temp;
		size++;
		return true;
	}
	
	/**
	 * Adds a node with data elem to the end of the list in O(1) time
	 * @param elem object to insert
	 * @return true if the operation is successful, else false
	 */
	public boolean append(E elem) {
		if(head == null) {
			head = new Node<E>(elem);
			tail = head;
			size++;
			return true;
		}
		Node<E> temp = new Node<E>(elem, tail, null);
		tail.next = temp;
		tail = temp;
		size++;
		return true;
	}
	
	/**
	 * Returns the object at position index in O(n/2) time
	 * @param index position to retrieve from
	 * @return object at position index
	 */
	public E get(int index) {
		if(index < 0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
		if(head == null) throw new NullPointerException("List is empty");
		
		if(index <= size / 2) {
			Node<E> trav = head;
			int currInd = 0;
			while(currInd < index) {
				trav = trav.next;
				currInd++;
			}
			return trav.data;
		}
		else {
			Node<E> trav = tail;
			int currInd = size - 1;
			while(currInd > index) {
				trav = trav.prev;
				currInd--;
			}
			return trav.data;
		}
	}
	
	/**
	 * Returns the object at the head of the list
	 * @return object at head
	 */
	public E getHead() {
		if(head == null) throw new NullPointerException("List is empty");
		return head.data;
	}
	
	/**
	 * Returns the object at the tail of the list in O(1) time
	 * @return object at tail
	 */
	public E getLast() {
		if(head == null) throw new NullPointerException("List is empty");
		return tail.data;
	}
	
	/**
	 * Returns the size of the list
	 * @return list size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes and returns the element at the head of the list
	 * @return element at the head
	 */
	public E remove() {
		if(head == null) throw new NullPointerException("List is empty");
		
		Node<E> temp = head;
		if(head.next == null) {
			head = null;
			tail = null;
			size--;
			return temp.data;
		}
		head = head.next;
		head.prev = null;
		size--;
		return temp.data;
	}
	
	/**
	 * Removes and returns the element at the tail of the list
	 * @return element at the tail
	 */
	public E removeLast() {
		if(head == null) throw new NullPointerException("List is empty");
		Node<E> temp = tail;
		if(head.next == null) {
			head = null;
			tail = null;
			size--;
			return temp.data;
		}
		tail = tail.prev;
		tail.next = null;
		size--;
		return temp.data;
	}
	
	/**
	 * Removes and returns the element at the given index
	 * @param index position to delete at
	 * @return element at position index
	 */
	public E removeAt(int index) {
		// Edge cases
		if(index < 0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
		if(head == null) throw new NullPointerException("List is empty");
		if(index == 0) return this.remove();
		if(index == size - 1) return this.removeLast();
		
		if(index <= size / 2) {
			Node<E> trav = head;
			int currInd = 0;
			// Get to node
			while(currInd < index) {
				trav = trav.next;
				currInd++;
			}
			trav.prev.next = trav.next;
			trav.next.prev = trav.prev;
			size--;
			return trav.data;
		}
		else {
			Node<E> trav = tail;
			int currInd = size - 1;
			// Get to node
			while(currInd > index) {
				trav = trav.prev;
				currInd--;
			}
			trav.next.prev = trav.prev;
			trav.prev.next = trav.next;
			size--;
			return trav.data;
		}
	}
	
	/**
	 * Removes the first occurrence of elem in the list and returns a boolean
	 * @param elem
	 * @return true if the element was successfully removed, and false if the element is not in the list
	 */
	public boolean remove(E elem) {
		if(head == null) return false;
		if(head.data == elem) {
			head = head.next;
			head.prev = null;
			size--;
			return true;
		}
		Node<E> trav = head;
		while(trav.next != null) {
			if(trav.data == elem) {
				trav.prev.next = trav.next;
				trav.next.prev = trav.prev;
				size--;
				return true;
			}
			trav = trav.next;
		}
		if(tail.data == elem) {
			tail = tail.prev;
			tail.next = null;
			size--;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns a string representation of the list. Iterates through all nodes
	 * @return string representation of the list
	 */
	@Override
	public String toString() {
		StringBuilder listString = new StringBuilder("[");
		if(head == null) {
			listString.append("]");
			return listString.toString();
		}
		
		Node<E> trav = head;
		while(trav.next != null) {
			listString.append(trav.data);
			listString.append(" <--> ");
			trav = trav.next;
		}
		listString.append(trav.data + "]");
		return listString.toString();
	}

}
