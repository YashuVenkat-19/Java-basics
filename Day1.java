import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // System.out.println("Enter your name:");
        // String name = scan.nextLine();
        // System.out.println("All The Best Buddy!" + name);
        int n1 = scan.nextInt();
        // pattern1(n1);
        // pattern2(n1);
        // pattern3(n1);
        // pattern4(n1);
        pattern5(n1);
        scan.close();
    }

    public static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("next pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("  ");
            }
            for (int j = n - 1; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("next pattern");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("next pattern");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print("* ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("  ");
            }
            System.out.println("");
        }
    }

    public static void pattern2(int n) {
        System.out.println("diamond");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i + 1; j++) {
                System.out.print("  ");
            }
            for (int j = n - 1; j > i; j--) {
                System.out.print("* ");
            }
            for (int j = n - 1; j > i + 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print("  ");
            }
            int k = 0;
            for (; k <= i; k++) {
                System.out.print((k + 1) + " ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print((j + k + 1) + " ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print("  ");
            }
            int k = 0;
            for (; k <= i; k++) {
                System.out.print((k + 1) + " ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print((k - j - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        System.out.println("hollow diamond");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            for (int j = n - 1; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = n - 2; j >= i; j--) {
                if (i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}