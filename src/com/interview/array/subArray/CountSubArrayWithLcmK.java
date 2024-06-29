package com.interview.array.subArray;

public class CountSubArrayWithLcmK {

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; ++i) {
            int currLCM = nums[i];

            for (int j = i; j < nums.length; ++j) {
                currLCM = lcm(currLCM, nums[j]);
                if (currLCM > k)
                    break;
                else if (currLCM == k)
                    ans++;
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
