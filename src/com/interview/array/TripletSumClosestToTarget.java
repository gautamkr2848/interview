package com.interview.array;

import java.util.Arrays;

public class TripletSumClosestToTarget {

    public int solution(int[] arr, int x) {
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(x - sum) < Math.abs(x - closestSum))
                    closestSum = sum;

                if (sum > x)
                    right--;
                else
                    left++;
            }
        }
        return closestSum;
    }
}
