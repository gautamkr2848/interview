package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

public class b_LongestSubArray_0_Sum {

    public void longestSubArray_0_Sum_2(){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int currSum = 0, maxLen = 0, sum = 0;
        Map<Integer, Integer> map= new HashMap<>(); //Key as sum, value as length

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == sum)   // when subarray starts from index '0'
                maxLen = i + 1;

            if (!map.containsKey(currSum))
                map.put(currSum, i);

            if (map.containsKey(currSum - sum)) {
                if (maxLen < (i - map.get(currSum - sum)))
                    maxLen = i - map.get(currSum - sum);
            }
        }
        System.out.println(maxLen);
    }
}
