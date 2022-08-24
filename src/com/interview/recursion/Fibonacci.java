package com.interview.recursion;

public class Fibonacci {

    //count number of ways to reach nth stair. For that we have to pass n+1

    public int fibonacci(int n){
        if(n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
