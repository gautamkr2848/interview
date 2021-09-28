package com.interview.array;

import java.util.ArrayList;
import java.util.Stack;

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