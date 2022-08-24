package com.interview.recursion;

public class Power {

    public int power(int a, int b){
        if(b == 0)
            return 1;
        return a * power(a, b - 1);
    }

    public int power_2(int a, int b){
        if(b == 0)
            return 1;

        int x;
        if(a % 2 == 0){
            x = power_2(a, b/2);
            return x * x;
        } else {
            x = power_2(a, (b-1)/2);
            return a * x * x;
        }
    }
}
