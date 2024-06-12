import java.util.Scanner;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        StringBuffer rs = new StringBuffer(s);
        rs = rs.reverse();
        // String rss = rs.toString();
        String a = scan.nextLine();

        scan.close();
        // LCS(s, a);
        LongestCommonSubSequence(s, a);
        // LPS(s, rss);
    }

    public static void LCS(String s, String a) {
        int sl = s.length();
        int al = a.length();

        int[][] arr = new int[sl + 1][al + 1];

        int res = 0;
        for (int i = 0; i < sl + 1; i++) {
            for (int j = 0; j < al + 1; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (s.charAt(i - 1) == a.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    res = Math.max(arr[i][j], res);
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(res);
    }

    public static void LongestCommonSubSequence(String s, String a) {
        int sl = s.length();
        int al = a.length();

        int[][] arr = new int[sl + 1][al + 1];

        for (int i = 0; i < sl + 1; i++) {
            for (int j = 0; j < al + 1; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (s.charAt(i - 1) == a.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        System.out.println(arr[sl][al]);

    }

    public static void LPS(String s, String rss) {
        int sl = s.length();
        int[][] arr = new int[sl + 1][sl + 1];

        for (int i = 0; i < sl + 1; i++) {
            for (int j = 0; j < sl + 1; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (s.charAt(i - 1) == rss.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        System.out.println(arr[sl][sl]);
    }
}
