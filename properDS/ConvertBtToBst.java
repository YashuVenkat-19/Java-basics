package properDS;

import java.util.Arrays;
import java.util.Scanner;

// convert bt to bst
// bt has no order of insertion, bst has order
// in bst, left side must always be lesser and right must be greater
public class ConvertBtToBst {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        BT bt = new BT();
        ConvertBtToBst convert = new ConvertBtToBst();
        while (true) {
            int n = scan.nextInt();
            if (n < 0) {
                break;
            } else {
                bt.insertBt(n);
                // bst.insertBst(n);
            }
        }

        bt.inorderBt();
        System.out.println();
        System.out.println();

        // convert
        Node bstStartNode = convert.convertBTBST(bt.root);
        bst.recursiveInorderBst(bstStartNode);

        scan.close();
    }

    Node root;

    int[] treeArray;
    int index = 0;

    // Algorithm
    // to convert a bt to bst, create a array of size of bt
    // and then sort the array and form bst using mid as root
    public Node convertBTBST(Node node) {

        // calculate size to declare array
        int size = calculateSize(node);
        treeArray = new int[size];

        // put elements in bt to an array
        convertBtToArray(node);

        // sort
        Arrays.sort(treeArray);

        // return the starting node of bst
        //
        Node bstStartNode = createBst(0, treeArray.length - 1);
        return bstStartNode;
    }

    public int calculateSize(Node node) {
        if (node == null) {
            return 0;
        }

        return calculateSize(node.left) + calculateSize(node.right) + 1;
    }

    public void convertBtToArray(Node node) {
        if (node == null) {
            return;
        }
        // till last in left side
        if (node.left != null) {
            convertBtToArray(node.left);
        }

        // add in-order node to array
        treeArray[index] = node.data;
        index++;

        // till last in right side
        if (node.right != null) {
            convertBtToArray(node.right);
        }

    }

    public Node createBst(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(treeArray[mid]);
        node.left = createBst(start, mid - 1);
        node.right = createBst(mid + 1, end);

        return node;
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BST {
    Node root;

    public void insertBst(int data) {
        root = recursiveInsertBst(root, data);
    }

    public Node recursiveInsertBst(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            return recursiveInsertBst(root.left, data);
        } else if (data > root.data) {
            return recursiveInsertBst(root.right, data);
        }

        return root;
    }

    public void inorderBst() {
        recursiveInorderBst(root);
    }

    public void recursiveInorderBst(Node root) {
        if (root == null) {
            return;
        }
        recursiveInorderBst(root.left);
        System.out.print(root.data + "   ");
        recursiveInorderBst(root.right);
    }

}

class BT {
    Node root;

    public void insertBt(int data) {
        root = recursiveInsertBt(root, data);
    }

    public Node recursiveInsertBt(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.left == null) {
            root.left = recursiveInsertBt(root.left, data);
        } else {
            root.right = recursiveInsertBt(root.right, data);
        }

        return root;
    }

    public void inorderBt() {
        recursiveInorderBt(root);
    }

    public void recursiveInorderBt(Node root) {
        if (root == null) {
            return;
        }
        recursiveInorderBt(root.left);
        System.out.print(root.data + " ");
        recursiveInorderBt(root.right);
    }
}
