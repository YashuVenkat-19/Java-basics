// you can generate fib numbers and add in the list, simple
// instead of this you can do the above method 

public class fibo {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail1 = null;
    public Node tail2 = null;

    public void addNode(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail1 = newnode;
        } else {
            tail1.next = newnode;
            tail1 = newnode;
        }
    }

    public void fib(int n) {
        if (head == null) {
            Node firstnode = new Node(0);
            Node secondnode = new Node(1);
            head = firstnode;
            tail1 = firstnode;
            tail2 = secondnode;
            tail1.next = tail2;

            tail2.next = null;
        } else {
            Node newnode = new Node(tail1.data + tail2.data);
            tail1.next = tail2;
            tail1 = tail2;
            tail2.next = newnode;
            tail2 = newnode;
        }
        System.out.println(head);
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        fibo f = new fibo();
        // f.fib(5);
        int a = 0;
        int b = 1;
        int n = 10;
        f.addNode(a);
        f.addNode(b);
        while (n != 0) {
            f.addNode(a + b);
            int t = a + b;
            a = b;
            b = t;
            n--;
        }
        f.display();
    }

}