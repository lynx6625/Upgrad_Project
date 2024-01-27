import java.util.*;

public class Source {

  public static int median(int[] arr1, int[] arr2, int n) {
    // Write code here
    int l = 0, r = 0, count, mid1 = -1, mid2 = -1;
    //Since arrays are size n each, total size of merged array is 2*n. Since 2*n will always be even,
    //Median will be average of middle two elements - n and n-1
    for (count = 0; count <= n; count++) {
      if (arr1[l] <= arr2[r]) { //If first array element is lesser than second array element,
        mid1 = mid2; //Storing previous median in mid1,
        mid2 = arr1[l]; //update mid2 to first array element.
        l++; //Increment first array pointer by 1 position to compare next element.
      } 
      else {
        mid1 = mid2; //Storing previous median in mid1,
        mid2 = arr2[r]; //update mid2 to second array element.
        r++; //Increment second array pointer by to compare next element.
      }

      if (l == n) { //If left array pointer is equal to n,
        mid1 = mid2;
        mid2 = arr2[0]; // mid2 is starting of second array
        break;
      } else if (r == n) { //If right array pointer is equal to n,
        mid1 = mid2;
        mid2 = arr1[0]; // mid2 is starting of first array
        break;
      }
    }
    return (mid1 + mid2) / 2; //Returning average to find median.
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int arr1[] = new int[n];
    int arr2[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr1[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      arr2[i] = sc.nextInt();
    }
    System.out.println(median(arr1, arr2, n));
  }
}
