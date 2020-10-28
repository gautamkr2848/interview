package com.interview.miscellaneous;

public class NumberOfTrailingZeroes {

    public void numberOfTrailingZeroes(int n){
        int count = 0;
        for(int i=5; n/i>0; i=i*5){
            count = count + (n/i);
        }
        System.out.println(count);
    }
}
