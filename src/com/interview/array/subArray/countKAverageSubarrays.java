package com.interview.array.subArray;

import java.util.HashMap;

public class countKAverageSubarrays {

    public static void main(String[] args) {
        int K = 6;
        int arr[] = { 12, 5, 3, 10, 4, 8, 10, 12, -6, -1 };
        int N = arr.length;
        countSubArray(arr, N, K);

        System.out.println(countKAverageSubarrays(arr, N, K));
    }

    static void countSubArray(int[] arr, int N, int K){
        int avg = 0, count = 0;

        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=i; j<N; j++) {
                sum = sum + arr[j];
                int len = (j - i + 1);

                if(sum % len == 0) {
                    avg = sum / len;

                    if (avg == K)
                        count++;
                }
            }
        }

        System.out.println(count);
    }

    static int countKAverageSubarrays(int[] arr, int n, int k) {
        int result = 0, curSum = 0;

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {

            curSum = curSum + (arr[i] - k);     // Subtract k from each element,  then add it to curSum

            if (curSum == 0)        // If curSum is 0 that means sum[0...i] is 0 so increment res
                result++;

            // Check if curSum has occurred  before and if it has occurred  before, add it's frequency to res
            result= result + mp.getOrDefault(curSum, 0);

            mp.put(curSum, mp.getOrDefault(curSum, 0) + 1);
        }

        return result;
    }

}
