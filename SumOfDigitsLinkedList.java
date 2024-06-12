// Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.

// For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

// Example 1:

// Input:
// N = 2
// valueN[] = {4,5}
// M = 3
// valueM[] = {3,4,5}
// Output: 3 9 0  

// Explanation: For the given two linked
// list (4 5) and (3 4 5), after adding
// the two linked list resultant linked
// list will be (3 9 0).

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class SumOfDigitsLinkedList {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends

/*
 * node for linked list
 * 
 * class Node {
 * int data;
 * Node next;
 * 
 * Node(int d) {
 * data = d;
 * next = null;
 * }
 * }
 * 
 */

class Solution {

    static Node reverse(Node temp) {
        Node prev = null;
        Node curr = temp;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp = prev;
        return temp;
    }

    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        int carry = 0;
        Node temp1 = first;
        Node temp2 = second;
        Node sumlistHead = null;
        Node sumlistTail = null;
        while (temp1 != null && temp2 != null) {
            int s = temp1.data + temp2.data + carry;
            carry = s / 10;
            s = s % 10;
            Node newNode = new Node(s);
            if (sumlistHead == null) {
                sumlistHead = newNode;
                sumlistTail = newNode;
            } else {
                sumlistTail.next = newNode;
                sumlistTail = newNode;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            int s1 = carry + temp1.data;
            carry = s1 / 10;
            s1 = s1 % 10;
            Node newNode = new Node(s1);
            sumlistTail.next = newNode;
            sumlistTail = newNode;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            int s2 = carry + temp2.data;
            carry = s2 / 10;
            s2 = s2 % 10;
            Node newNode = new Node(s2);
            sumlistTail.next = newNode;
            sumlistTail = newNode;
            temp2 = temp2.next;
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            sumlistTail.next = newNode;
            sumlistTail = newNode;

        }

        // return temp2;
        return reverse(sumlistHead);
        // code here
        // return head of sum list

    }
}