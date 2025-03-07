package com.interview.miscellaneous;

public class Factorial {

    public void factorial(){
        int n = 5;
        int res[] = new int[500];

        res[0] = 1;
        int res_size = 1;

        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");
        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
    }

    private int multiply(int x, int res[], int res_size) {
        int carry = 0;

        for (int i = 0; i < res_size; i++){
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod/10;
        }

        while (carry!=0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    public int factorial_2(int n){
        if(n == 0)
            return 1;
        else
            return n * factorial_2(n - 1);
    }

}
