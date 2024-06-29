package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

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
