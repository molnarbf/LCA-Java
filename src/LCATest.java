import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testFindPath() {
		Node root = null;
		LCA tree = new LCA();
		tree.root = root;
		int number1 = 1;
		int number2 = 2;
		assertEquals("Testing findPath", -1, tree.findLCA(number1, number2));
	}
	
	// Tests for DAG implementation
	
	@Test
	public void testAddEdge() {
		DAG graph = new DAG(5); 
		
		assertEquals("Testing a valid edge", true, graph.addEdge(0, 1));
		assertEquals("Testing a valid edge", true, graph.addEdge(1, 2));
		
		assertEquals("Testing already existing edge", false, graph.addEdge(1, 2));
		assertEquals("Testing adding edge to itself", false, graph.addEdge(1, 1));
		
		assertEquals("Testing cycle add", false, graph.addEdge(2, 1));
		
		assertEquals("Testing non-existing vertex", false, graph.addEdge(5, 4));
		assertEquals("Testing non-existing vertex", false, graph.addEdge(5, 6));

		assertEquals("Testing non-existing vertex", false, graph.addEdge(-1, -2));
		assertEquals("Testing non-existing vertex", false, graph.addEdge(20, 100));

	}
	
	@Test
	public void testVertices() {
		DAG graph = new DAG(5);
		assertEquals("Test", 5, graph.getVertices());
	}
}


