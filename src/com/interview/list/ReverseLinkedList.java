package com.interview.list;

public class ReverseLinkedList {

    public Node reverseList(Node head){

        Node prev = null, next;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // 1    2   3   4
    // 2    3   4
    // 3    4
    // 4
    // 4    3
    // 4    3   2
    // 4    3   2   1

    public Node reverseListRecurrsion(Node head){

        if(head == null || head.next == null)
            return head;

        Node newHead = reverseListRecurrsion(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
