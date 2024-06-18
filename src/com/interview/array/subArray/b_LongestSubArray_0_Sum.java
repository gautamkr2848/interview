package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

// 15, -2, 2, -8, 1, 7, 10, 23
// 15, 13, 15, 7, 8, 15, 25, 48

public class b_LongestSubArray_0_Sum {

    public static void longestSubArray_0_Sum_2(){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int currSum = 0, maxLen = 0, sum = 0;
        Map<Integer, Integer> map= new HashMap<>(); //Key as sum, value as length

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if(currSum == sum)
                maxLen = i+1;
            else {
                if(map.containsKey(currSum - sum)){
                    maxLen = Math.max(maxLen, (i - map.get(currSum-sum)));
                } else {
                    map.put(currSum, i);
                }
            }
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        longestSubArray_0_Sum_2();
    }
}
