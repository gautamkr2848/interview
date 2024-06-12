package com.interview.list;

/*
Input : 1 -> -2 -> -3 -> 4 -> -5
output: -5 -> -3 -> -2 -> 1 -> 4
*/

public class ListSort {

    public static void sortList() {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(-2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(-5);

        Node current = head, index = null;
        int temp;

        if (head == null)
            return;

        while (current != null) {   // Node index will point to node next to current
            index = current.next;

            while (index != null) {
                // If current node's data is greater
                // than index's node data, swap the data between them
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }

        current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        sortList();
    }
}
