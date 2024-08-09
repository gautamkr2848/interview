package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

public class a_2_CountSubArrayWithEqual_0_1 {

    public static void countSubarrWithEqualZeroAndOne(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                arr[i] = -1;    // Replacing 0's in array with -1

            sum = sum + arr[i];
            
            if (sum == 0)
                count++;

            count = count + map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 0, 1, 1};
        int n = a.length;
        countSubarrWithEqualZeroAndOne(a, n);
    }
}
