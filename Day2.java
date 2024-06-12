import java.util.Scanner;

public class Day2 {

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void genRandomNum(int a, int b) {
        // to generate between a range
        // Math.random() * (max - min + 1) + min

        System.out.println((int) (Math.random() * (b - a + 1) + a));
        // Another way to generate a random number is to use the Java Random class of
        // the java.util package.
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // System.out.println(fib(n));
        // int n = scan.nextInt();
        // System.out.println(isPrime(n));
        genRandomNum(1, 20);

        scan.close();
    }
}