import java.util.ArrayList;
import java.util.List; 

// Java implementation for finding the Lowest Common Ancestor of two nodes in a Binary Tree

class Node {
	int data;
	Node left;
	Node right;

	public Node (int item) {
		data = item;
		left = null;
		right = null;
	}
}

public class LCA {
	Node root;
	private List<Integer> path1 = new ArrayList<Integer>();
	private List<Integer> path2 = new ArrayList<Integer>();

	// function to find path from root node to given root node (LCA)
	int findLCA(int nr1, int nr2) {
		path1.clear();
		path2.clear();
		return findLCA2(root, nr1, nr2);
	}

	private int findLCA2(Node root, int nr1, int nr2) {
		if(!findPath(root, nr1, path1) || !findPath(root, nr2, path2)) {
			if(path1.size() > 0) {
				System.out.println(nr1 + " is in the path");
			} else {
				System.out.println(nr1 + " is not in the path");
			}
			if(path2.size() > 0) {
				System.out.println(nr2 + " is in the path");
			} else {
				System.out.println(nr2 + " is not in the path");
			}		
			return -1;
		}
		int i;
		for(i = 0; i < path1.size() && i < path2.size(); i++) {
			if(path1.get(i).equals(path2.get(i)) == false) {
				break;
			}
		}
		// return LCA
		return path1.get(i-1);
	}
	// function to find and store path from root node to given root node
	private boolean findPath(Node root, int nr, List<Integer> path) {
		if(root == null) {
			return false;
		}

		// add node to path, will be removed later if it is not in the path from the root to node
		path.add(root.data);
		// check if the root is the same as node
		if(root.data == nr ) {
			return true;
		}

		if(root.left != null && findPath(root.left, nr, path)) {
			return true; 
		} 
		if(root.right != null && findPath(root.right, nr, path)) {
			return true;
		}

		// if not present in subtree rooted with the root node, remove the root from the path list
		path.remove(path.size()-1);
		return false;
	}
//	public static void main(String[] args) {
//		LCA tree = new LCA(); 
//		tree.root = new Node(1); 
//		tree.root.left = new Node(2); 
//		tree.root.right = new Node(3); 
//		tree.root.left.left = new Node(4); 
//		tree.root.left.right = new Node(5); 
//		tree.root.right.left = new Node(6); 
//		tree.root.right.right = new Node(7); 
//		System.out.println("LCA(2,3) = " + tree.findLCA(2,3)); 
//		System.out.println("LCA(4,2) = " + tree.findLCA(4,2)); 
//		System.out.println("LCA(4,4) = " + tree.findLCA(4,4));
//		System.out.println("LCA(4,5) = " + tree.findLCA(4,5)); 
//		System.out.println("LCA(4,6) = " + tree.findLCA(4,6)); 
//	}
}


