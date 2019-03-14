// CS 284 AUTHOR: Justin Westley

package recitation;

public class SingleLinkedList {

	Node head;
	int size;
	
	private static class Node {
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public SingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public void insert(int x) {
		Node newNode = new Node(x);
		// no head, become head
		if(head == null) head = newNode;
		// head is larger than our new node, go to front (sorted)
		else if(head.data > newNode.data) newNode.next = head;
		else { // iterate thru to find proper location
			Node currentNode = head;
			while(currentNode.next != null) {
				//Should newNode go between currentNode and currentNode.next?
				if(currentNode.next.data < newNode.data) {
					//Should not go here, need to go further
					currentNode = currentNode.next;
				}
				else {
					// Should go between them, insert between currentNode and currentNode.next
					//newNode points to node after currentNode
					newNode.next = currentNode.next;
					// currentNode now points to newNode
					currentNode.next = newNode;
					break;
				}
			}
			// Node is greater than anything in the list, add it to the end
			currentNode.next = newNode;
		}
		size++;
	}
	
	public void delete(int x) {
		if(head == null) {
			// No nodes in list, do nothing
			return;
		} 
		if(head.next == null) {
			//Only a head in the list
			if(head.data == x) {
				head = null;
			}
			return;
		}
		Node previousNode = head;
		Node currentNode = head.next;
		while(currentNode != null) {
			if(currentNode.data == x) {
				previousNode.next = currentNode.next;
				break;
			}
			currentNode = currentNode.next;
		}
		size--;
	}
	
	// print in easy to read manner
	public void printList() {
		if(head == null) {
			System.out.println("Size: 0");
			return;
		}
		//there are things. print all but the last
		Node currentNode = head;
		while(currentNode.next != null) {
			System.out.print(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}
		//print last without arrow
		System.out.println(currentNode.data + " Size: " + size);
	}
	
	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		sll.printList();
		sll.insert(6);
		sll.insert(10000);
		sll.printList();
		sll.insert(14);
		sll.printList();
		sll.delete(14);
		sll.printList();
	}

}
