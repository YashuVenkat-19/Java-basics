import java.util.Scanner;

class Stack {
    int top;
    int size;
    int[] stack;

    public Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stack[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            // top--;
            // stack[top] = 0;
            return stack[top--];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            stack.push(scan.nextInt());
        }

        stack.display();
        stack.pop();
        stack.display();

    }

}
