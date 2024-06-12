// import java.util.*;

public class Arrays {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = scan.nextInt();
        // }

        // for (int i : arr) {
        // System.out.println(i + " ");
        // }
        // scan.close();

        // pattern1(n);
        // sneha();
        // pattern2();
        q3();

    }

    public static void pattern1(int n) {
        int x = 1;
        int o = 1;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < o; k++) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            o += 2;
            x++;

        }
    }

    public static void sneha() {
        int n = 4;

        int rowcount = 4;
        int number = 1;
        int colcount = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < rowcount; j++) {
                for (int k = 0; k < colcount; k++) {
                    System.out.print(number);
                }
                System.out.println();
            }

            number++;
            rowcount--;
            colcount += 2;

        }
    }

    public static void pattern2() {
        int[][] arr = { { 11, 2, 3 },
                { 4, 5, 6 },
                { 10, 8, -12 } };

        int d1 = 0, d2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    // System.out.print(j + " ");
                    // System.out.print(arr[i][j] + " ");
                    d1 += arr[i][j];
                }
            }
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i + j == arr.length - 1) {
                    // System.out.print(arr[i][j] + " ");
                    d2 += arr[i][j];
                }
            }
        }
        System.out.println(d1 + " " + d2);

        System.out.println(Math.abs(d1 - d2));
    }

    public static void q3() {
        // swirling numbers
        // 1 2 3 4 5
        // 16 17 18 19 6
        // 15 24 25 20 7
        // 14 23 22 21 8
        // 13 12 11 10 9
        int n = 5;
        int[][] mat = new int[n][n];

        int num = 1;
        int startRow = 0, startCol = 0;
        int endRow = n - 1, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                mat[startRow][i] = num;
                num++;
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                mat[i][endCol] = num;
                num++;
            }

            for (int i = endCol - 1; i >= startCol; i--) {
                mat[endRow][i] = num;
                num++;
            }
            for (int i = endRow - 1; i > startRow; i--) {
                mat[i][startCol] = num;
                num++;
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
