import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Directed Acyclic Graph implementation of finding the Lowest Common Ancestor 
 *
 * A directed acyclic graph is a directed graph with no directed cycles, therefore you can only travel in the specified direction.
 * It is impossible to traverse the whole graph starting at one edge.
 */
public class DAG {

	private final int vertex;
	private final ArrayList<Integer>[] next;
	private final ArrayList<Integer>[] reverseNext;

	// constructor
	@SuppressWarnings("unchecked")
	public DAG(int vertex) {
		this.vertex = vertex;
		next = (ArrayList<Integer>[]) new ArrayList[vertex];
		reverseNext = (ArrayList<Integer>[]) new ArrayList[vertex];

		// Array list for each vertex
		for(int i = 0; i < vertex; i++) {
			next[i] = new ArrayList<Integer>();
			reverseNext[i] = new ArrayList<Integer>();
		}
	}
	
	// returns number of vertices in DAG
	public int getVertices() {
		return vertex;
	}
	
	// returns list of vertices from vertex
	public ArrayList<Integer> next(int vertex) {
		return next[vertex];
	}
	
	// checks if possible to add edge from one vertex to another
	public boolean addEdge(int v, int w) {

		// check if vertices are in range
		if( v >= this.vertex || w >= this.vertex || v < 0 || w < 0) {
			return false;			
		}

		// check vertices are different, check path exists between two vertices, check there is not already an edge pointing from one to the other
		if(v != w && !hasPath(w, v) && !next[v].contains(w)) {
			next[v].add(w);
			reverseNext[w].add(v);
			return true;
		}
		return false;
	}

	// checks if there is a path between two vertices using depth first search
	public boolean hasPath(int i, int j) {
		DirectedDepthFirst dfsObj = new DirectedDepthFirst(this, i);
		return dfsObj.visited(j);
	}

	// LCA
	// Steps
	// Mark all X's parents
	// For each of X's parents, check if Y is child
	// if it is
	//  	get distance to X
	//  	get distance to Y
	//
	// if max(xDist, yDist) < currentMaxDist
	// 		empty bag and put in this node
	//
	// if max(xDist, yDist) == currentMaxDist
	//		add this node to bag
	//
	
	public ArrayList<Integer> LCA(int v, int w) {
		ArrayList<Integer> lca = new ArrayList<Integer>();
		int maxDist = Integer.MAX_VALUE;

		// check for invalid input
		if(v == w || v >= this.vertex || w >= this.vertex || v < 0 || w < 0) {
			return lca;
		}
		DirectedDepthFirst dfsObj = new DirectedDepthFirst(this, v);
		dfsObj.reverseDFS(this, v);
		int vDist, wDist;

		for(int i = 0; i < this.vertex; i++) {

			if(dfsObj.reverseVisited(i) && hasPath(i, w)) {
				vDist = getDist(i, v);
				wDist = getDist(i, w);

				if(Integer.max(vDist, wDist) < maxDist) {
					lca = new ArrayList<Integer>();
					lca.add(i);
					maxDist = Integer.max(vDist, wDist);
				}
				else if(Integer.max(vDist, wDist) == maxDist) {
					lca.add(i);
					maxDist = Integer.max(vDist, wDist);
				}
			}
		}
		return lca;
	}

	// get distance between two vertices
	private int getDist(int v, int w) {
		if(v == w) {
			return 0;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] distTo = new int[this.vertex];
		boolean[] marked = new boolean[this.vertex];

		for(int i = 0; i < this.vertex; i++) {
			distTo[i] = Integer.MAX_VALUE;
		}

		distTo[v] = 0;
		marked[v] = true;
		q.add(v);

		while(!q.isEmpty()) {
			int x = q.remove();
			for(int y : this.next[v]) {
				if(!marked[y]) {
					distTo[y] = distTo[x] + 1;
					marked[y] = true;
					q.add(y);
				}
			}
		}

		return distTo[w];
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

		// depth first search in flow of direction
		private void dfs(DAG graph, int v) {
			marked[v] = true;
			for(int w : graph.next[v]) {
				if(!marked[w]) {
					dfs(graph, w);
				}
			}
		}

		// depth first search against flow of direction (all ancestors)
		private void reverseDFS(DAG graph, int vertex) {
			reverseMarked[vertex] = true;
			for(int w : graph.reverseNext[vertex]) {
				if(!reverseMarked[w]) {
					reverseDFS(graph, w);
				}
			}
		}

		public boolean visited(int vertex) {
			return marked[vertex]; 
		}

		public boolean reverseVisited(int vertex) {
			return reverseMarked[vertex];
		}
	}
}

