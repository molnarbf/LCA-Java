import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class LCATest {

	@Test
	public void testFindLCA() {
		LCA tree = new LCA(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7);
		int result = 1;
		assertEquals("Testing findLCA", result, tree.findLCA(2,3));
	}
	@Test
	public void testFindLCA2() {
		LCA tree = new LCA(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7);
		int result = 2;
		assertEquals("Testing findLCA", result, tree.findLCA(4,2));
	}
	@Test
	public void testFindLCA3() {
		LCA tree = new LCA(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7);
		int result = 4;
		assertEquals("Testing findLCA", result, tree.findLCA(4,4));
	}
	@Test
	public void testFindLCA4() {
		LCA tree = new LCA(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7);
		int result = 2;
		assertEquals("Testing findLCA", result, tree.findLCA(4,5));
	}
	@Test
	public void testFindLCA5() {
		LCA tree = new LCA(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7);
		int result = 1;
		assertEquals("Testing findLCA", result, tree.findLCA(4,6));
	}



}


