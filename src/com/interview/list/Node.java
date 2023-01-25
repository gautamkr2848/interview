package com.interview.list;

public class Node {
    public int data;
    public Node next;

    public Node(int d) {
        data = d;
        next = null;
    }

    public static Node list(int[] a){
        Node head = new Node(a[0]);
        Node curr = head;
        for(int i=1; i<a.length; i++){
            curr.next = new Node(a[i]);
            curr = curr.next;
        }
        return head;
    }
}
