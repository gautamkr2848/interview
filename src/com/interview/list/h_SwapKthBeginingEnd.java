package com.interview.list;

        /*Input: 1 -> 2 -> 3 -> 4 -> 5, K = 2
        Output: 1 -> 4 -> 3 -> 2 -> 5
        Explanation: The 2nd node from 1st is 2 and
        2nd node from last is 4, so swap them.*/

public class h_SwapKthBeginingEnd {

    public void swapKthBeginingEnd(){
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(4);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(2);

        int n = 2;
        int count = 1;
        Node first = head, slow = head, fast = head;
        while(fast.next != null){
            fast = fast.next;
            count++;
            if(count > n)
                slow = slow.next;
            else
                first = first.next;
        }

        int temp = first.data;
        first.data = slow.data;
        slow.data = temp;

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
