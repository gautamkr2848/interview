package com.interview.list;

public class g_lastFromEnd {

    public int getNthFromLast(Node head, int n){
        Node fast = head, slow = head;
        int start = 1;

        while(fast.next != null) {
            fast = fast.next;
            start++;
            if(start > n)
                slow = slow.next;
        }
        if(start < n) return -1;
        return slow.data;
    }
}
