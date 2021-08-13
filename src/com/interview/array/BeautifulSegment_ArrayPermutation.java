package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class BeautifulSegment_ArrayPermutation {

    List<int[]> list = new ArrayList<>();
    public void countBeautifulSegments(){
        int n = 5;

        int[] a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = i+1;

        getAllPermutations(a);

        int count = 0;
        for(int i=0; i<list.size(); i++){
            int[] tmp = list.get(i);
            int j;
            for(j=1; j<=tmp.length; j++){
                if(!(tmp[j-1] % j == 0 || j % tmp[j-1] == 0))
                    break;
            }
            if(j == tmp.length + 1)
                count++;
        }
        System.out.println(count);
    }

    private void getAllPermutations(int[] a){
         helper(a, 0, a.length-1);
    }

    private void helper(int[] array, int l, int r){
        if (l == r) {
            int[] tmp = new int[array.length];
            for(int i=0; i<array.length; i++)
                tmp[i] = array[i];
            list.add(tmp);
        } else {
            for (int i = l; i <= r; i++) {
                array= swap(array, l, i);
                helper(array, l + 1, r);
                array = swap(array, l, i);
            }
        }
    }

    private int[] swap(int[] a, int b, int c){
        int t = a[b];
        a[b] = a[c];
        a[c] = t;
        return a;
    }
}
