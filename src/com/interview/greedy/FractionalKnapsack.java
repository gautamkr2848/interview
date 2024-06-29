package com.interview.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack {

    public static void main(String[] args) {
        List<ItemValue> list = Arrays.asList(new ItemValue(60, 10),
                new ItemValue(100, 20),
                new ItemValue(120, 30) );

        int capacity = 50;

        Collections.sort(list, (o1, o2) -> Integer.valueOf(o2.profit/o2.weight).compareTo(Integer.valueOf(o1.profit/o1.weight)));

        int max = 0, wt = 0;
        for(ItemValue i : list) {
               if(wt + i.weight > capacity) {
                   int remainingWt = capacity - wt;
                   max = max + ((i.profit)/ (i.weight)) * remainingWt;
                   break;
               }
               wt = wt + i.weight;
               max = max + i.profit;
        }

        System.out.println(max);
    }
}

class ItemValue {
    Integer profit, weight;

    public ItemValue(Integer val, Integer wt) {
        this.weight = wt;
        this.profit = val;
    }
}
