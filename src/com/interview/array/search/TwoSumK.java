package com.interview.array.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumK {

    public void twoSumK(int[] a, int k){
        Arrays.sort(a);
        for(int i=0, j=a.length-1; i<j;){
            if(a[i] + a[j] == k)
                System.out.println(i+" "+j);
            else if(a[i] + a[j] > k)
                j--;
            else
                i++;
        }
    }

    public void twoSumK_2(int[] a, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i])){
                res[0] = map.get(a[i]) + 1;
                res[1] = i + 1;
            } else {
                map.put(k - a[i], i);
            }
        }
        System.out.println(res);
    }
}
