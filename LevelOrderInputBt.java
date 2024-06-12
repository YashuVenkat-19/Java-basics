// Sample Input 0
// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

// Sample Output 0
// 4 2 5 1 6 3 7

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

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

public class LevelOrderInputBt {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Node root = null;
        Queue<Node> q = new LinkedList<>();
        int input;

        if (scan.hasNext()) {
            input = scan.nextInt();
            root = new Node(input);
            q.add(root);
        }
        int l = -1;
        int r = -1;
        while (scan.hasNext()) {
            l = scan.nextInt();
            if (scan.hasNext()) {
                r = scan.nextInt();
            }
            Node temp = q.poll();
            if (l != -1) {
                Node newNode = new Node(l);
                temp.left = newNode;
                q.add(newNode);
            }
            if (r != -1) {
                Node newNode = new Node(r);
                temp.right = newNode;
                q.add(newNode);
            }
        }
        print(root);
    }

    static void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }

    }
}