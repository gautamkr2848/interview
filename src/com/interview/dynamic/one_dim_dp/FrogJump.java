package com.interview.dynamic.one_dim_dp;

import java.util.LinkedList;
import java.util.Queue;

public class FrogJump {

    public int frogJump(int[] a, int n) {
        if(n == 0)
            return 0;

        int oneJump = frogJump(a, n-1) + Math.abs(a[n] - a[n-1]);
        int twoJump = Integer.MAX_VALUE;
        if(n > 1)
            twoJump = frogJump(a, n-2) + Math.abs(a[n] - a[n-2]);

        return Math.min(oneJump, twoJump);
    }

    public int min(int arr[],int N, int[] dp){
        if(N == 0)
            return 0;

        if(dp[N] != -1)
            return dp[N];

        int left = min(arr, N-1, dp) + Math.abs(arr[N] - arr[N-1]);
        int right = Integer.MAX_VALUE;
        if(N > 1) {
            right = min(arr, N-2, dp) + Math.abs(arr[N] - arr[N-2]);
        }
        dp[N] = Math.min(left, right);
        return dp[N];
    }

    public int min(int arr[],int N){
        if(N == 0)
            return 0;

        int[] t = new int[N+1];
        for(int i=1; i<=N; i++) {
            int left = t[i-1] + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) {
                right = t[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            t[i] = Math.min(left, right);
        }
        return t[N];
    }

    // if frog can jump k steps

    public int frogJump_2(int[] a, int n, int k) {
        if(n == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        while(k > 0) {
            min = Math.min(min, frogJump_2(a, n - k, k) + Math.abs(a[n] - a[n - k]));
            k--;
        }

        return min;
    }

    // can jump to last

    // if we don't have zero in array, every time we'll at the end

    // try to shift final pos from right to left

    // Input: arr[] = {2, 3, 1, 1, 4}
    // Output: True

    public boolean canJump_2(int[] nums) {
        int finalPos = nums.length - 1;

        for(int i = nums.length-2; i>=0; i--){
            if(i + nums[i] >= finalPos)
                finalPos = i;
        }

        return finalPos == 0;
    }


    // min jump to reach last

    // int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

    // o/p - 3

    int jump(int[] nums) {

        int count = 0, n = nums.length - 1, distCovered = 0, lastJumpIdx = 0;

        if (nums.length == 1) return 0;     // Base case

        for (int i = 0; i < nums.length; i++) {

            distCovered = Math.max(distCovered, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = distCovered;
                count++;

                if (distCovered >= n) {        // check if we reached destination already
                    return count;
                }
            }
        }

        return count;
    }


    // Jump Game can reach 0 in either direction

    // Input: arr = [4,2,3,0,3,1,2], start = 5
    // Output: true

    // starting point

    static boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (arr[curr] == 0)     // reached the target index
                return true;

            // negative means we already tried it
            if (arr[curr] < 0)
                continue;

            // Try both directions
            if (curr + arr[curr] < arr.length)
                q.add(curr + arr[curr]);

            if (curr - arr[curr] >= 0)
                q.add(curr - arr[curr]);

            arr[curr] = -arr[curr];     // mark this element as visited
        }

        return false;
    }
}
