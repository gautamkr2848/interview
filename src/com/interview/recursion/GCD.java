package com.interview.recursion;

public class GCD {

    public int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
