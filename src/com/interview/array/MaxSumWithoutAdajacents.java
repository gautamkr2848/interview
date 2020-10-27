package com.interview.array;

public class MaxSumWithoutAdajacents {

    public void maxSumWithoutAdajacents(){
        int arr[] = {5, 5, 10, 100, 10, 5};
        int incl = arr[0];
        int excl = 0;
        int excl_new;

        for (int i = 1; i < arr.length; i++) {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        System.out.println((incl > excl) ? incl : excl);
    }
}
