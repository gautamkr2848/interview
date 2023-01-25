package com.interview.array.subArray;

public class d_MaxProductSubArray {

    public void maxProduct(){
        int[] arr = { 6, -3, -10, 0, 2 };
        int n = arr.length;
        int minVal = arr[0];
        int maxVal = arr[0];
        int maxProduct = arr[0];

        for (int i = 1; i < n; i++) {

            // When multiplied by -ve number, maxVal becomes minVal and minVal becomes maxVal.
            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            maxProduct = Math.max(maxProduct, maxVal);
        }
        System.out.println(maxProduct);
    }

    public int maxSubarrayProduct(int arr[], int n) {

        int max_ending_here = arr[0];
        int min_ending_here = arr[0];
        int max_so_far = arr[0];

        for (int i = 1; i < n; i++) {
            int temp = max(arr[i], arr[i] * max_ending_here, arr[i] * min_ending_here);
            min_ending_here = min(arr[i], arr[i] * max_ending_here, arr[i] * min_ending_here);
            max_ending_here = temp;
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    private int max(int x, int y, int z) {
        if(x < y)
            return (y < z) ? z : y;
        else
            return (x < z) ? z : x;
    }

    private int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }
}
