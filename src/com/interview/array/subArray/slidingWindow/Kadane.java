package com.interview.array.subArray.slidingWindow;

public class Kadane {

    public int Kadane(int[] a){

        int maxSum = a[0];
        int currMax = a[0];

        for (int i = 1; i < a.length; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSum = Math.max(maxSum, currMax);
        }
        return maxSum;
    }

    public void maxSumSubArray(){
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = a[0], currMax = 0;

        for (int i = 0; i < a.length; i++) {
            currMax = currMax + a[i];
            if (currMax < 0)
                currMax = 0;
            else if (maxSum < currMax)
                maxSum = currMax;

        }
        System.out.println(maxSum);
    }
}
