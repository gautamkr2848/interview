package com.interview.dynamic;

public class MaxStolenVaue {
    public int maxLoot() {
        int house[] = {6, 7, 1, 3, 8, 2, 4};
        int n = house.length;

        if (n == 0)
            return 0;
        if (n == 1)
            return house[0];
        if (n == 2)
            return Math.max(house[0], house[1]);

        int[] dp = new int[n];
        dp[0] = house[0];
        dp[1] = Math.max(house[0], house[1]);

        for (int i = 2; i<n; i++)
            dp[i] = Math.max(house[i]+dp[i-2], dp[i-1]);

        return dp[n-1];
    }

    public void maxSumWithoutAdajacents(){
        int arr[] = {5, 5, 10, 100, 10, 5};
        int incl = arr[0];
        int excl = 0,excl_new;

        for (int i = 1; i < arr.length; i++) {
            excl_new = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = excl_new;
        }
        System.out.println(Math.max(incl, excl));
    }

    //Applicable only for 2 x n matrix
    public void maxSum(int grid[][], int n) {
        int incl = Math.max(grid[0][0], grid[1][0]);
        int excl = 0, excl_new;

        for (int i = 1; i < n; i++ ) {
            excl_new = Math.max(incl, excl);
            incl = excl + Math.max(grid[0][i], grid[1][i]);
            excl = excl_new;
        }
        System.out.println(Math.max(incl, excl));
    }

    //Max Sum such that no three elements are consecutive
    public int maxSumWO3Consec(int arr[], int n) {
        int sum[] = new int[n];
        if(n <= 3)
            return Integer.MAX_VALUE;

        sum[0] = arr[0];
        sum[1] = arr[0] + arr[1];
        sum[2] = Math.max(sum[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

        for (int i = 3; i < n; i++)
            sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + arr[i]),
                    arr[i] + arr[i - 1] + sum[i - 3]);

        return sum[n - 1];
    }
}
