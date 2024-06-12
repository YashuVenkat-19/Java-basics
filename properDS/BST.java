package properDS;

import java.util.Scanner;

// height of tree
// sum of leaf nodes 
// search, insert, traversal
public class BST {

    // public static void main(String[] args) {

    // BinarySearchTree tree = new BinarySearchTree();

    // Scanner scan = new Scanner(System.in);

    // while (scan.hasNextInt()) {
    // tree.insert(scan.nextInt());
    // }

    // System.out.println(tree.search(3));

    // tree.inorderTraversal();

    // System.out.println();
    // System.out.println(tree.heightOfTree());

    // scan.close();
    // }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        while (true) {
            int data = scan.nextInt();
            if (data < -1) {
                break;
            } else {
                tree.insert(data);
            }
        }

        tree.inorderTraversal();
        System.out.println(tree.sumOfLeafNodes());
        scan.close();
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    public void insert(int data) {
        root = recursiveInsert(root, data);
    }

    public Node recursiveInsert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = recursiveInsert(current.left, data);
        }

        if (data > current.data) {
            current.right = recursiveInsert(current.right, data);
        }

        return current;
    }

    public boolean search(int data) {
        return recursiveSearch(root, data);
    }

    public boolean recursiveSearch(Node current, int data) {
        if (current == null) {
            return false;
        }
        if (current.data == data) {
            return true;
        }
        if (data < current.data) {
            return recursiveSearch(current.left, data);
        } else {
            return recursiveSearch(current.right, data);
        }

    }

    public void inorderTraversal() {
        recursiveInorder(root);
    }

    public void recursiveInorder(Node current) {
        if (current != null) {
            recursiveInorder(current.left);
            System.out.print(current.data + " ");
            recursiveInorder(current.right);
        }
    }

    public int heightOfTree() {
        return recursiveHeight(root);
    }

    public int recursiveHeight(Node current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = recursiveHeight(current.left);
        int rightHeight = recursiveHeight(current.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int sumOfLeafNodes() {
        return recursiveSumOfLeafNodes(root);
    }

    public int recursiveSumOfLeafNodes(Node current) {
        if (current == null) {
            return 0;
        }

        if (current.left == null && current.right == null) {
            return current.data;
        }

        return recursiveSumOfLeafNodes(current.left) + recursiveSumOfLeafNodes(current.right);
    }

}
