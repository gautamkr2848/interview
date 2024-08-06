package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

// Input: N = 3, K = 2, arr[] = { 2, 1, 2 }
//Output: 3
//Explanation: We can pick all of them
//
//Input: N = 6, K = 1, arr[]  = { 0, 1, 2, 2, 2, 2 }
//Output: 4
//Explanation: It’s optimal to pick from index 2(0-indexed) [2, 3, 4, 5].

public class FruitBasket {

    int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int i = 0;
        int maxFruits = 0;

        for (i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            // If basket has more than 2 type of fruits,  start emptying the basket
            while (map.size() > 2) {
                int fruitCount = map.get(fruits[j]);
                if (fruitCount == 1)
                    map.remove(fruits[j]);
                else
                    map.put(fruits[j], fruitCount - 1);
                j++;
            }

            maxFruits = Math.max(maxFruits, i - j + 1);
        }
        return maxFruits;
    }

}
