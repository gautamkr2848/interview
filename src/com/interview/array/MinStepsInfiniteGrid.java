package com.interview.array;

/*
Given an infinite grid, initial cell position (x, y) and a sequence of other cell position which needs to be covered in
the given order. The task is to find the minimum number of steps needed to travel to all those cells.

Note: Movement can be done in any of the eight possible directions from a given cell i.e from cell (x, y) you can move
to any of the following eight positions:(x-1, y+1), (x-1, y), (x-1, y-1), (x, y-1), (x+1, y-1), (x+1, y), (x+1, y+1),
(x, y+1) is possible.
*/

public class MinStepsInfiniteGrid {

    public void minSteps(int[] A, int[] B){
        int steps = 0;
        for(int i=1; i<A.length; i++){
            steps = steps + (Math.abs(A[i] - A[i-1]) > Math.abs(B[i] - B[i-1]) ?
                    Math.abs(A[i] - A[i-1]) : Math.abs(B[i] - B[i-1]));
        }
        System.out.println(steps);
    }

}
