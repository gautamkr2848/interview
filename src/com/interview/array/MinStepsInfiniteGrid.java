package com.interview.array;

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
