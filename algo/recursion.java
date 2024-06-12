import java.util.Scanner;

public class recursion {
    public static void main(String[] args) {
        // factorial();
        // fibonacci();
        // sumOfDigits();
        // power();
        // numOfDigits();
        // topToBottomCorner();
        // stringReverse();
        // reverseNum();
        Euclidean();
    }

    public static void Euclidean() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();
        System.out.println(gcd(a, b));
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void reverseNum() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        n = revNum(n);
        System.out.println(n);
    }

    static int revNumAns = 0;

    static int revNum(int n) {
        if (n < 10) {
            revNumAns = revNumAns * 10 + n;
        } else {
            revNumAns = revNumAns * 10 + n % 10;
            revNum(n / 10);
        }
        return revNumAns;
    }

    public static void stringReverse() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        System.out.println(reverse(s));
    }

    static String reverse(String s) {
        int sl = s.length();
        if (sl == 1) {
            return s;
        }
        return s.charAt(sl - 1) + reverse(s.substring(0, sl - 1));
    }

    public static void topToBottomCorner() {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.close();
        System.out.println(noOfPaths(m, n));
    }

    static int noOfPaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return noOfPaths(m - 1, n) + noOfPaths(m, n - 1);
    }

    public static void numOfDigits() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(nod(n));
    }

    static int nodCount = 0;

    static int nod(int n) {
        if (n != 0) {
            nodCount++;
            return nod(n / 10);
        }
        return nodCount;
    }

    public static void power() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int n = scan.nextInt();
        scan.close();
        System.out.println(pow(a, n));
    }

    static int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * pow(a, n - 1);
    }

    public static void sumOfDigits() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(sod(n));
    }

    static int sod(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + sod(n / 10);
    }

    public static void factorial() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(fact(n));
    }

    static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void fibonacci() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(fib(n - 1));
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
