package com.interview.array;

public class Find3SortedNumbers {

    public void find3SortedNumbers(){
        int arr[] = {5, 7, 4, 8};
        int n = arr.length;

        int small = Integer.MAX_VALUE, large = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] <= small)
                small = arr[i];
            else if (arr[i] <= large)
                large = arr[i];
            else
                break;
        }

        if (i == n) {
            System.out.print("No such triplet found");
            return;
        }

        for (int j = 0; j <= i; j++) {
            if (arr[j] < large) {
                small = arr[j];
                break;
            }
        }
        System.out.print(small+" "+large+" "+arr[i]);
    }
}
