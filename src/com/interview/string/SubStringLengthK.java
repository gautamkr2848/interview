package com.interview.string;

public class SubStringLengthK {

    public static void SubString(String str, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                System.out.println(str.substring(i, j));
    }

    public void print(int n, char[] k, char[] A) {
        if (n <= 0) {
            System.out.print(String.valueOf(A) + " ");
        } else {
            for (int i = 0; i < k.length; i++) {
                A[n-1] = k[i];
                print(n-1, k, A);
            }
        }
    }
}
