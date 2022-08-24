package com.interview.array;

public class ArrayProductExceptSelf {

    public int[] productExceptSelf(int[] a) {
        int prod = 1;
        int flag = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                flag++;
            else
                prod = prod * a[i];
        }

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {

            if (flag > 1)
                res[i] = 0;
            else if (flag == 0)
                res[i] = (prod / a[i]);
            else if (flag == 1 && a[i] != 0)
                res[i] = 0;
            else // if(flag == 1 && a[i] == 0)
                res[i] = prod;
        }
        return res;
    }
}
