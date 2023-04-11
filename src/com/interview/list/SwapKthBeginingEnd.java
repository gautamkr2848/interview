package com.interview.list;

        /*Input: 1 -> 2 -> 3 -> 4 -> 5, K = 2
        Output: 1 -> 4 -> 3 -> 2 -> 5
        Explanation: The 2nd node from start is 2 and
        2nd node from last is 4, so swap them.*/

public class SwapKthBeginingEnd {

    public void swapKthBeginingEnd_2(){
        Node head = new Node(11);
        head.next = new Node(10);
        head.next.next = new Node(13);
        head.next.next.next = new Node(17);
        head.next.next.next.next = new Node(9);

        int k = 2;
        int n = countNodes(head);
        if (n < k) return;

        int endNode = n - k + 1;

        // If x (kth node from start) and y(kth node from end) are same
        if (2*k - 1 == n)
            return;

        Node slow = head, fast = head;
        Node slowP = null, fastP = null;

        int i=0;
        while (i<k-1){
            slowP = slow;
            slow = slow.next;
            i++;
        }

        i = 0;
        while(i<endNode-1){
            fastP = fast;
            fast = fast.next;
            i++;
        }

        Node tmp = slow.next;
        slow.next= fast.next;
        fast.next = tmp;

        slowP.next = fast;
        fastP.next = slow;

    }

    int countNodes(Node head){
        int count = 0;
        Node s = head;
        while (s != null) {
            count++;
            s = s.next;
        }
        return count;
    }
}
