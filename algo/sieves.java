import java.util.Arrays;
import java.util.Scanner;

public class sieves {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        // sieveOfErasthones(n);
        sieveOfSundram(n);

    }

    public static void sieveOfErasthones(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        for (int i = 2; (i * i) <= n; i++) {
            if (sieve[i]) {
                for (int j = (i * i); j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        for (int k = 2; k < n; k++) {
            if (sieve[k]) {
                System.out.print(k + " ");
            }
        }
    }

    public static void sieveOfSundram(int n) {
        n = (n - 1) / 2;
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, false);
        for (int i = 1; i <= n; i++) {
            for (int j = i; (i + j + 2 * i * j) <= n; j++) {
                sieve[i + j + 2 * i * j] = true;
            }
        }
        if (n > 2) {
            System.out.print(2 + " ");
        }
        for (int i = 1; i <= n; i++) {
            if (!sieve[i]) {
                System.out.print(2 * i + 1 + " ");
            }
        }
    }

}
