package com.interview.array.sort;

import java.util.Arrays;

/*Counting sort is a sorting algorithm that sorts the elements of an array by counting
  the number of occurrences of each unique element in the array. The count is stored in an
  auxiliary array and the sorting is done by mapping the count as an index of the auxiliary
  array.*/

public class f_CountingSort {

    public void countingSort(){
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            count[arr[i] - min]++;

        for (int i = 1; i < count.length; i++)
            count[i] = count[i] + count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--){
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++)
            System.out.print(output[i]+" ");
    }
}
