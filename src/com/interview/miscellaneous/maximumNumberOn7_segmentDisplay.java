package com.interview.miscellaneous;

public class maximumNumberOn7_segmentDisplay {

    public void segments(int n){
        if (n == 1 || n == 0)
            return;

        if (n % 2 == 0) {       // Condition to check if the number is even
            System.out.print("1");
            segments(n - 2);
        } else if (n % 2 == 1) {        // Condition to check if the number is odd
            System.out.print("7");
            segments(n - 3);
        }
    }
}
