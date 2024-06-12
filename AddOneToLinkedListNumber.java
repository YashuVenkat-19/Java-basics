// Input:
// LinkedList: 4->5->6
// Output: 457
// Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class AddOneToLinkedListNumber {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Node head = new Node(s.charAt(0) - '0');
            Node tail = head;
            for (int i = 1; i < s.length(); i++) {
                tail.next = new Node(s.charAt(i) - '0');
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends

/*
 * class Node{
 * int data;
 * Node next;
 * 
 * Node(int x){
 * data = x;
 * next = null;
 * }
 * }
 */

class Solution {

    public static Node addOne(Node head) {
        // code here.
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        Node temp = head;

        int carry = 1;
        while (temp.next != null) {
            carry = carry + temp.data;
            if (carry > 9) {
                temp.data = carry % 10;
                carry = carry / 10;
            } else {
                temp.data = carry;
                carry = 0;
            }
            temp = temp.next;
        }
        if (carry > 0) {
            int x = (temp.data + carry) / 10;
            int y = (temp.data + carry) % 10;
            temp.data = y;
            if (x > 0) {
                temp.next = new Node(x);
            }
        }
        Node prev1 = null;
        Node curr1 = head;
        Node next1 = null;
        while (curr1 != null) {
            next1 = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = next1;
        }
        head = prev1;

        return head;
    }

}