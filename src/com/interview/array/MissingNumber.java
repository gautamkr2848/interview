package com.interview.array;

public class MissingNumber {

    public static void missingNumber() {
        int[] a = {2, 5, 6, 4, 1, 3, 8};
        int n = 8;
        int xor = 0;

        for(int i=1; i<=n; i++)
            xor = xor ^ i;

        for(int i=0; i<a.length; i++)
            xor = xor ^ a[i];

        System.out.println(xor);
    }

    public static void main(String[] args) {
        missingNumber();
    }
}
