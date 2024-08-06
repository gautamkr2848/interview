package com.interview.array;

import java.util.*;

// Loss means substracting 2 values
// Substraction will be min when the values are closer to each other
// In this case, first value should be greater than second value

public class HouseMinLoss {

    public static void minLoss() {
        List<Integer> prices = Arrays.asList(20, 15, 8, 2, 12);
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<prices.size(); i++)
            map.put(prices.get(i), i);

        Collections.sort(prices);
        for(int i = prices.size()-1; i>0; i--){
            if(map.get(prices.get(i-1)) < map.get(prices.get(i))) {
                continue;
            }
            min = Math.min(min, prices.get(i) - prices.get(i-1));
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        minLoss();
    }
}
