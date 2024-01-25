import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GraphIsTree {

  private static boolean isTree(int n, ArrayList<ArrayList<Integer>> adjList) {
    Set<Integer> visited = new HashSet<>();

    if (dfs(0, -1, visited, adjList)) {
      return false; // Cycle exists
    }

    return visited.size() == n; // Check for connectedness
  }

  private static boolean dfs(
    int node,
    int parent,
    Set<Integer> visited,
    ArrayList<ArrayList<Integer>> adjList
  ) {
    visited.add(node);

    for (int neighbor : adjList.get(node)) {
      if (!visited.contains(neighbor)) {
        if (dfs(neighbor, node, visited, adjList)) {
          return true;
        }
      } else if (neighbor != parent) {
        return true; // Cycle found
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    int numEdges = scanner.nextInt();

    // Create adjacency list

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < numEdges; i++) {
      int u = scanner.nextInt();

      int v = scanner.nextInt();

      adjList.get(u).add(v);

      adjList.get(v).add(u);
    }

    // Check if the graph is a tree and print the result

    if (isTree(N, adjList)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
