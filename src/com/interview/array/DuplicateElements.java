package com.interview.array;


import java.util.HashMap;
import java.util.Map;

public class DuplicateElements {

    public void duplicateElements(int[] a){
        for(int i=0; i<a.length; i++) {
            if (a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                System.out.print(Math.abs(a[i])+" ");
            }
        }
    }

    public void duplicateElements_2(int[] a){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i]))
                map.put(a[i], map.get(a[i]) + 1);
            else
                map.put(a[i], 1);
        }

        for(Integer i : map.keySet()){
            if(map.get(i) > 1)
                System.out.println(i);
        }
    }
}
