package com.interview.list;

public class ListPelindrome {

    public boolean isPelindrome(Node head) {
        if(head == null || head.next == null)
            return true;

        GetMiddle getMiddle = new GetMiddle();
        Node middle = getMiddle.getMiddle();

        ReverseLinkedList rl = new ReverseLinkedList();
        Node secondHalfStart = rl.reverseList(middle.next);
        Node firstHalfStart = head;

        while (secondHalfStart != null) {
            if(firstHalfStart.data != secondHalfStart.data)
                return false;

            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
}
