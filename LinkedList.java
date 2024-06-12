// import java.util.*;

class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    public Node temp = null;

    public void addNode(int data) {
        Node newnode = new Node(data);

        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    public int countNode() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
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

    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("Linked List is empty");
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverseList() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

}

class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head, tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    void addRevNode(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
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

    public void reverse() {

        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();

        list.addNode(1);
        list.addNode(2);
        list.addNode(5);
        list.addNode(3);
        list.addNode(4);
        // list2.addNode(1);
        // list2.addNode(2);
        // list2.addNode(3);
        // list2.addNode(4);
        // list2.addNode(5);

        // list.display();
        // list.reverseList();
        list.display();
        // System.out.println("Total number of nodes: " + list.countNode());
        System.out.println("max, mix of list : " + list.findMax() + " " + list.findMin());
        // list2.display();

        // list2.addRevNode(6);
        // list2.addRevNode(7);
        // list2.addRevNode(8);
        // list2.addRevNode(9);
        // list2.addRevNode(10);
        // list2.display();
        // list2.reverse();
        // list2.display();

    }
}