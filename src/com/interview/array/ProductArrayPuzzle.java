package com.interview.array;

public class ProductArrayPuzzle {

    public void productArrayPuzzle(){
        int arr[] = { 10, 3, 5, 6, 2 };
        int n = arr.length;

        int prod = 1;
        for (int i = 0; i < n; i++)
            prod *= arr[i];

        for (int i = 0; i < n; i++)
            System.out.print(prod/arr[i] + " ");
    }
}
