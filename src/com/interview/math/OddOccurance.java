package com.interview.math;

public class OddOccurance {

    static int getOddOccurrence() {
        int res = 0;
        int ar[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            res = res ^ ar[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getOddOccurrence());
    }
}
