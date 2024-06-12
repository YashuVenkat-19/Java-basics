public class Strobogrammatic {
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("80088"));
    }

    public static boolean isStrobogrammatic(String num) {
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7') {
                return false;
            }
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            char c1 = num.charAt(left);
            char c2 = num.charAt(right);
            if (c1 == '6' && c2 == '9' || c1 == '9' && c2 == '6' || c1 == '1' && c2 == '1' || c1 == '8' && c2 == '8'
                    || c1 == '0' && c2 == '0') {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
