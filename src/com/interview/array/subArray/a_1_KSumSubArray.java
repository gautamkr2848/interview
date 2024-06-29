package com.interview.array.subArray;

/*
Input : arr[] = {10, 2, -2, -20, 10}, k = -10
Output : 3
Explanation: Subarrays: arr[0…3], arr[1…4], arr[3..4] have a sum exactly equal to -10.

Input : arr[] = {9, 4, 20, 3, 10, 5}, k = 33
Output : 2
Explanation: Subarrays : arr[0…2], arr[2…4] have a sum exactly equal to 33.
*/

import java.util.*;

public class a_1_KSumSubArray {

    public void kSumSubArray_2(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum == k)
                    res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        printAllSubarrays(arr, k);
    }

    public static void kSumSubArray() {
        int[] arr = {0,0,5,5,0,0};
        Map<Integer, Integer> map = new HashMap();
        int currSum = 0;
        int k = 0;
        int count = 0;

        for(int i = 0; i < arr.length; ++i) {
            currSum = currSum + arr[i];
            if (currSum == k)
                count++;

            count = count + map.getOrDefault(currSum - k, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        System.out.println(count);
    }

    public static void printAllSubarrays(int[] A, int sum) {
        Map<Integer, List<Integer>> map = new HashMap<>();  //value should be list of index

        int currSum = 0;
        for (int i = 0; i < A.length; i++) {
            currSum = currSum + A[i];

            if(currSum == sum) {
                System.out.println(0 + " " + i);
            }

            if (map.containsKey(currSum - sum)) {
                List<Integer> list = map.get(currSum - sum);
                for (Integer index: list) {
                    System.out.println((index+1) + " " + i);
                }
            }
            map.putIfAbsent(currSum, new ArrayList<>());
            map.get(currSum).add(i);
        }
    }

}
