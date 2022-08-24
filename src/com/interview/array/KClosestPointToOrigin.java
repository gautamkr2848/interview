package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] pts, int k) {

        int[] distance = new int[pts.length];
        for(int i = 0; i < pts.length; i++) {
            int x = pts[i][0], y = pts[i][1];
            distance[i] = (x * x) + (y * y);
        }

        Arrays.sort(distance);

        int distk = distance[k - 1];

        int[][] res = new int[k][];
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < pts.length; i++) {
            int x = pts[i][0], y = pts[i][1];
            int dist = (x * x) + (y * y);

            if (dist <= distk){
                int[] arr = new int[2];
                arr[0] = x;
                arr[1] = y;
                list.add(arr);
            }
        }

        for(int i=0; i<k; i++)
            res[i] = list.get(i);

        return res;
    }
}
