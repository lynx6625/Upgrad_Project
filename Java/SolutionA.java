import java.util.Scanner;
public class SolutionA {
    public static int SearchA(int arr[])
    {
        int start = 1;
        int end = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == arr[mid]) {
                return mid;
            }
            if (mid < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] id = new int[size+1];
        for (int i = 1; i <= size; i++) {
            id[i] = input.nextInt();
        }
        int answer = SearchA(id);
        if(answer==-1){
            System.out.println("NOT_FOUND");
        }
        else {
            System.out.println(answer);
        }
    }
        
}