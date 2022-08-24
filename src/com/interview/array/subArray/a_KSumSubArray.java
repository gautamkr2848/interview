package com.interview.array.subArray;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class a_KSumSubArray {

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

    public void printAllSubarrays(int[] A, int sum) {
        Map<Integer, List<Integer>> map = new HashMap<>();  //value should be list of index

        int currSum = 0;
        for (int i = 0; i < A.length; i++) {
            currSum = currSum + A[i];

            if (map.containsKey(currSum - sum)) {
                List<Integer> list = map.get(currSum - sum);
                for (Integer index: list)
                    System.out.println(IntStream.range(index + 1, i + 1).mapToObj(k -> A[k]).collect(Collectors.toList()));
            }
            map.putIfAbsent(currSum, new ArrayList<>());
            map.get(currSum).add(i);
        }
    }
}
