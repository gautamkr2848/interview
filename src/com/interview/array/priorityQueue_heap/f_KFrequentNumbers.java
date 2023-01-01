package com.interview.array.priorityQueue_heap;

import java.util.*;

public class f_KFrequentNumbers {

    public void kFrequentNumbers(){

        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) ->
                a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.add(entry);

        for (int i = 0; i < k; i++)
            System.out.println(queue.poll().getKey());
    }
}