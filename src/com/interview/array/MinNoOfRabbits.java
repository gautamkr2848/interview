package com.interview.array;

/*
There are some colored rabbits in a forest. Given an array arr[] of size N,
        such that arr[i] denotes the number of rabbits having same color as the ith rabbit,
        the task is to find the minimum number of rabbits that could be in the forest.

        1. Initialize a variable count to store the number of rabbits in each group.
        2. Initialize a map and traverse the array having key as arr[i] and value as occurrences of arr[i] in the given array.
        3. Now, if y rabbits answered x, then:
        4. If (y%(x + 1)) is 0, then there must be (y / (x + 1)) groups of (x + 1) rabbits.
        5. If (y % (x + 1)) is non-zero, then there must be (y / (x + 1)) + 1 groups of (x + 1) rabbits.
        6. Add the product of the number of groups and the number of rabbits in each group to the variable count.
        7. After the above steps, the value of count gives the minimum number of rabbits in the forest.*/

import java.util.HashMap;
import java.util.Map;

public class MinNoOfRabbits {

    public void minNumberOfRabbits() {
        int arr[] = { 10, 10, 10 };
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);

        // Find the number groups and no. of rabbits in each group
        for (int a : map.keySet()) {
            int x = a;
            int y = map.get(a);

            // Find number of groups and multiply them with number of rabbits in each group
            if (y % (x + 1) == 0)
                count = count + (y / (x + 1)) * (x + 1);
            else
                count = count + ((y / (x + 1)) + 1) * (x + 1);
        }
        System.out.println(count);
    }
}
