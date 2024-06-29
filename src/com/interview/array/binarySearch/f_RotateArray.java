package com.interview.array.binarySearch;

public class f_RotateArray {

    //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    public void arrayRotation(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] tmp = new int[2 * arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        System.arraycopy(arr, 0, tmp, arr.length, arr.length);
        for(int i=k; i<(arr.length+k); i++)
            System.out.print(tmp[i]+" ");
    }

    // Another Option

    // arr = {1, 2, 3, 4, 5, 6, 7}

    // reverse = (7, 6, 5, 4, 3, 2, 1}

    // reverse first (length - k) numbers = {4, 5, 6, 7, 3, 2, 1}

    // reverse last k numbers = {4, 5, 6, 7, 1, 2, 3}
}
