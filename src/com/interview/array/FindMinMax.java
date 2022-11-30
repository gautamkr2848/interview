package com.interview.array;

public class FindMinMax {

    public void getMinMax(int arr[], int n) {
        int min, max, i;

        if (n == 1)
            System.out.println("Min : "+arr[0] + " Max : "+arr[0]);

        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }

        for (i = 2; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Min : "+ min + " Max : "+ max);
    }
}
