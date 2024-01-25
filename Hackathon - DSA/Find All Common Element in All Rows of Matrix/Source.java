import java.util.*;

public class Source {

  public static void printElementInAllRows(int mat[][]) {
    // Write code here
    Map<Integer, Integer> map = new HashMap<>(); //Creating a hashmap.
    for (int i = 0; i < mat[0].length; i++) { //Iterating through first row.
      map.put(mat[0][i], 1); //Storing first row elements as key and value as it's count.
    }
    for (int i = 1; i < mat.length; i++) { //Loop to traverse rows.
      for (int j = 0; j < mat[0].length; j++) { //Loop to traverse columns.
        if (map.get(mat[i][j]) != null && map.get(mat[i][j]) == i) { //If element is not in map is in the iterated row,
          map.put(mat[i][j], i + 1); //Increment count of that element by 1.
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == mat.length) {
        result.add(entry.getKey());
      }
    }
    Collections.sort(result);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int col = sc.nextInt();

    int matrix[][] = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    printElementInAllRows(matrix);
  }
}
