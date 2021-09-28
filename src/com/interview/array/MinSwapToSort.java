package com.interview.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwapToSort {

    public int minSwaps(int arr[]){
        int count = 0;
        int N = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < N; i++)
            h.put(arr[i], i);

        for (int i = 0; i < N; i++){
            if (arr[i] != temp[i]){
                count++;
                int init = arr[i];

                swap(arr, i, h.get(temp[i]));

                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return count;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
