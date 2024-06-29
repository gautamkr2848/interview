package com.interview.dynamic.knapsack;

//Divide array into two parts and check both parts have equal sum

import java.util.Arrays;

public class c_EqualSumPartition {

    public void equalSumPartition(int[] arr){
        int sum = Arrays.stream(arr).sum();

        if(sum % 2 != 0)
            System.out.println("Not Possible");
        else {
            b_SubsetSum s = new b_SubsetSum();
            s.subSetSum(arr, sum/2);
        }
    }
}
