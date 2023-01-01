package com.interview.recursion;

public class Fibonacci {

    //There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair
    // or 2 stairs at a time. Count the number of ways, the person can reach the top.
    //As parameter need to pass n + 1

    public int fibonacci(int n){
        if(n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //Time Complexity: O(2^n)
}
