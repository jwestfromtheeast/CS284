package homework;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Instructions: 
 * First: Read through the assignment specification, make sure you understand what the assignment is asking for.
 * Second: There are number of "TODO" instructions within this code, make sure to complete all of them fully.
 * Third: Test you code.
 */


// TODO: Name and Pledge

// Pledge: I pledge my honor that I have abided by the Stevens Honor System.
// Name: Justin Westley


/**
 * HW4 CS284 Spring 2019
 * Implements a Huffman encoding tree.
 * The included code has been commented for the student's benefit, feel free to read through it.
 */
public class HuffmanTree {

	// ******************** Start of Stub Code ******************** //
	// ************************************************************ //
    /** Node<E> is an inner class and it is abstract.
     * There will be two kinds
     * of Node, one for leaves and one for internal nodes. */
    abstract static class Node implements Comparable<Node>{
        /** The frequency of all the items below this node */
        protected int frequency;
        
        public Node(int freq) {
        	this.frequency = freq;
        }
        
		/** Needed for the Minimum Heap used later in this stub. */
		public int compareTo(Node other) {
			return this.frequency - other.frequency;
		}
    }
    /** Leaves of a Huffman tree contain the data items */
    protected static class LeafNode extends Node {
        // Data Fields
        /** The data in the node */
        protected char data;
        /** Constructor to create a leaf node (i.e. no children) */
        public LeafNode(char data, int freq) {
            super(freq);
            this.data = data;
        }
        /** toString method */
        public String toString() {
            return "[value= "+this.data + ",freq= "+frequency+"]";
        }
    }
    /** Internal nodes contain no data,
     * just references to left and right subtrees */
    protected static class InternalNode extends Node {
        /** A reference to the left child */
        protected Node left;
        /** A reference to the right child */
        protected Node right;

        /** Constructor to create an internal node */
        public InternalNode(Node leftC, Node rightC) {
            super(leftC.frequency + rightC.frequency);
            left = leftC; right = rightC;
        }
        public String toString() {
            return "(freq= "+frequency+")";
        }
    }
	
	// Enough space to encode all "extended ascii" values
	// This size is probably overkill (since many of the values are not "printable" in the usual sense)
	private static final int codex_size = 256;
	
	/* Data Fields for Huffman Tree */
	private Node root;
	
	public HuffmanTree(String s) {
		root = buildHuffmanTree(s);
	}
	
	/**
	 * Returns the frequencies of all characters in s.
	 * @param s
	 * @return
	 */
	public static int[] frequency(String s) {
		int[] freq = new int[codex_size];
		for (char c: s.toCharArray()) {
			freq[c]++;
		}
		return freq;
	}
	
	/**
	 * Builds the actual Huffman tree for that particular string.
	 * @param s
	 * @return
	 */
	private static Node buildHuffmanTree(String s) {
		int[] freq = frequency(s);
		
		// Create a minimum heap for creating the Huffman Tree
		// Note to students: You probably won't know what this data structure
		// is yet, and that is okay.
		PriorityQueue<Node> min_heap = new PriorityQueue<Node>();
		
		// Go through and create all the nodes we need
		// as in, all the nodes that actually appear in our string (have a frequency greater then 0)
		for(int i = 0; i < codex_size; i++) {
			if (freq[i] > 0) {
				// Add a new node (for that character) to the min_heap, notice we have to cast our int i into a char.
				min_heap.add(new LeafNode((char) i, freq[i]));
			}
		}
		
		// Edge case (string was empty)
		if (min_heap.isEmpty()) {
			throw new NullPointerException("Cannot encode an empty String");
		}
		
		// Now to create the actual Huffman Tree 
		// NOTE: this algorithm is a bit beyond what we cover in cs284, 
		// you'll see this in depth in cs385
		
		// Merge smallest subtrees together
		while (min_heap.size() > 1) {
			Node left = min_heap.poll();
			Node right = min_heap.poll();
			Node merged_tree = new InternalNode(left, right);
			min_heap.add(merged_tree);
		}
		
		// Return our structured Huffman Tree
		return min_heap.poll();
	}
	
	// ******************** End of Stub Code ******************** //
	// ********************************************************** //
	
	/**
	 * Helper function for toString(). Returns string representation of the tree.
	 * @param curr current node
	 * @param depth current depth
	 * @return string representation
	 */
	private String preOrderTraversal(Node curr, int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < depth; i++) sb.append("  ");
		if (curr instanceof LeafNode) {
			sb.append(curr.toString());
			sb.append("\n");
		}
		else {
			sb.append(curr.toString());
			sb.append("\n");
			sb.append(preOrderTraversal(((InternalNode)curr).left, depth + 1));
			sb.append(preOrderTraversal(((InternalNode)curr).right, depth + 1));
		}
		return sb.toString();	
	}
	
	@Override
	public String toString() {
		return preOrderTraversal(root, 0);
    }
	
	/**
	 * Helper function to convert boolean array to bit representation
	 * @param coding boolean array
	 * @return bit representation of boolean array
	 */
	private String bitsToString(Boolean[] coding) {
		StringBuilder bld = new StringBuilder();
		for(boolean b : coding) {
			if(b) bld.append("1");
			else bld.append("0");
		}
		return bld.toString();
	}
	
	/**
	 * The above but the reverse
	 * @param str string of bits
	 * @return boolean array representation
	 */
	private Boolean[] stringToBits(String str) {
		Boolean[] b = new Boolean[str.length()];
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				b[i] = true;
			}
			else {
				b[i] = false;
			}
		}
		return b;
	}

	/**
	 * Decodes a Huffman boolean array
	 * @param coding boolean array
	 * @return string represented by input incoding
	 */
	public String decode(Boolean[] coding) {
		if(coding.length < 1) throw new IllegalArgumentException("Input must have at least one bit");	
		Node trav = root;
		String bits = bitsToString(coding);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < bits.length(); i++) {
			if(bits.charAt(i) == '1') {
				trav = ((InternalNode)trav).right;
			}
			else {
				trav = ((InternalNode)trav).left;
			}
			if(trav instanceof LeafNode) {
				sb.append(((LeafNode)trav).data);
				trav = root;
			}
		}
		if(trav != root) throw new IllegalArgumentException("Invalid input bits");
		return sb.toString();
	}
	
	/**
	 * Helper function to recursively encode a string via Huffman Tree (naive)
	 * @param curr current node
	 * @param t bits accumulated during recursion
	 * @param target target character
	 * @param sb if the character is found, append that sequence
	 */
	private void encodeHelper(Node curr, String t, char target, StringBuilder sb) {
		if (curr instanceof LeafNode && ((LeafNode)curr).data == target) {
			sb.append(t);
			return;
		}
		else if(curr instanceof LeafNode && ((LeafNode)curr).data != target) {
			return;
		}
		encodeHelper(((InternalNode)curr).left, t + "0", target, sb);
		encodeHelper(((InternalNode)curr).right, t + "1", target, sb);
	}
	
	/**
	 * Function to recursively encode a string via Huffman Tree (naive)
	 * @param inputText string to encode
	 * @return boolean array of encoded string
	 */
	public Boolean[] encode(String inputText) {
		if(inputText.length() < 1) throw new IllegalArgumentException("Input must have at least one char");	
		StringBuilder sb = new StringBuilder();
		String checker;
		for(char c : inputText.toCharArray()) {
			checker = sb.toString();
			encodeHelper(root, "", c, sb);
			// If no characters are encoded on a pass, the char is not in the tree
			if ((sb.toString().equals(checker)))
				throw new IllegalArgumentException("Character in input not in Huffman tree");
		}
		
		return stringToBits(sb.toString());
	}
	
	public void efficientEncodeHelper(Node curr, String accum, HashMap<Character,String> map) {
		if(curr instanceof LeafNode) {
			map.put(((LeafNode)curr).data, accum);
		}
		else if (curr instanceof InternalNode){
			efficientEncodeHelper(((InternalNode)curr).left, accum + "0", map);
			efficientEncodeHelper(((InternalNode)curr).right, accum + "1", map);
		}
	}
	
	/**
	 * Encodes a string of input text without repeating work
	 * @param inputText string to be encoded
	 * @return boolean array of bits
	 */
	public Boolean[] efficientEncode(String inputText) {
		if(inputText.length() < 1) throw new IllegalArgumentException("Input must have at least one char");	
		StringBuilder sb = new StringBuilder();
		HashMap<Character, String> huff = new HashMap<Character, String>();
		efficientEncodeHelper(root, "", huff);
		for(char c : inputText.toCharArray()) {
			if(!(huff.containsKey(c))) throw new IllegalArgumentException("Character in input not in Huffman Tree");
			sb.append(huff.get(c));
		}
		return stringToBits(sb.toString());
	}
	
	public void printEr(Boolean[] b) {
		for(boolean bo : b) {
			System.out.println(bo);
		}
	}
	
	public static void main(String[] args) {
		// Code to see if stuff works...
		String s = "Some string you want to encode";
		HuffmanTree t = new HuffmanTree(s); // Creates specific Huffman Tree for "s"
		// Now you can use encode, decode, and toString to interact with your specific Huffman Tree
	}
}
