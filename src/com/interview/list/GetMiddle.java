package com.interview.list;

public class GetMiddle {

    public void getMiddle() {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(9);
        int count  = count(head);

        System.out.print(getElement(head, (count/2 )));
    }

    int getElement(Node node, int pos){
        Node tmp = node;
        while(pos > 0){
            tmp = tmp.next;
            pos--;
        }
        return tmp.data;
    }

    int count(Node head){
        int count =0;
        Node tmp = head;
        while(tmp != null){
            count++;
            tmp= tmp.next;
        }
        return count;
    }
}
