import java.util.*;

// only for sorted array
public class searching {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();// size of array
        int[] arr = new int[n];// array
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();// array inputs
        }
        int x = scan.nextInt();// data to search
        scan.close();
        // int result = linearSearch(arr, x);
        int result = binarySearch(arr, x, 0, n);
        System.out.println((result == -1) ? "Not found" : (x + " is found at position " + result));
    }

    static int linearSearch(int[] arr, int x) {
        int index = -1;
        for (int i : arr) {
            index++;
            if (i == x) {
                break;
            }
        }
        return index;
    }

    static int binarySearch(int[] arr, int x, int start, int end) {
        if (end > start) {
            int mid = (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                binarySearch(arr, x, mid + 1, end);
            } else // (arr[mid]>x)//(x<arr[mid])
            {
                binarySearch(arr, x, start, mid - 1);
            }
        }
        return -1;
    }
}