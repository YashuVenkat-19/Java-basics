import java.util.Scanner;

// The following program runs in greeedy but fails in many cases 
// because greedy onlt checks if the current coin is less than or equal to the amount 
// and then subtracts the amount by the current coin and increments the count. 
// This is not the correct approach because the current coin may not be the best choice
// for the given amount. We need to find out which coin will give us the minimum number of coins required to make up
// the given amount.

// The correct approach is to use dynamic programming to solve this problem.
// The dynamic programming approach is as follows:
// * make an array of size amount + 1
// * set the value of the first element to 0
// * set the value of all the other elements to infinity
// * for each coin
// * for each amount
// * if the amount is greater than or equal to the coin
// * update the value of the amount by the minimum of the current value and the value of the amount - coin + 1
// * print the value of the last element
// The following program implements the dynamic programming approach to solve the coin change problem.
// The time complexity of this program is O(n * amount) and the space complexity is O(amount).
// The program takes the number of coins, the coins, and the amount as input and prints the minimum number of coins required to make the given amount.

// Enter the number of coins
// 3
// Enter the coins
// 1 2 8
// Enter the amount
// 10
// 2

// Failing example: 

// Enter the number of coins
// 3
// Enter the coins
// 1 7 10
// Enter the amount
// 14
// 5

public class greedy {
    public static void main(String[] args) {
        CoinChange.hello();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of coins");
        int n = scan.nextInt();
        // coin change
        // greedy algorithm
        // to find the minimum number of coins to make a given amount
        // * make an array of coins
        // * sort the array
        // * make a variable to keep track of the number of coins
        // * while the amount is greater than 0
        // * find the maximum coin that is less than or equal to the amount
        // * subtract the amount by the maximum coin
        // * increment the number of coins
        // * print the number of coins
        int[] coins = new int[n];
        System.out.println("Enter the coins");
        for (int i = 0; i < n; i++) {
            coins[i] = scan.nextInt();
        }
        System.out.println("Enter the amount");
        int amount = scan.nextInt();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        System.out.println(count);

    }
}

// using dynamic programming

class CoinChange {
    public static void hello() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of coins");
        int n = scan.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the coins");
        for (int i = 0; i < n; i++) {
            coins[i] = scan.nextInt();
        }
        System.out.println("Enter the amount");
        int amount = scan.nextInt();
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.println(dp[amount]);
    }
}