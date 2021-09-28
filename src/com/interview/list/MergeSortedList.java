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

    public Node mergeList_3(Node h1, Node h2){
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        if (h1.data < h2.data) {
            h1.next = mergeList_3(h1.next, h2);
            return h1;
        } else {
            h2.next = mergeList_3(h1, h2.next);
            return h2;
        }
    }
}


