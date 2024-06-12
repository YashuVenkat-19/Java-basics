import java.util.Scanner;

public class backtracking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        int sl = s.length();
        permute(s, 0, sl - 1);
    }

    static void permute(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                permute(s, start + 1, end);
                s = swap(s, start, i);
            }
        }
    }

    static String swap(String s, int start, int i) {
        char[] ch = s.toCharArray();
        char temp = ch[start];
        ch[start] = ch[i];
        ch[i] = temp;

        return String.valueOf(ch);
    }

}
