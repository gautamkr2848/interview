package com.interview.list;

        /*Input: 1 -> 2 -> 3 -> 4 -> 5, K = 2
        Output: 1 -> 4 -> 3 -> 2 -> 5
        Explanation: The 2nd node from 1st is 2 and
        2nd node from last is 4, so swap them.*/

public class SwapKthBeginingEnd {

    public void swapKthBeginingEnd(Node head, int k){
        int n = countNodes(head);
        if (n < k) return;

        // If x (kth node from start) and y(kth node from end) are same
        if (2*k - 1 == n)
            return;

        Node x = head;
        Node x_prev = null;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        Node y = head;
        Node y_prev = null;
        for (int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }

        if (x_prev != null)
            x_prev.next = y;

        // Same thing applies to y_prev
        if (y_prev != null)
            y_prev.next = x;

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        if (k == 1)
            head = y;

        if (k == n)
            head = x;
    }

    int countNodes(Node head){
        int count = 0;
        Node s = head;
        while (s != null)
        {
            count++;
            s = s.next;
        }
        return count;
    }
}
