package com.interview.miscellaneous;

public class PowerOfNumber {

    public void powerOfNumber_1(){
        int base = 3;
        int exponent = 4;
        int result = 1;
        while (exponent != 0){
            result *= base;
            --exponent;
        }
        System.out.println("Answer = " + result);
    }

    public int power(int N, int P){
        if (P == 0)
            return 1;
        else
            return N * power(N, P - 1);
    }
}
