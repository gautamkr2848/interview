package com.interview.recursion;

public class Fibonacci {

    public int fibonacci(int n){
        if(n==0 || n==1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
