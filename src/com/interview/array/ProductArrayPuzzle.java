package com.interview.array;

public class ProductArrayPuzzle {

    public void productArrayPuzzle(){
        int arr[] = { 10, 3, 5, 6, 2 };
        int n = arr.length;

        if (n == 1) {
            System.out.print("0");
            return;
        }

        int i, temp = 1;
        int prod[] = new int[n];
        for (int j = 0; j < n; j++)
            prod[j] = 1;

        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp = temp * arr[i];
        }

        temp = 1;

        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] = prod[i] * temp;
            temp = temp * arr[i];
        }

        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");
    }
}
