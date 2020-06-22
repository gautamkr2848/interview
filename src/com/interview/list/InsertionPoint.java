package com.interview.list;

import java.util.HashSet;

public class InsertionPoint {

    public void insertionPoint(Node n1, Node n2){
        HashSet<Node> set = new HashSet<>();
        while (n1 != null) {
            set.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (set.contains(n2))
                System.out.println(n2);
            n2 = n2.next;
        }
        System.out.println("null");
    }
}
