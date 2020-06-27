package com.interview.miscellaneous;

public class NumberOfSquaresInRectange {

    public void numberOfSquaresInRectange(){
        int m = 3, n = 2;
        if(n < m){
            int temp = m;
            m = n;
            n = temp;
        }
        System.out.println((m * (m + 1) * (2 * m + 1) / 6) + ((n - m) * m * (m + 1) / 2));
    }
}
