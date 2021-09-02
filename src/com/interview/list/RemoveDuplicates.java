package com.interview.list;

public class RemoveDuplicates {
    public Node removeDuplicates(Node head){
        Node curr = head;

        while (curr != null) {
            Node temp = curr;

            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp != null && temp.data == curr.data)
                temp = temp.next;

            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
}
