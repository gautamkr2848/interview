package com.interview.dynamic.unboundedKnapsack;

//Find minimum number of coins that make a given value

import java.util.ArrayList;
import java.util.List;

public class c_CoinChangeMinNumberCoins {

    public void coinChangeMinNumberCoins(int[] coinArray, int sum){
        int n = coinArray.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 0;
        for (int i = 0; i <= sum; i++)
            t[0][i] = Integer.MAX_VALUE - 1;
        for (int i = 0; i <= sum; i++) {
            if(coinArray[0] % sum == 0)
                t[1][i] = coinArray[0] / sum;
            else
                t[1][i] = Integer.MAX_VALUE - 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(coinArray[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = Math.min(1 + t[i][j-coinArray[i-1]], t[i-1][j]);
            }
        }
        System.out.println(t[n][sum]);
    }

    public void coinChangeMinNumberCoins_2(){
        int coin[] = {25, 10, 5, 20 };
        int sum = 35;
        int n = coin.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < Math.pow(2,n); i++){
            int val = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (int)Math.pow(2,j)) > 0) {
                    val = val + coin[j];
                    list.add(coin[j]);
                }
            }
            if(sum == val)
                ans.add(list);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<ans.size(); i++){
            if(ans.get(i).size() < min)
                min = ans.get(i).size();
        }
        System.out.print(min);
    }

    public void test(){
        System.out.println(0 & 0);
        System.out.println(1 & 0);
        System.out.println(0 & 1);
        System.out.println(1 & 1);
    }
}
