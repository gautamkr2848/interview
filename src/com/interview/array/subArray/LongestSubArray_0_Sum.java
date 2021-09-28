package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArray_0_Sum {

    public void longestSubArray_0_Sum(){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int max_len = 0;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum = sum + arr[j];
                if(sum == 0 && max_len < j-i+1)
                    max_len = j-i+1;
            }
        }
        System.out.println(max_len);
    }

    public void longestSubArray_0_Sum_2(){
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int sum = 0, max_len = 0;
        Map<Integer, Integer> map= new HashMap<>(); //Key as sum, value as length
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            Integer curr_len = map.get(sum);

            if (curr_len != null)
                max_len = Math.max(max_len, i - curr_len);
            else
                map.put(sum, i);
        }
        System.out.println(max_len);
    }
}
