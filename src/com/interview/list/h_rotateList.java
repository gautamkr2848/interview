package com.interview.list;

public class h_rotateList {

    public void rotateList(){
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(4);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(2);

        int n = 2;

        if(n == 0) return;

        Node current = head;
        while (current != null && n > 1){
            current = current.next;
            n--;
        }

        if(current == null) return;

        Node kthNode = current;
        while (current.next != null)
            current = current.next;
        current.next = head;
        head = kthNode.next;
        kthNode.next = null;

        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
