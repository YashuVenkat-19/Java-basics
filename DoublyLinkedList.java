//doubly linked list

//node class
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
            size++;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            current.next.prev = current;
            size--;
        }
    }

    // print
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // main
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.add(7, 0);
        dll.add(8, 3);
        dll.add(9, 8);
        dll.print();
        dll.removeFirst();
        dll.removeLast();
        dll.remove(3);
        dll.print();
    }
}