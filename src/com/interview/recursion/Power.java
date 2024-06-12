package com.interview.recursion;

public class Power {

    public int power(int a, int b){
        if(b == 0)
            return 1;
        return a * power(a, b - 1);
    }
}
