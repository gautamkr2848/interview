package com.interview.list;

public class RemoveDuplicates {
    public Node removeDuplicates(Node head){
        Node curr = head;

        while (curr != null) {
            Node temp = curr;
            while(temp != null && temp.data == curr.data)
                temp = temp.next;

            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
}
