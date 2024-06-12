import java.util.Scanner;

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

    // deletion
    // if the node to be deleted id a leaf node, then simply delete the node
    // if the node to be deleted has one child, then copy the child to the node and
    // delete the child
    // if the node to be deleted has two children,
    // then find the inorder successor of the node.
    // Copy the inorder successor to the node and delete the inorder successor

    public void delete(int data) {
        root = recursiveDelete(root, data);
    }

    public Node recursiveDelete(Node current, int data) {
        if (current == null) {
            return null;
        }

        if (data == current.data) {
            // if leaf node
            if (current.left == null && current.right == null) {
                return null;
            }

            // if one child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // if two children: get the inorder successors (smallest in the right subtree)
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = recursiveDelete(current.right, smallestValue);
            return current;
        }

        if (data < current.data) {
            current.left = recursiveDelete(current.left, data);
            return current;
        }

        current.right = recursiveDelete(current.right, data);
        return current;
    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

}

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
            if (data <= -1) {
                break;
            } else {
                tree.insert(data);
            }
        }

        tree.inorderTraversal();
        System.out.println(tree.sumOfLeafNodes());

        tree.delete(5);
        tree.inorderTraversal();
    }

}
