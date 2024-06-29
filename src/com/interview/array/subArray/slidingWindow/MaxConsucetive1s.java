package com.interview.array.subArray.slidingWindow;

public class MaxConsucetive1s {

    int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    // k = number of 0's are allowed to convert 1

    // int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}
    // int k = 2

    int longestOnes(int[] nums, int k) {

        int zeroCount = 0, j = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[j] == 0)
                    zeroCount--;

                j++;
            }

            count = Math.max(count, i - j + 1);
        }
        return count;
    }
}
