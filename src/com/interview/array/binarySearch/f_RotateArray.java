package com.interview.array.binarySearch;

public class f_RotateArray {

    //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    public void arrayRotation(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] tmp = new int[arr.length*2];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        System.arraycopy(arr, 0, tmp, arr.length, arr.length);
        for(int i=k; i<(arr.length+k); i++)
            System.out.print(tmp[i]+" ");
    }
}
