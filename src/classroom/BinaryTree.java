package classroom0326test;
import java.io.*;
import java.util.Scanner;

public class BinaryTree<E> {
   protected static class Node<E> {
	   protected E data;
	   protected Node<E> left;
	   protected Node<E> right;
	   public Node(E data) {
		   this.data = data; left = right = null; 
	   }
	   public String toString() { return data.toString(); }
   }
   
   protected Node<E> root;
   public BinaryTree() { root = null; }
   protected BinaryTree(Node<E> root) { this.root = root; }
   public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
	   root = new Node<E>(data);
	   if (leftTree != null) root.left = leftTree.root;
	   else root.left = null;
	   if (rightTree != null) root.right = rightTree.root;
	   else root.right= null;
   }
   public BinaryTree<E> getLS() {
	   if (root != null && root.left != null) return new BinaryTree<E>(root.left);
	   else return null;
   }
   public BinaryTree<E> getRS() {
	   if (root != null && root.right != null) return new BinaryTree<E>(root.right);
	   else return null;
   }
   public boolean isLeaf() {
	   return (root == null || (root.left == null && root.right == null));
   }
   
   public String toString() {
	   StringBuilder sb = new StringBuilder();
	   preOT(root, 1, sb);
	   return sb.toString();
   }
   private void preOT(Node<E> n, int depth, StringBuilder sb) {
       //sb.append(" x"+depth+" ");
       for (int i =0; i<depth; i++) sb.append(" ");
       if (n==null) {
    	   sb.append("null\n");
       } else {
    	   sb.append(n.toString());
    	   sb.append("\n");
    	   preOT(n.left, depth+1, sb);
    	   preOT(n.right, depth+1, sb);
       }
   }
   public static BinaryTree<String> readBinaryTree(Scanner scan) {
	   String data = scan.next();
	   if (data.equals("null")) return null;
	   else {
		   BinaryTree<String> lt = readBinaryTree(scan);
		   BinaryTree<String> rt = readBinaryTree(scan);
		   return new BinaryTree<String>(data, lt, rt);
	   }
   }
   public static void main(String[] args) throws Exception {
	   FileReader fin = new FileReader("src/tree1.txt");
	   Scanner src = new Scanner(fin);
	   BinaryTree<String> t = BinaryTree.readBinaryTree(src);
	   System.out.println(t);
   }
}












