package com.interview.array.subArray;

/*A[] = {1,2,3,-4,5}
forward = {1, 3, 6, 2, 7}
backward = {7, 6, 4, 1, 5}
        Output: 11*/
public class f_MaxSumSubarrayByRemovingAtMostOneElement {

    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int oneDelete = 0, noDelete = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            oneDelete = Math.max(oneDelete + arr[i], noDelete);
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            max = Math.max(max, Math.max(oneDelete, noDelete));
        }
        return max;
    }

    // Driver code
    public static void main(String arg[]) {
        int arr[] =  {1,2,3,-4,5};
        System.out.print( maximumSum(arr));
    }
}
