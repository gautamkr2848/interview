package com.interview.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*

Let profit[t][i] represent maximum profit using at most t transactions up to day i (including day i). Then the relation is:
profit[t][i] = max(profit[t][i-1], max(price[i] – price[j] + profit[t-1][j]))
          for all j in range [0, i-1]
profit[t][i] will be maximum of –

profit[t][i-1] which represents not doing any transaction on the ith day.
Maximum profit gained by selling on ith day. In order to sell shares on ith day, we need to purchase it on any one of [0, i – 1] days. If we buy shares on jth day and sell it on ith day, max profit will be price[i] – price[j] + profit[t-1][j] where j varies from 0 to i-1. Here profit[t-1][j] is best we could have done with one less transaction till jth day.

    */

public class StockBuySell {

    public void maxProfit(){

        int[] price = {900, 180, 260, 310, 40, 535, 695};
        int profit = 0;

        for(int i=1; i<price.length; i++){
            int diff = price[i] - price[i-1];
            if(diff > 0){
                System.out.println("Buy on day : "+ (i-1) + "  Sell on day : "+ i);
                profit = profit + diff;
            }
        }
        System.out.println("Maximum profit : " + profit);
    }

    public int maxProfit_2(int price[], int n, int k) {
        int t[][] = new int[k + 1][ n + 1];

        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff, t[i - 1][j - 1] - price[j - 1]);
                t[i][j] = Math.max(t[i][j - 1], price[j] + prevDiff);
            }
        }
        return t[k][n - 1];
    }

    //with only one txn
    public void maxProfit_3(int arr[]) {
        int minSoFar = arr[0];
        int maxProfit = 0;

        for(int i=0; i<arr.length; i++){
            minSoFar = Math.min(minSoFar, arr[i]);
            int profit = arr[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        System.out.println(maxProfit);
    }

    public void stockBuySell() {
        int[] A = { 100, 180, 260, 310, 40, 535, 695 };
        Stack<Interval> s = new Stack<>();
        for(int i=1; i<A.length; i++){
            int profit = A[i] - A[i-1];
            if(profit > 0){
                Interval tmp = new Interval(i-1, i);
                if(!s.empty()) {
                    Interval interval = s.peek();
                    if(interval.end >= tmp.start){
                        s.pop();
                        s.push(new Interval(interval.start, tmp.end));
                    } else
                        s.push(tmp);
                } else
                    s.push(tmp);
            }
        }

        while(!s.empty()){
            Interval j = s.pop();
            System.out.print("(" + j.start + " " + j.end + ")");
        }
    }
}

class Interval{
    int start;
    int end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MaxProfit {

    public void maxProfit_2(){

        int[] price = {900, 180, 260, 310, 40, 535, 695};
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


