package com.interview.tree;

import java.util.*;

public class CarPooling {
    int capacity = 4;
    public boolean carPooling(int capacity) {
        int[][] trips = {{3, 2, 7},
                        {3, 7, 9},
                        {8, 3, 9}};
        this.capacity = capacity;

        List<Trip> tripList = new ArrayList<>();
        for (int i = 0; i < trips.length; i++)
            tripList.add(new Trip(trips[i][0], trips[i][1], trips[i][2]));

        Collections.sort(tripList, (o1,o2) -> o1.start.compareTo(o2.start));

        TreeMap<Integer, Integer> downPassengers = new TreeMap<>();
        for (int i = 0; i < trips.length; i++) {
            Trip trip = tripList.get(i);
            // whenever a new station comes, you already dropped all the passenger before this location
            dropAllPassengerBefore(trip.start, downPassengers);
            if (trip.passengers > this.capacity)
                return false;
            else {
                downPassengers.compute(trip.end, (k, v) -> v == null ? trip.passengers : v + trip.passengers);
                this.capacity = capacity - trip.passengers;
            }
        }
        return true;
    }

    private void dropAllPassengerBefore(int start, TreeMap<Integer, Integer> downPassengers) {
        Iterator<Map.Entry<Integer, Integer>> it = downPassengers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> endTime = it.next();
            if (endTime.getKey() <= start) {
                capacity = capacity + endTime.getValue();
                it.remove();
            } else {
                break;
            }
        }
    }
}

class Trip {
    public Integer passengers;
    public Integer start;
    public Integer end;

    public Trip(int passengers, int start_loc, int end_location) {
        this.passengers = passengers;
        this.start = start_loc;
        this.end = end_location;
    }
}