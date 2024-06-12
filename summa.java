public class summa {
    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 4);
        System.out.println(1 ^ 4);
        System.out.println(4 ^ 4);
        System.out.println(10 ^ 10);
        System.out.println(1 ^ 2);
        System.out.println(1 ^ 3);
        System.out.println(1 ^ 4);
        System.out.println(3 ^ 4);
        System.out.println(5 ^ 7);
        System.out.println(6 ^ 7);
        System.out.println(7 ^ 7);
        System.out.println(8 ^ 7);
        System.out.println(2 ^ 3);
        System.out.println(3 ^ 2);
        System.out.println(2 ^ 4);
        System.out.println(4 ^ 2);
        // x ^ x = 0
        // x ^ 0 = x
        // x ^ y = y ^ x
        // x ^ y is bitwise operation
        // 0^0 = 0
        // 0^1 = 1
        // 1^0 = 1
        // 1^1 = 0

        // 0^4 = 4, 4^0 = 4 ---> 0 xor -> with anything is same
        // 1^4 = 5, 4^1 = 5 ---> 1 xor -> with anything is different
        // 4^4 = 0 ---> anything xor with itself is 0

        // 6^7 = 1 ---- 7^7 = 0 ---- 8^7 = 15
        // ^ gives difference between two numbers before x^x
        // ^ gives sum of two numbers after x^x

    }
}