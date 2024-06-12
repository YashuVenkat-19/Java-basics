import java.util.*;

// from pre order print postorder and inorde
// print vertically
// print level order
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // System.out.println("Preorder traversal of binary tree is ");
        // tree.printPreorder();

        // System.out.println("\nInorder traversal of binary tree is ");
        // tree.printInorder();

        // System.out.println("\nPostorder traversal of binary tree is ");
        // tree.printPostorder();

    }

    Node root;

    public void insert(int data) {
        root = recursiveInsert(root, data);
    }

    public Node recursiveInsert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        // In a Binary Tree, nodes are inserted without specific order
        // Here, we can choose to insert nodes alternately to the left and right
        if (current.left == null) {
            current.left = recursiveInsert(current.left, data);
        } else {
            current.right = recursiveInsert(current.right, data);
        }

        return current;
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