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

    public int maxSumSubarray(){
        int[] arr = {1,2,3,-4,5};
        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        int currMax = arr[0], max_so_far = arr[0];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            max_so_far = Math.max(max_so_far, currMax);
            left[i] = currMax;
        }

        currMax = max_so_far = right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            max_so_far = Math.max(max_so_far, currMax);
            right[i] = currMax;
        }

        int ans = max_so_far;
        for (int i = 1; i < n - 1; i++)
            ans = Math.max(ans, left[i - 1] + right[i + 1]);

        return ans;
    }
}
