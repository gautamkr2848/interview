package com.interview.array;

// no. of swaps to sort the array

public class ArrayInversion {

    public void arrayInversion(){
        int[] a = {2, 4, 1, 5};
        int count = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j])
                    count++;

        System.out.println("Inversion count "+ count);
    }

}
