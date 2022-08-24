package com.interview.dynamic;

public class MaxStolenVaue {

    public int maxLoot() {
        int house[] = {6, 7, 1, 3, 8, 2, 4};
        int n = house.length;
        int[] dp = new int[n];

        if(house.length >= 2) {
            dp[0] = house[0];
            dp[1] = Math.max(house[0], house[1]);
        }

        for (int i = 2; i<n; i++)
            dp[i] = Math.max(house[i]+dp[i-2], dp[i-1]);

        return dp[n-1];
    }

    //Max Sum such that no three elements are consecutive
    public void maxSumNoThreeConsuctive(){
        int[] arr = { 100, 1000, 100, 1000, 1 };
        int[] sum = new int[arr.length];

        if(arr.length >= 3){
            sum[0] = arr[0];
            sum[1] = arr[0] + arr[1];
            sum[2] = Math.max(sum[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        }

        // We have three cases
        // 1) Exclude arr[i], i.e., sum[i] = sum[i-1]
        // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
        // 3) Exclude arr[i-2], i.e., sum[i] = sum[i-3] + arr[i] + arr[i-1]

        if(arr.length > 3){
            for(int i=3; i<arr.length; i++)
                sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + arr[i]), arr[i] + arr[i - 1] + sum[i - 3]);
        }
        System.out.print(sum[arr.length - 1]);
    }
}
