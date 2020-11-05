import java.util.ArrayList;

/* Directed Acyclic Graph implementation of finding the Lowest Common Ancestor 
*
* A directed acyclic graph is a directed graph with no directed cycles, therefore you can only travel in the specified direction.
* It is impossible to traverse the whole graph starting at one edge.
*/
public class DAG {
	
	private final int vertex;
	private final ArrayList<Integer>[] next;
	
	// constructor
	public DAG(int vertex) {
		this.vertex = vertex;
		next = (ArrayList<Integer>[]) new ArrayList[vertex];
		
		// Arraylist for each vertex
		for(int i = 0; i < vertex; i++) {
			next[i] = new ArrayList<Integer>();
		}
	}
}
