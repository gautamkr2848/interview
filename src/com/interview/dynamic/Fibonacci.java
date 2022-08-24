package com.interview.dynamic;

public class Fibonacci {

    public void fibonacci(int n) {
        int a = 0;
        int b = 1;

        int c = a + b;
        System.out.print(a+ " "+b+" ");
        while (c < n){
            System.out.print(c+" ");
            a = b;
            b = c;
            c = a + b;
        }
    }
}
