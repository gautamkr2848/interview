package com.interview.array;

public class RemoveDuplicateFromSortedArray {

    // {1, 2, 2, 2, 3, 4, 4, 4, 5, 5}

    public static int removeDuplicates_2(int arr[]) {
        int i = 1;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j-1] != arr[j]) {
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = removeDuplicates_2(a);

        for(int i=0; i<n; i++){
            System.out.print(a[i] + " ");
        }
    }
}
