package com.interview.array.priorityQueue_heap;

//Given an array of n elements, where each element is at most k away from its target
// position, devise an algorithm that sorts in O(n log k) time

//Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
//            k = 3
//Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class d_KSortedArray {

    public void kSortedArray(){

        int k = 4;
        int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
        int n = arr.length;

        if (arr == null || arr.length == 0)
            return;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        List<Integer> result = new ArrayList<>();
        for (int i = k; i < n; i++) {
            pq.add(arr[i]);
            result.add(pq.poll());
        }

        while (!pq.isEmpty())
            result.add(pq.poll());

        for(int i=0; i<result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}
