package com.interview.array.priorityQueue_heap;

import java.util.PriorityQueue;

public class c_KLargestElement {

    public void kLargestElement(){
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        int k = 2;

        PriorityQueue<Integer> q = new PriorityQueue<>();   //Collections.reverseOrder() for smallest
        for(int i = 0; i < k; i++)
            q.add(arr[i]);

        for(int i = k; i < arr.length; i++) {
            if (q.peek() <= arr[i]){    //q.peek() >= arr[i]
                q.poll();
                q.add(arr[i]);
            }
        }

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
    }
}
