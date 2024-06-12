package com.interview.string;

/*Input: N = 3, Output: 5
The 5 strings are 000, 001, 010, 100, 101*/

public class ConsecutiveOneNotAllowed {

    private void countStrings(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println(a + b);
    }

    public static void main(String[] args) {

    }

    public void consecutiveOneNotAllowed(){
        int n = 3;
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++){
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        System.out.println(a[n-1] + b[n-1]);
    }
}
