package com.interview.list;

public class ListSortByAbsoluteValue {

    public Node sortedList() {

        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(-2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(-5);

        Node prev = head;
        Node curr = head.next;

        while(curr != null) {
            if(curr.data < prev.data) {
                prev.next = curr.next;      // Detach curr from linked list
                curr.next = head;       // Move current node to beginning
                head = curr;
                curr = prev;        // Update current
            } else
                prev = curr;

            curr = curr.next;       // Move current
        }
        return head;
    }
}
