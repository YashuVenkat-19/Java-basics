import java.util.Arrays;
import java.util.Scanner;

// find the number of minimum barbers/machines
// input: 5
// 1 2 4 3 5
// 3 4 6 7 8 --> 3

// maximum product
// input: 5
// -1 2 -3 5 -4 --> 120

// find the max that can be stolen from non adjacent houses
// input : 6
// 3 1 2 4 5 6 --> 13

public class maxproArray {
    public static void main(String[] args) {
        main1();
        // main2();
        // main3();
    }

    public static void main1() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            e[i] = scan.nextInt();
        }
        scan.close();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (e[i] > e[j]) {
                    temp = e[i];
                    e[i] = e[j];
                    e[j] = temp;

                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        int k = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] < e[k]) {
                b++;
            } else if (s[i] == e[k]) {
                b--;
                k++;
            } else {
                k = i;
            }
        }
        System.out.print(b);
    }

    public static void main2() {
        Scanner scan2 = new Scanner(System.in);
        int n = scan2.nextInt();
        int[] arr = new int[n];
        int m = 1, neg = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scan2.nextInt();
            if (arr[i] != 0) {
                m *= arr[i];
            }
            if (arr[i] < 0) {
                neg++;
            }
        }
        scan2.close();
        if (neg > 0) {
            int[] negarr = new int[neg];
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] < 0) {
                    negarr[k] = arr[i];
                    k++;
                }
            }
            Arrays.sort(negarr);
            m /= negarr[k - 1];
        }
        System.out.println(m);

    }

    public static void main3() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(maxprofit(arr, n));

    }

    public static int maxprofit(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        int maxval = 0;
        int v1 = arr[0];
        int v2 = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            maxval = Math.max(arr[i] + v1, v2);
            v1 = v2;
            v2 = maxval;
        }
        return maxval;
    }
}
