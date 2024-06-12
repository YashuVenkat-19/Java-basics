import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // level order traversal
        while (true) {
            int n = scan.nextInt();
            if (n < 0) {
                break;
            }
            insert(n);
        }
        printLevelOrder();
        // returns false because we have set the tree insertion
        // in such a way that left side is smaller and right is greater
        // right greater -> then sum place is lesser
        // so reurns false
        // System.out.println(isSumTree(root));
        scan.close();
    }

    static Node root;

    // is sum tree

    static int sum(Node current) {
        if (current == null) {
            return 0;
        }
        return (sum(current.left) + current.data + sum(current.right));
    }

    static boolean isSumTree(Node current) {
        int ls, rs;
        if (current == null || (current.left == null && current.right == null)) {
            return false;
        }

        ls = sum(current.left);
        rs = sum(current.right);

        // check if the node data is the sum
        if ((current.data == ls + rs) && isSumTree(current.left) && isSumTree(current.right)) {
            return true;
        }

        return false;
    }

    static void printLevelOrder() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
            System.out.println();
        }
    }

    static void reversePrintLevelOrder() {
        int h = height(root);
        for (int i = h; i >= 1; i++) {
            printCurrentLevel(root, i);
            System.out.println();
        }
    }

    static void printCurrentLevel(Node current, int level) {
        if (current == null) {
            return;
        }
        if (level == 1) {
            System.out.println(current.data);
        } else if (level > 1) {
            printCurrentLevel(current.left, level - 1);
            printCurrentLevel(current.right, level - 1);
        }
    }

    static int height(Node current) {
        if (current == null) {
            return 0;
        }

        int l = height(current.left);
        int r = height(current.right);

        return Math.max(l, r) + 1;
    }

    static void insert(int data) {
        root = insertRec(root, data);
    }

    static Node insertRec(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = insertRec(current.left, data);
        } else if (data > current.data) {
            current.right = insertRec(current.right, data);
        }
        return current;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
