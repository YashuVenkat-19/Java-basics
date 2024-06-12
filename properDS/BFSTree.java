package properDS;

import java.util.Scanner;

public class BFSTree {

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
        scan.close();
    }

    static Node root;

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
