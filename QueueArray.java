import java.util.Scanner;

class Queue {
    int head;
    int tail;
    int size;
    int[] queue;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return tail == size - 1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (head == -1) {
                head = 0;// if it is the first element then assign the head to 0
            }
            tail++;
            queue[tail] = data;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = queue[head];
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head++;
            }
            return data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = head; i <= tail; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class QueueArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Queue queue = new Queue(n);

        for (int i = 0; i < n; i++) {
            queue.enqueue(scan.nextInt());
        }
        scan.close();
        queue.display();

        System.out.println("Popped : " + queue.dequeue());

        queue.display();
    }
}
