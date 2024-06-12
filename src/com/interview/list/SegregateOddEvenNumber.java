package com.interview.list;

public class SegregateOddEvenNumber {

    public static Node segregateEvenOdd(Node head) {

        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
        Node curr = head;

        while(curr != null) {
            int element = curr.data;

            if(element % 2 == 0) {

                if (evenStart == null)
                    evenStart = curr;
                else
                    evenEnd.next = curr;

                evenEnd = curr;

            } else {

                if (oddStart == null)
                    oddStart = curr;
                else
                    oddEnd.next = curr;

                oddEnd = curr;
            }
            curr = curr.next;   // Move head pointer one step in forward direction
        }

        if(oddStart == null || evenStart == null) {
            return null;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        head=evenStart;

        return head;
    }

    public static void main(String[] args){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node curr = segregateEvenOdd(node);
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }
}
