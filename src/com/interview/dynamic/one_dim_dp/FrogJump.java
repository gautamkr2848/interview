package com.interview.dynamic.one_dim_dp;

public class FrogJump {

    public int frogJump(int[] a, int n) {
        if(n == 0)
            return 0;

        int left = frogJump(a, n-1) + Math.abs(a[n] - a[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = frogJump(a, n-2) + Math.abs(a[n] - a[n-2]);

        return Math.min(left, right);
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
}
