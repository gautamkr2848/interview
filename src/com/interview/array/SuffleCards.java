package com.interview.array;

import java.util.Random;

public class SuffleCards {

    public void shuffle(int card[]) {
        int n = 52;
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(52 - i);

            int temp = card[r];
            card[r] = card[i];
            card[i] = temp;
        }
    }
}
