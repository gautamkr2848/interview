package com.interview.dynamic;

import java.util.PriorityQueue;

public class LongestConsecutiveSubsequence {

    public void longestConsecutiveSubsequence(){

        int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
        int N = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) 
            pq.add(arr[i]);
        
        int prev = pq.poll();
        int currLength = 1;      // Taking a counter variable with value 1
        int max = 1;        // Storing value of max as 1 as there will always be one element

        for (int i = 1; i < N; i++) {
            if (pq.peek() - prev > 1) {
                currLength = 1;      // Store the value of counter to 1  As new sequence may begin
                prev = pq.poll();       // Update the previous position with the current peek And remove it
            } else if (pq.peek() - prev == 0)     // Check if the previous element and peek are same
                prev = pq.poll();       // Update the previous position with the current peek And remove it
            else {      // if the difference between previous element and peek is 1
                currLength++;        // Update the counter These are consecutive elements
                prev = pq.poll();       // Update the previous position with the current peek And remove it
            }
            
            max = Math.max(max, currLength);
        }
        System.out.println(max);
    }
}
