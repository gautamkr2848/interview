package com.interview.dynamic.knapsack;

//Divide array into two parts and check both parts have equal sum

public class c_EqualSumPartition {

    public void equalSumPartition(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        if(sum % 2 != 0)
            System.out.println("Not Possible");
        else {
            b_SubsetSum s = new b_SubsetSum();
            s.subSetSum(arr, sum/2);
        }
    }
}
