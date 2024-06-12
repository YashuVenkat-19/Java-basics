import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class josephusAlog {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.close();
        // System.out.println(josephus(n, k));
        josephusList(n, k);
    }

    static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return ((josephus(n - 1, k)) + k - 1) % n + 1;
        }
    }

    static void josephusList(int n, int k) {

        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }
        joshRecursion(circle, k, 0);
    }

    static void joshRecursion(List<Integer> circle, int k, int index) {
        if (circle.size() == 1) {
            System.out.println(circle.get(0) - 1);
            return;
        }
        index = (index + k) % circle.size();
        circle.remove(index);
        joshRecursion(circle, k, index);
    }
}
