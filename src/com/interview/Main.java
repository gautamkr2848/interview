package com.interview;

import com.interview.array.NextPermutation;
import com.interview.array.subArray.a_2_CountSubArrayWithEqual_0_1;
import com.interview.array.subArray.d_MaxProductSubArray;
import com.interview.dynamic.knapsack.d_SubsetSumCount;
import com.interview.dynamic.knapsack.f_SubsetSumDiffCount;
import com.interview.string.LetterCasePermutation;

import java.lang.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5, 4 };
        NextPermutation n = new NextPermutation();
        n.nextPermutation(arr);

        //nextPermutation(arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void nextPermutation(int[] arr){
        int i = arr.length-2;
        while(i>=0) {
            if(arr[i] > arr[i+1]){
                i--;
            } else {
                break;
            }
        }

        int j = arr.length-1;
        while(j>0) {
            if(arr[j] < arr[i])
                j--;
            else
                break;
        }

        swap(arr, i, j);
        reverse(arr, i+1);

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
