package com.interview.list;

/* 1   2   3   4   5   6   7
   1   7   2   6   3   5   4 */

public class ReOrderList {

    public Node reorderlist() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node node1 = head;
        Node node2 = slow.next;
        slow.next = null;

        node2 = reverselist(node2);
        head = new Node(0);

        Node curr = head;
        while (node1 != null || node2 != null) {

            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        return head.next;
    }

    private Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
