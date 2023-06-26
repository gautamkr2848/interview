package com.interview.tree;

import java.util.*;

// There is a car with capacity empty seats.

// You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that
// the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi
// respectively.

// Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

//Hint भाई क्या करो तुम लोग एक Array बना लो और उसे एक बस (Bus) की तरह कल्पना करो, जिस स्टॉप पर सवारी आ रही हो वहा से लेकर जहां पर सवारी
// उतर री हो, वहा तक, Bus (Array) में सवारियों को जोड़ लो.
//
//अंत में देख लेना अगर किसी भी स्टॉप पर बस की क्षमता से अधिक सवारी हो रही हो तो False वापसी कर देना नहीं तो True
//
//क्यूकी सिरफ 1001 स्टॉप है इसलिये ये Method काम करेगा !

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int stops[] = new int[1001];

        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }

        for (int i = 0; capacity >= 0 && i < 1001; i++)
            capacity = capacity - stops[i];

        return capacity >= 0;
    }
}