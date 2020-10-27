package com.interview.miscellaneous;

// chair game

public class JosephusProblem {

    public void josephus(){
        int sum = 0;
        int n = 14, k = 2;

        for(int i = 2; i <= n; i++)
            sum = (sum + k) % i;

        System.out.println(sum+1);
    }

    public int josephus2(int n, int k){
        if (n == 1)
            return 1;
        else
            return (josephus2(n - 1, k) + k-1) % n + 1;
    }

}
