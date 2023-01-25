package com.interview.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedList {

    public void mergeSortedList(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(5);
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();

        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) < list2.get(j))
                list3.add(list1.get(i++));
            else
                list3.add(list2.get(j++));
        }

        while(i< list1.size())
            list3.add(list1.get(i++));
        while (j < list2.size())
            list3.add(list2.get(j++));

        System.out.println(list3.toString());
    }

    public Node mergeKLists(Node arr[]) {
        Node dummy = new Node(-1);
        for(int i=0; i<arr.length; i++){
            dummy = mergeList_3(dummy, arr[i]);
        }
        return dummy.next;
    }

    private Node mergeList_3(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.next = mergeList_3(a.next, b);
        } else {
            result = b;
            result.next = mergeList_3(a, b.next);
        }
        return result;
    }
}


