package com.interview.recursion;

public class GCD {

    public int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    //time complexity - O(log(min(a,b))

    public int gcd_2(int a, int b){
        int dividend = a >= b ? a : b;
        int divisor = a <= b ? a : b;

        while(divisor != 0){
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }

        return dividend;
    }

    //Time complexity - log(n)
}
