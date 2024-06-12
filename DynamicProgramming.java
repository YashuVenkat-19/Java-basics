
// You are using Java
import java.util.*;

public class DynamicProgramming {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = scan.nextInt();
        }

        int k = scan.nextInt();
        // call the class for each question in main function
        MaxProfitWithKTransactions m = new MaxProfitWithKTransactions();
        // Sample input n=6, price=[5,11,3,50,60,90], k=2
        // answer = 93
        System.out.println(m.maxProfitWithKTransactions(price, n, k));

    }
}

class MaxProfitWithKTransactions {
    public int maxProfitWithKTransactions(int[] price, int n, int k) {
        if (n <= 1 || k == 0) {
            return 0;
        }

        int[][] T = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -price[0];

            for (int j = 1; j < n; j++) {
                T[i][j] = Math.max(T[i][j - 1], price[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - price[j]);
            }
        }

        return T[k][n - 1];
    }
}