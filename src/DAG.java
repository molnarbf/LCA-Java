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

	// adds edge from one vertex to another
	public boolean addEdge(int v, int w) {

		// check if vertices are in range
		if( v >= this.vertex || w >= this.vertex || v < 0 || w < 0) {
			return false;			
		}

		// check vertices are different, check path exists between two vertices, check there is not already an edge pointing from one to the other
		if(v != w && !hasPath(w,v) && !next[v].contains(w)) {
			next[v].add(w);
			return true;
		}
		return false;
	}

	// checks if there is a path between two vertices using depth first search
	public boolean hasPath(int i, int j) {

	}

	// create depth first search object on directed graph
	private class DirectedDepthFirst {

		private boolean[] marked;
		private boolean[] reverseMarked;

		// constructor
		public DirectedDepthFirst(DAG graph, int x) {
			marked = new boolean[graph.vertex];
			reverseMarked = new boolean[graph.vertex];
			dfs(graph,x);
		}

		// depth first search
		private void dfs(DAG graph, int v) {
			marked[vertex] = true;
			for(int w : graph.next[v]) {
				if(!marked[w]) {
					dfs(graph, w);
				}
			}
		}
	}
}
