import java.util.Scanner;
public class SolutionB {
    private static int SearchB(int[] arr, int value) {
        int start = 0;
        int end = 1;
        while (true) {
            try {
            if (arr[end] == value) {
                return end;                  
            }
            if (arr[end] > value) {
                break;
            }
            end = end * 2;
                } 
            catch (IndexOutOfBoundsException e) {
                break;
            }
            }

        int left = start, right = end;
        while (left <= right) {
        int mid = left + (right - left) / 2;
        try {
        if (arr[mid] == value) {
            return mid;
        } 
        else if (arr[mid] < value) {
            left = mid + 1;
        } 
        else {
            right = mid - 1;
            }
        } catch (IndexOutOfBoundsException e) {
                    right = mid - 1;
            }
        }
            return -1;
}

        public static void main (String[]args){
            Scanner input = new Scanner(System.in);
            int size = input.nextInt();
            int value = input.nextInt();
            if (size == 0) {
                System.out.print("NOT_FOUND");
                return;
            }
            int id[] = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                id[i] = input.nextInt();
            }
            int index = SearchB(id, value);
            if (index == -1) {
                System.out.println("NOT_FOUND");
            } else {
                System.out.println(index);
            }
        }
    }
