import java.util.*;

public class sorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // String[] arr = new String[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        quickSort(arr, 0, n - 1);
        // bubbleSort(arr, n);
        // bubbleSortString(arr, n);
        // insertion(arr, n);
        // selectionSort(arr, n);
        // sort(arr, 0, (n - 1));// mergesort
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // partitioning
            int loc = partition(arr, start, end);

            quickSort(arr, start, loc - 1);
            quickSort(arr, loc + 1, end);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;

        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] >= pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void bubbleSortString(String[] arr, int n) {
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (String i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertion(int[] arr, int n) {
        int key, i;
        for (int j = 1; j < n; j++) {
            key = arr[j];
            i = j - 1;
            while ((i > -1) && (arr[i] > key)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[min]) {
                    /* if (arr[j] < arr[min]) { gives descending sort */
                    min = j;
                }
                int temp = arr[min];
                arr[min] = arr[j];
                arr[j] = temp;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
