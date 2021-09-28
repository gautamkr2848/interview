package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

public class KSumSubArray {

    public void kSumSubArray(){
        int[] arr = new int[]{2, 3, 5, 5};
        Map<Integer, Integer> map = new HashMap();
        int currsum = 0;
        int sum = 5;
        int count = 0;

        for(int i = 0; i < arr.length; ++i) {
            currsum = currsum + arr[i];
            if (currsum == sum)
                count++;

            count = count + map.getOrDefault(currsum - sum, 0);
            map.put(currsum, map.getOrDefault(currsum, 0) + 1);
        }
        System.out.println(count);
    }
}
