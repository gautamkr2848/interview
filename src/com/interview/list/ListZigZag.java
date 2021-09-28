package com.interview.list;

public class ListZigZag {

    public Node zigZag(Node head){
        boolean flag = true;

        Node current = head;
        int temp;
        while (current != null && current.next != null) {
            if (flag == true) {
                if (current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            } else{
                if (current.data < current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }

            current = current.next;
            flag = !(flag);
        }
        return head;
    }
}
