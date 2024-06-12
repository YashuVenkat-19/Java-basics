import java.util.Queue;
import java.util.LinkedList;
// import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeByInsertingFromQueue {
    // write a Node class of tree
    // write a queue of Node in main method
    // get input and append in queue
    // if root null then create root
    // getinput from and enqueue it in queue
    // insert the elements of queue in tree one by one.
    // if element inserted then pop from queue

    public static void main(String[] args) {
        // create a queue
        Queue<Node> queue = new LinkedList<>();
        Node root = null;
        // get input
        int[] input = { 1, 2, 3, 4, 5, 6, 7 };
        for (int i = 0; i < input.length; i++) {
            Node newNode = new Node(input[i]);
            if (root == null) {
                root = newNode;
            } else {
                Node temp = queue.peek();
                if (temp.left == null) {
                    temp.left = newNode;
                } else {
                    temp.right = newNode;
                    queue.remove();
                }
            }
            queue.add(newNode);
        }
        print(root);
    }

    // print
    public static void print(Node root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

}