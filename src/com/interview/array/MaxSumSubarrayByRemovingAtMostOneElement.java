package com.interview.array;

/*A[] = {1,2,3,-4,5}
        Output: 11*/
public class MaxSumSubarrayByRemovingAtMostOneElement {

    public int maxSumSubarray(){
        int[] arr = {1,2,3,-4,5};
        int n = arr.length;

        int forward[] = new int[n];
        int backward[] = new int[n];

        int cur_max = arr[0], max_so_far = arr[0];

        forward[0] = arr[0];
        for (int i = 1; i < n; i++) {

            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);

            forward[i] = cur_max;
        }

        cur_max = max_so_far = backward[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {

            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);

            backward[i] = cur_max;
        }

        int fans = max_so_far;

        for (int i = 1; i < n - 1; i++)
            fans = Math.max(fans, forward[i - 1] + backward[i + 1]);

        return fans;
    }
}
