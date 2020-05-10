package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTriplet {

    public void pythagoreanTriplet(){

        int[] A = {3, 1, 4, 6, 5};
        int n = A.length;
        int count = 0 ;
        for (int i = 0; i < Math.pow(2,n); i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (int)Math.pow(2,j)) > 0) {
                    list.add(A[j]);
                }
            }
            if(list.size() == 3 &&
                    ((Math.pow(list.get(0), 2) == (Math.pow(list.get(1),2)) + Math.pow(list.get(1),2)) ||
                    (Math.pow(list.get(1), 2) == (Math.pow(list.get(0),2)) + Math.pow(list.get(2),2)) ||
                    (Math.pow(list.get(2), 2) == (Math.pow(list.get(0),2)) + Math.pow(list.get(1),2)))) {
                System.out.println(list.toString());
                count++;
            }
        }
        System.out.println("Total subset with pythagoreanTriplet: "+ count);
    }

}
