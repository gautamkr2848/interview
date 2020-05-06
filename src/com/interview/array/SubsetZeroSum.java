package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class SubsetZeroSum {

    public void subsetZeroSum(){
        int[] A = {0, 1, -1, 2, -2, 3};
        int n = A.length;
        int count = 0 ;
        for (int i = 0; i < Math.pow(2,n); i++){
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (int)Math.pow(2,j)) > 0) {
                    sum = sum + A[j];
                    list.add(A[j]);
                }
            }
            if(sum == 0) {
                System.out.println(list.toString());
                count++;
            }
        }
        System.out.println("Total subset with 0 sum: "+ count);
    }
}
