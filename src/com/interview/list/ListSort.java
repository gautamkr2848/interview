package com.interview.list;

/*
Input : 1 -> -2 -> -3 -> 4 -> -5
output: -5 -> -3 -> -2 -> 1 -> 4
*/

public class ListSort {

    public Node sortedList() {

        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(-2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(-5);

        Node curr = head;
        Node next = head.next;

        while(next != null) {
            if(next.data < curr.data) {
                curr.next = next.next;      // Detach next from linked list
                next.next = head;       // Move current node to beginning
                head = next;
                next = curr;        // Update current
            } else
                curr = next;

            next = next.next;       // Move current
        }
        return head;
    }
}
