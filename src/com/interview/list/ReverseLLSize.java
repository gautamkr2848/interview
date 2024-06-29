package com.interview.list;

public class ReverseLLSize {

    public static Node reverseLL(Node head, int k){
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

    public static void main(String[] args) {
        Node node = new Node(6);
        node.next = new Node(11);
        node.next.next = new Node(11);
        node.next.next.next = new Node(11);
        node.next.next.next.next = new Node(2);

        Node curr = reverseLL(node, 2);
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }

    }

}
