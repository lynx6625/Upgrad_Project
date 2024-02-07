import java.util.*;

public class Source {

  public static int mostFrequentElement(int[] arr) {
    // Write code here
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // Creating a Hashmap and adding all array elements as keys
    int maxfreq = 0;
    int result = 0;
    for (int i = 0; i < arr.length; i++) { //Iterating through the array
      int key = arr[i];
      if (map.containsKey(key)) { //if the key being iterated over is present in hashmap
        int freq = map.get(key);
        freq++; //increment frequency
        map.put(key, freq); //store element and it's frequency in a key value pair
      } else {
        map.put(key, 1); //else element has only appeared once and frequency is only 1
      }
    }
    for (Map.Entry<Integer, Integer> value : map.entrySet()) { //iterating throught the hashmap using entryset
      if (maxfreq < value.getValue()) { //if maximum frequency is lesser than iterated element in the hashmap
        result = value.getKey(); //result is set to the most frequent element
        maxfreq = value.getValue(); //maximum frequency is updated to the current frequency of iterated element
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int n;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(mostFrequentElement(arr));
  }
}
