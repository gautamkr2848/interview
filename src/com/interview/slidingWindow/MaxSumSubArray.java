package com.interview.slidingWindow;

public class MaxSumSubArray {

    public void maxSumSubArray(){
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int size = 4;
        int max = 0;
        int sum = 0;
        for(int i=0; i<size; i++)
            sum = sum + arr[i];

        for(int i=1, j=size; j<arr.length; i++, j++){
            sum = sum + arr[j] - arr[i-1];
            if(sum > max)
                max = sum;
        }
        System.out.println(max);
    }
}
