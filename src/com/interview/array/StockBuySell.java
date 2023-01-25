package com.interview.array;

/*
        Input:
        Stock Price: {2, 4, 7, 5, 4, 3, 5}
        k = 2

        Output: The maximum profit is 7 (sum of 5 and 2)

        Buy at a price 2 and sell at a price 7
        Buy at a price 3 and sell at a price 5


        Input:
        Stock Price: {1, 5, 2, 3, 7, 6, 4, 5}
        k = 3

        Output: The maximum profit is 10 (sum of 4, 5 and 1)

        Buy at a price 1 and sell at a price 5
        Buy at a price 2 and sell at a price 7
        Buy at a price 4 and sell at a price 5

        Practice This Problem

        There are several variations to the above problem:

        If we are allowed to stock only once, then we can find the maximum difference between two elements in the array,
        where the smaller element appears before the larger element.

        Now we are only allowed to make at most k stock transactions. We can solve the problem by using dynamic
        programming. Let T[k][i] be the maximum profit using most k transactions till the i'th day. Then T[k][i] can be
        written as:

        T[k][i] = max(T[k][i-1], T[k-1][j] + price[i] – price[j])
        where j varies from 0 to i-1
        The above relation states that T[k][i] would be a maximum of below:

        T[k][i-1], which represents not doing any transaction on the i'th day.
        Maximum profit gained by selling on the i'th day. To sell shares on the i'th day, we need to purchase them on
        any previous day. If we buy shares on the j'th day and sell it on the i'th day, the maximum profit will be
        price[i] - price[j] + T[k-1][j], where j varies from 0 to i-1 and T[k-1][j] is the best with one less
        transaction till the j'th day.
*/

public class StockBuySell {

    public void maxProfit() {

        int[] price = {900, 180, 260, 310, 40, 535, 695};
        int profit = 0;

        for (int i = 1; i < price.length; i++) {
            int diff = price[i] - price[i - 1];
            if (diff > 0) {
                System.out.println("Buy on day : " + (i - 1) + "  Sell on day : " + i);
                profit = profit + diff;
            }
        }
        System.out.println("Maximum profit : " + profit);
    }

    /*
    Optimized Solution
    We have already seen that T[i] can be written as:

    T[t][i] = max(T[t][i-1], price[i] – price[j] + T[t-1][j])
    where j varies from 0 to i-1
    If we carefully notice, max(price[i] - price[j] + T[t-1][j]) can be rewritten as,

        = price[i] + max(T[t-1][j] – price[j]), where j varies from 0 to i-1
        = price[i] + max(prev_diff, T[t-1][i-1] – price[i-1])

    where prev_diff is max(T[t-1][j] – price[j]) and j varies from 0 to i-2
    Since we have already calculated max(T[t-1][j] - price[j]) for every j within range [0, i-2], we can easily
    calculate it for j=i-1 in O(1) time. In other words, we don’t have to revisit range [0, i-1] to figure out the
    best day for buying stock. This can be determined in O(1) time using the following revised relation:

    T[t][i] = max(T[t][i-1], price[i] + max(prev_diff, T[t-1][i-1] – price[i-1]))
    where prev_diff is max(T[t-1][j] – price[j]) and j varies from 0 to i-2
*/

    public int maxProfit_2(int price[], int k) {
        int n = price.length;
        int t[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff, t[i - 1][j - 1] - price[j - 1]);
                t[i][j] = Math.max(t[i][j - 1], price[j] + prevDiff);
            }
        }
        return t[k][n - 1];
    }

    // For 1 txn
    public void maxProfitWithOneTxn(int arr[]) {
        int minSoFar = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minSoFar)
                minSoFar = arr[i];
            else if(arr[i] - minSoFar > profit)
                profit = arr[i] - minSoFar;
        }

        System.out.print(profit);
    }

    //For 2 txns
    public int maxtwobuysell(int arr[]) {
        int n = arr.length;
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;

        for(int i = 0; i < n; i++) {

            first_buy = Math.max(first_buy, 0 - arr[i]);
            first_sell = Math.max(first_sell, first_buy + arr[i]);
            second_buy = Math.max(second_buy, first_sell - arr[i]);
            second_sell = Math.max(second_sell, second_buy + arr[i]);

        }
        return second_sell;
    }
}