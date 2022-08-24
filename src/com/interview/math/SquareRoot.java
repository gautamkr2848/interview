package com.interview.math;

public class SquareRoot {

    public void squareRoot(){
        int n = 11;
        if (n == 0 || n == 1)
            System.out.println(n);

        int i = 1, result = 1;
        while (result <= n) {
            i++;
            result = i * i;
        }
        System.out.println(i-1);
    }
}
