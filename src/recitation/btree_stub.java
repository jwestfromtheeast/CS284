package recitation;

import java.util.LinkedList;

// Class for creating a binary search tree
public class btree_stub {
	private class Node {
		int data;
		Node left;
		Node right;
		
		Node(int item) {
			data = item;
			left = null;
			right = null;
		}
		
		Node(int item, Node left, Node right) {
			data = item;
			this.left = left;
			this.right = right;
		}
		
		// TODO implement a right and left rotation (needed for deleting inside a binary search tree
		Node rotateRight() {
			Node temp = this.left;
			this.left = temp.right;
			temp.right = this;
			return temp;
		}
		
		Node rotateLeft() {
			// TODO finish
			Node temp = this.right;
			this.right = temp.right;
			temp.left = this;
			return temp;
		}
		
		public String toString() {
			return Integer.toString(data);
		}
	}
	
	Node root;
	
	public btree_stub() {
		root = null;
	}
	
	public Boolean add(int data) {
		if (root == null) {
			root = new Node(data, null, null);
		} else {
			Node parent = null;
			Node curr = root;
			Boolean left = true;
			while(curr != null) {
				if (curr.data > data) {
					parent = curr;
					curr = curr.right;
					left = false;
				} else {
					parent = curr;
					curr = curr.left;
					left = true;
				}
			}
			if (left) {
				parent.left = new Node(data, null, null);
			} else {
				parent.right = new Node(data, null, null);
			}
		}
		return true;
	}
	
	//TODO Create a breathe first search algorithm which walks over and prints the tree.
	// HINT: A queue makes this alot easier.
	// HINT #2: Not recursive!!
	void BFS() {
		LinkedList<Node> queue = new LinkedList<Node>();
		Node temp;
		if(root == null) {
			System.out.println("null");
			return;
		}
		queue.offer(root);
		while(queue.size() != 0) {
			temp = queue.poll();
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			if(temp.right != null) {
				queue.offer(temp.right);
			}
			System.out.print(temp + ", ");
		}
		System.out.println();
	}
	
	// TODO Implement the delete method for binary search trees.
	// HINT: You will need to create rotate methods.
	public Boolean delete(int elem) {
		// TODO finish
		throw new NullPointerException("not implemented");
	}
	
	public static void main(String[] args) {
		btree_stub t = new btree_stub();
		t.add(9);
		t.add(3);
		t.add(10);
		t.add(4);
		System.out.println(t);
		t.BFS();
	}
}
