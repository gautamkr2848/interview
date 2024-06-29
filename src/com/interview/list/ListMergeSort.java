package com.interview.list;

public class ListMergeSort {

    public static Node mergeSort(Node head){
        if (head == null || head.next == null)
            return head;

        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;
        Node newHead1 = mergeSort(head);
        Node newHead2 = mergeSort(head2);
        Node finalHead = merge(newHead1, newHead2);

        return finalHead;
    }

//    private static Node merge(Node head1, Node head2) {
//        Node merged = new Node(-1);
//        Node temp = merged;
//
//        while (head1 != null && head2 != null) {
//            if (head1.data < head2.data) {
//                temp.next = head1;
//                head1 = head1.next;
//            } else {
//                temp.next = head2;
//                head2 = head2.next;
//            }
//            temp = temp.next;
//        }
//
//        while (head1 != null) {
//            temp.next = head1;
//            head1 = head1.next;
//            temp = temp.next;
//        }
//
//        while (head2 != null) {
//            temp.next = head2;
//            head2 = head2.next;
//            temp = temp.next;
//        }
//        return merged.next;
//    }

    private static Node merge(Node a, Node b) {
        if(a == null)
            return b;

        if(b == null)
            return a;

        Node result = null;
        if(a.data <= b.data) {
            result = a;
            a.next = merge(a.next, b);
        } else {
            result = b;
            b.next = merge(a, b.next);
        }

        return result;
    }

    private static Node findMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node node = new Node(6);
        node.next = new Node(5);
        node.next.next = new Node(11);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(2);

        node = mergeSort(node);

        Node curr = node;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
