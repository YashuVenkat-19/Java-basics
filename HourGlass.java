// HourGlass

//  1 1 1 0 0 0
//  0 1 0 0 0 0
//  1 1 1 0 0 0
//  0 0 2 4 4 0
//  0 0 0 2 0 0
//  0 0 1 2 4 0

//  2 4 4
//    2    
//  1 2 4

// output:19

// You are using Java
import java.util.*;

class HourGlass {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int[][] A = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                A[i][j] = scan.nextInt();
            }
        }

        int[][] B = new int[3][3];

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        B[k][l] = A[i + k][j + l];
                    }
                }
                sum = Math.max(display(B), sum);
            }
        }

        System.out.println(sum);
    }

    public static int display(int[][] B) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += B[i][j];
                // System.out.print(B[i][j]+" ");
            }
            // System.out.println();
        }

        return sum;
    }
}