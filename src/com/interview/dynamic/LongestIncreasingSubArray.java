package com.interview.dynamic;

public class LongestIncreasingSubArray {

    public void longestIncreasingSubArray(int[] arr,int n){
        int max = 1, len = 1;
        for (int i=1; i<n; i++) {
            if (arr[i] > arr[i-1])
                len++;
            else {
                if (max < len)
                    max = len;
                len = 1;
            }
        }

        if (max < len)
            max = len;
        System.out.println(max);
    }
}
