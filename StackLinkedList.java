import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    public Node head = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Popped element: " + head.data);
            head = head.next;
        }
    }

    public void peek() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element: " + head.data);
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements are: ");
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public void isEmpty() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }

    public void isFull() {
        System.out.println("Stack is never full");
    }

    public void size() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Size of stack: " + count);
    }
}

public class StackLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        // Functions called here...
    }
}
