package com.interview.list;

public class DetectAndRemoveLoop {

    public Node detectLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return slow;
        }
        return null;
    }

    public void removeLoop(Node head) {
        Node meet = detectLoop(head);
        Node curr = head;
        Node prev = null;

        while (curr != meet){
            prev = meet;
            curr = curr.next;
            meet = meet.next;
        }

        prev.next = null;
    }
}
