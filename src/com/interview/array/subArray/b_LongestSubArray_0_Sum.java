package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

public class b_LongestSubArray_0_Sum {

    public void longestSubArray_0_Sum(){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int length = 0;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum = sum + arr[j];
                if(sum == 0 && length < j-i+1)
                    length = j-i+1;
            }
        }
        System.out.println(length);
    }

    public void longestSubArray_0_Sum_2(){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int sum = 0, maxLen = 0, k = 0;
        Map<Integer, Integer> map= new HashMap<>(); //Key as sum, value as length

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k)   // when subarray starts from index '0'
                maxLen = i + 1;

            if (!map.containsKey(sum))
                map.put(sum, i);

            if (map.containsKey(sum - k)) {
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }
        System.out.println(maxLen);
    }
}
