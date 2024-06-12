import java.util.Scanner;

public class AdamNumber {
    // Adam number is a number when reversed,
    // the square of the number and the square of the reversed number
    // should be numbers which are reverse of each other.
    // 12^2 = 144 ---> 21^2 = 441
    // 13^2 = 169 ---> 31^2 = 961
    // Adam numbers upto 1000 are: 0, 1, 2, 3, 11, 12, 13, 21, 22, 31, 101, 102,
    // 103, 111, 112 , 113, 121, 122, 201, 202, 211, 212, 221, 301, 311.
    public static void main(String[] args) {
        adam();

    }

    public static void adam() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        int sq = n * n;

        int rev = reverse(n);
        int rev_sq = rev * rev;
        System.out.println(n + " " + sq + " " + rev + " " + rev_sq);
        if (sq == reverse(rev_sq)) {
            System.out.println("Adam Number");
        } else {
            System.out.println("Not an Adam Number");
        }

    }

    public static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return rev;
    }
}
