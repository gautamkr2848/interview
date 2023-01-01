package com.interview.array;

public class ArrayProductExceptSelf {

    public class ProductArrayPuzzle {

        public void productArrayPuzzle(){
            int arr[] = { 10, 3, 5, 6, 2 };
            int n = arr.length;

            int prod = 1;
            for (int i = 0; i < n; i++)
                prod *= arr[i];

            for (int i = 0; i < n; i++)
                System.out.print(prod/arr[i] + " ");
        }
    }

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
