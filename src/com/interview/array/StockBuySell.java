package com.interview.array;

public class StockBuySell {

    public void maxProfit(){

        int[] price = {100, 180, 260, 310, 40, 535, 695};
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
}
