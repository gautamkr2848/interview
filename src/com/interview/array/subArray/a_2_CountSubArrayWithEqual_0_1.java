package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

public class a_2_CountSubArrayWithEqual_0_1 {

    public void countSubarrWithEqualZeroAndOne(int[] arr, int n) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                arr[i] = -1;    // Replacing 0's in array with -1

            sum = sum + arr[i];
            
            if (sum == 0)
                count++;

            count = count + myMap.getOrDefault(sum, 0);
            myMap.put(sum, myMap.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
