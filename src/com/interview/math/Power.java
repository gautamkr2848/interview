package com.interview.math;

public class Power {

    public int power(int a, int b){
        if(b == 0)
            return 1;
        int temp = power(a, b/2);
        if(b % 2 == 0)
            return temp * temp;
        else {
            if(b > 0)
                return a * temp * temp;
            else
                return (temp * temp) / a;
        }
    }

}
