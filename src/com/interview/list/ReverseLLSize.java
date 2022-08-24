package com.interview.list;

public class ReverseLLSize {

    public Node reverseLL(Node head, int k){
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;
        while (count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = reverseLL(next, k);

        return prev;
    }

}
