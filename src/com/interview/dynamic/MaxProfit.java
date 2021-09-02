package com.interview.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxProfit {

    public int maxProfit(int[] a, int k, int n) {
        int[][] t = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++)
            t[i][0] = 0;

        for (int j = 0; j <= n; j++)
            t[0][j] = 0;

        for (int i = 1; i <= k; i++){
            for (int j = 1; j < n; j++){
                int max_so_far = 0;
                for (int m = 0; m < j; m++)
                    max_so_far = Math.max(max_so_far, a[j] - a[m] + t[i - 1][m]);

                t[i][j] = Math.max(t[i] [j - 1], max_so_far);
            }
        }
        return t[k][n - 1];
    }

    public void maxProfit_2(){

        int[] price = {900, 180, 260, 310, 40, 535, 695};
        int profit = 0;
        int k = 1;

        Stack<Transaction> stack = new Stack<>();
        for(int i=1; i<price.length; i++){
            int diff = price[i] - price[i-1];
            if(diff > 0){
                Transaction t = new Transaction(i-1, i, diff);
                if(!stack.empty() && stack.peek().sell == t.buy){
                    Transaction tmp = stack.pop();
                    Transaction t1 = new Transaction(tmp.buy, t.sell, tmp.profit + diff);
                    stack.push(t1);
                } else {
                    stack.push(t);
                }
            }
        }

        List<Integer> list= new ArrayList<>();
        while (!stack.empty()){
            Transaction t = stack.pop();
            list.add(t.profit);
        }

        Collections.sort(list);
        for(int i = list.size()-1; i>=0 && k>0; i--, k--){
            System.out.println(list.get(i) + " ");
        }
    }
}

class Transaction{
    int buy;
    int sell;
    int profit;

    Transaction(int buy, int sell, int profit){
        this.buy = buy;
        this.sell = sell;
        this.profit = profit;
    }
}
