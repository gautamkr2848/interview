package com.interview.recursion;

public class GCD {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b) {
        return (a*b) / gcd(a, b);
    }

    //time complexity - O(log(min(a,b))
}
