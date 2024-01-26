package com.interview.array.priorityQueue_heap;

import java.util.PriorityQueue;

public class a_CostToConnectRoap {

    public void costToConnectRoap(){
        int arr[] = { 4, 8, 3, 2, 6, 1, 5, 9, 7};
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();          //returns min element first

        for (int i = 0; i < arr.length; i++)
            pq.add(arr[i]);

        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result and insert the new rope to pq
            res += first + second;
            pq.add(first + second);
        }
        System.out.println(res);
    }
}
