package com.interview.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequence {

    public int longestIncreasingSubSequence(int[] arr){

        int n = arr.length;
        int T[] = new int[n];
        int max = 0;

        Arrays.fill(T, 1);

        for (int i = 1; i < n; i++ )
            for (int j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && T[i] < T[j] + 1)
                    T[i] = T[j] + 1;

        /* Pick maximum of all LIS values */
        for (int i = 0; i < n; i++ )
            if ( max < T[i] )
                max = T[i];

        return max;
    }

    public void longestIncreasingSubSequence_2(){
        //int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int arr[] = {5, 13, 2, 11, 6, 8, 14, 8, 13};
        int n = arr.length;
        int max = 0;
        for(int i=0; i< Math.pow(2,n); i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                if ((i & (int)(Math.pow(2,j))) > 0)
                    list.add(arr[j]);
            }

            int k;
            for(k=0; k<list.size()-1;k++) {
                if(!(list.get(k) < list.get(k+1))){
                    break;
                }
            }
            if (k == list.size()-1 && list.size() > max)
                max = list.size();
        }
        System.out.println(max);
    }
}
