import java.util.*;

public class Source {

    public static void symmetricPair(int[][] arr) {
    // Write code here
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //Creating a hashmap
    for (int i = 0;i < arr.length; i++) { //Iterating throught the array
      int first = arr[i][0]; //Storing iterated pair first element in variable
      int second = arr[i][1]; //Storing iterated pair second element in variable
      if (map.get(second) != null && map.get(second) == first) { //if the second element of pair in map is equal to first element being iterated,
        System.out.print(second+ " " +first+"\n"); //print the symmetric pair.
      } else {
        map.put(first, second); //Putting the first and second elements into the hashmaps
      }
    }
  }

  public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int arr[][] = new int[row][2];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < 2; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    symmetricPair(arr);
  }
}
