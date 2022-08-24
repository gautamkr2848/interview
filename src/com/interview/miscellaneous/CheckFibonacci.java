package com.interview.miscellaneous;

public class CheckFibonacci {

    public Boolean checkFibonacci(int n){
        return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
    }

    private boolean isPerfectSquare(int x){
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }
}
