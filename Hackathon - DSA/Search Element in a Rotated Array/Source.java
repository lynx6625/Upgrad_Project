import java.util.*;

public class Source {

  public static int search(int arr[], int left, int right, int key) {
    // Write code here
    if (left > right) return -1;

    int mid = (left + right) / 2; //Finding middle point of the array.
    if (arr[mid] == key) { //If middle element is the searched key,
      return mid; //return middle element.
    }
    //If left value is less than middle,left side is sorted.
    if (arr[left] <= arr[mid]) {
      if (key >= arr[left] && key <= arr[mid]) { //If key is in left sorted half,
        return search(arr, left, mid - 1, key); //use recursive binary search on left half to search and return value.
      }
      return search(arr, mid + 1, right, key); //If key is not in left half, perform recursive binary search on right half.
    }
    //If left half is not sorted, then right half must be sorted.
    if (key >= arr[mid] && key <= arr[right]) { //If key is in right sorted half,
      return search(arr, mid + 1, right, key); //use recursive binary search on left half to search and return value.
    }
    return search(arr, left, mid - 1, key); //If key is not in right half, perform recursive binary search on left half.
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int key = sc.nextInt();
    int i = search(arr, 0, n - 1, key);
    if (i != -1) {
      System.out.println(i);
    } else {
      System.out.println("-1");
    }
  }
}
