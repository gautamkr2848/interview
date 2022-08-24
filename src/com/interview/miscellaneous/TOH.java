package com.interview.miscellaneous;

public class TOH {

    public void TOH(int n, char s, char d, char a){
        if (n == 1) {
            System.out.println("Move disk 1 from rod " +  s + " to rod " + d);
            return;
        }
        TOH(n-1, s, a, d);
        System.out.println("Move disk " + n + " from rod " +  s + " to rod " + d);
        TOH(n-1, a, d, s);
    }
}
