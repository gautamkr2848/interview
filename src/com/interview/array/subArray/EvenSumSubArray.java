package com.interview.array.subArray;

public class EvenSumSubArray {

    public long countEvenSum(int[] arr, int n) {
        long res = 0;

        int s = 0;
        for (int i = n - 1; i >= 0; i--){
            if (arr[i] % 2 == 1)
                s = n - i - 1 - s;
            else
                s = s + 1;

            res = res + s;
        }
        return res;
    }
}
