package properDS;

import java.util.Scanner;

public class SinglyLinkedList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        SinglyLinkedList sll = new SinglyLinkedList();
        while (n != 0) {
            n--;
            int data = scan.nextInt();
            sll.addNode(data);
        }
        sll.display();
        scan.nextLine();
        int a = scan.nextInt();
        sll.addNodeFront(a);
        sll.display();
        sll.addNodeIndex(scan.nextInt(), scan.nextInt());
        sll.display();
        scan.close();
    }

    public class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        // add at the end
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addNodeFront(int data) {
        // add at the front
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addNodeIndex(int index, int data) {
        // add at the index
        Node newNode = new Node(data);
        Node current = head;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index > len() + 1) {
            System.out.println("Enter a index less then " + len());
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public int len() {
        Node current = head;
        int l = 0;
        if (head == null) {
            return 0;
        } else {
            while (current != null) {
                l++;
                current = current.next;
            }
            return l;
        }
    }

    public void deleteNode(int index) {
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else if (index > len()) {
            System.out.println("Enter an index less than " + len());
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void deleteLastNode() {
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else {
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else {
            head = head.next;
        }
    }

    public void deleteNodeValue(int data) {
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else {
            while (current.next.data != data) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void replace(int index, int data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.data = data;
        }
    }

    // Method to reverse the linked list
    public void reverse() {
        Node prev = null; // Initialize a pointer to the previous node
        Node current = head; // Start from the head of the list
        Node next = null; // Initialize a pointer to the next node

        // Traverse through the list, reversing the links
        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the link of the current node to point to the previous node
            prev = current; // Move prev to the current node
            current = next; // Move current to the next node
        }
        head = prev; // Set the head of the list as the last node (previously, the first node)
    }

    public int findMax() {
        int max = Integer.MIN_VALUE;
        Node current = head;

        while (current != null) {
            max = Math.max(current.data, max);
            current = current.next;
        }

        return max;
    }

    public int findMin() {
        int min = Integer.MAX_VALUE;
        Node current = head;

        while (current != null) {
            min = Math.min(current.data, min);
            current = current.next;
        }

        return min;
    }

    public void printIndex(int index) {
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (index > len()) {
            System.out.println("Enter a value less than " + len());
            return;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println(current.data);
    }

    // palindrome

    // swap nodes

    // remove duplicates

    // merge two sorted list

}
