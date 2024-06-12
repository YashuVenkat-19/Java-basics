// Sort the array elements in descending order according to their frequency of occurrence

// Input Format
// 11
// 2 2 3 4 5 12 2 3 3 3 12

// Output Format
// 3 3 3 3 2 2 2 12 12 4 5

import java.util.*;

public class DecreasingFrequency {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((map.get(arr[j]) < map.get(arr[j + 1]))
                        || (map.get(arr[j]).equals(map.get(arr[j + 1])) && arr[j] > arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}