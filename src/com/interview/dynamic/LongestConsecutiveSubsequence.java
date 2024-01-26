package com.interview.dynamic;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
//Output: 4
//Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
//
//Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
//Output: 5
//Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.

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

    public int findLongestConseqSubseq(int arr[], int n) {
        Set<Integer> s = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        for (int i = 0; i < n; ++i) {
            if (!s.contains(arr[i] - 1)) {      // if current element is the starting element of a sequence Then check for next elements
                int j = arr[i];
                while (s.contains(j)){
                    s.remove(Integer.valueOf(j));//this will improve runtime by avoiding the repetitive counts of elements
                    j++;
                }

                if (ans < j - i)       // update  optimal length if this length is more
                    ans = j - i;
            }
        }
        return ans;
    }

    //Time complexity: O(N)
    //Auxiliary space: O(N)

    public int findLongestConseqSubseq_2(int arr[], int n) {
        Set<Integer> s = new HashSet<>();
        int maxLength = 0, currLength = 0;

        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        for (int i = 0; i < n; ++i) {
            if(s.contains(arr[i]-1))
                currLength++;
            else
                currLength = 1;

            if(maxLength < currLength)
                maxLength = currLength;
        }
        return maxLength;
    }
}
