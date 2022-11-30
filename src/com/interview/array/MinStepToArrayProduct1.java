package com.interview.array;

//Given an array arr[] containing N integers. In one step, any element of the array can either be
// increased or decreased by one. The task is to find minimum steps required such that the product
// of the array elements becomes 1.

public class MinStepToArrayProduct1 {

    public int MinStep(int a[], int n) {

        int negative = 0, zero = 0;
        int step = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zero++;
            } else if (a[i] < 0) {
                negative++;
                step = step + (-1 - a[i]);      // Extra cost needed to make it -1
            } else {
                step = step + (a[i] - 1);       // Extra cost needed to make it 1
            }
        }

        // Now the array will have -1, 0 and 1 only
        if (negative % 2 == 0) {
            step = step + zero;
        } else {
            if (zero > 0) {
                step = step + zero;
            } else {
                step = step + 2;
            }
        }

        return step;
    }
}
