package com.interview.slidingWindow;

public class Kadane {

    public void Kadane(){
        int[] a = {-1,-2,-3,-4};
        int maxSum = a[0];
        int currMax = a[0];

        for (int i = 1; i < a.length; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSum = Math.max(maxSum, currMax);
        }
        System.out.print(maxSum);
    }
}
