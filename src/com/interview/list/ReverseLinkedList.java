package com.interview.list;

public class ReverseLinkedList {

    public Node reverseList(Node head){

        Node prev = null;
        Node next = null;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
