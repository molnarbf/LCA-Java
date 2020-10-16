package LCA;

public class LCA {

	private class Node {
		int key;
		Node left;
		Node right;

		public Node (int item) {
			key = item;
			left = null;
			right = null;
		}
	}

	public static Node lowestCommonAncestor(Node root, Node a, Node b) {
		
		if(root == null) {
			return null;
		}
		
		// check if the root is one of the nodes, if so return root
		if(root.key == a.key || root.key == b.key ) {
			return root;
		}
		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.right, a, b);

		// if both left and right node are not null, it is the LCA
		if(left != null && right != null) {
			return root; 
		} 
		if(left == null) {
			return right;
		}
		else {
			return left;
		}
	}
}

