import java.util.*;

public class Source {

    private int vertexCount;
    private static LinkedList<Integer> adj[];

    Source(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();    
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

  private boolean isValidIndex(int i) {
    // Write code here
    if ((i < vertexCount) && (i >= 0)) { // If index is lesser than total number of vertexes
      return true; // and is non zero, return True.
    } else {
      return false;
    }
  }

  private boolean isCyclic(int v, boolean visited[], int parent) {
    // Write code here
    visited[v] = true; //Setting the vertex being checked as visited.
    for (int i : adj[v]) { // Iterating through adjacent vertices array
      if (!visited[i]) { // If vertex being iterated has not been visited,
        if (isCyclic(i, visited, v)) { //isCyclic is recursively called to check for cycles from i.
          return true; //then graph is cyclic.
        }
      } else if (i != parent) { //also if i is equal to the parent, it means i is visiting it,
        return true; //then also graph is cyclic.
      }
    }
    return false;
  }

  public boolean isTree() {
    // Write Code here
    boolean visited[] = new boolean[vertexCount]; // Making a boolean array for each vertex.
    if (isCyclic(0, visited, -1)) {
      return false; // If graph is not connected, it can not be cycle, hence not a tree.
    }

    for (int i = 0; i < visited.length; i++) { // Checking if all vertices are visited
      if (!visited[i]) {
        return false; // if a vertice is unvisited, graph is not a tree.
      }
    }
    return true; //No cycles and graph is cyclic.
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // Get the number of nodes from the input.
    int noOfNodes = sc.nextInt();
    // Get the number of edges from the input.
    int noOfEdges = sc.nextInt();

    Source graph = new Source(noOfNodes);
    // Adding edges to the graph
    for (int i = 0; i < noOfEdges; ++i) {
      graph.addEdge(sc.nextInt(), sc.nextInt());
    }
    if (graph.isTree()) {
      System.out.println("Yes"); //changed to match output
    } else {
      System.out.println("No"); //changed to match output
    }
  }
}