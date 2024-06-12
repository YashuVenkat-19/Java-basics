// Dynamic programming
// fibonacci
// factorial
// Given a distance ‘dist’, count total number of ways to cover the distance 
// with 1, 2 and 3 steps. (if 4 skip 5 skip, increase accordingly)
// Longest common subsequence
// Longest palindromic subsequence
// Longest Increasing subsequence
// Coin change(R)
// Subset Sum(R)
// 0/1 knapsack - stealing the max
// Prefix 
// Count no. of ways of —----------

import java.util.Scanner;

public class DyProg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number:");
        int n = scan.nextInt();
        // fibo
        System.out.println("Fibonnaci of n : " + fibo(n));
        // factorial
        System.out.println("n! : " + n + "! = " + fact(n));
        // Given a distance ‘dist’, count total number of ways to cover the distance
        // with 1, 2 and 3 steps. ---> 0,1,2 - tribonaci
        System.out.println("Distinct ways to cover the distance " + n + " : " + distanceCover(n));
        // longest common subsequence
        System.out.println("Enter two strings:");
        String s1 = scan.next();
        String s2 = scan.next();
        System.out.println("Longest common subsequence : " + lcs(s1, s2));

    }

    public static int fibo(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        System.out.print(dp[0] + " " + dp[1] + " ");
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.print(dp[i] + " ");
        }
        return dp[n - 1];

    }

    public static int fact(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        System.out.print(dp[0] + " ");
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * (i + 1);
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        // 1st column fully 0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        // first row fully 0
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        // calculate
        System.out.println();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // if same then add 1 to diagonal
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // if not same then max of left and top
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];

    }

    public static int distanceCover(int n) {
        // if only 1, 2, 3 skips put thrice - else no. of. skips times
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 step
        System.out.print(dp[0] + " ");
        if (n >= 1) { // 1 step - 1 way
            dp[1] = 1;
            System.out.print(dp[1] + " ");
        }
        if (n >= 2) { // 2 steps - (1+1, 2) 2 ways
            dp[2] = 2;
            System.out.print(dp[2] + " ");
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }
}