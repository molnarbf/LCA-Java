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
}


