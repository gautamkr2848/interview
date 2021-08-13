package com.interview.stack;

/*Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element is on the left side.If no small element present on the left print -1.


        Example 1:
        Input: n = 3
        a = {1, 6, 2}
        Output: -1 1 1


        Example 2:
        Input: n = 6
        a = {1, 5, 0, 3, 4, 5}
        o/p : -1, 1, -1, 0, 3, 4
*/

//Cleartrip

import java.util.Stack;

public class b_NearestSmallerNumbersOnLeft {

    public void nearestSmallerNumbersOnLeft(){
        //int[] arr = {1, 5, 0, 3, 4, 5};
        int[] arr = {25, 2, 5, 8, 4};
        System.out.print( "-1, ");
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j;
            for(j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    System.out.print(arr[j] + ", ");
                    break;
                }
            }

            if (j == -1)
                System.out.print( "-1, ") ;
        }
    }

    public void nearestSmallerNumbersOnLeft_2(){
        int[] arr = {1, 5, 0, 3, 4, 5};
        int n = arr.length;
        Stack<Integer> S = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }

            // If all elements in S were greater than arr[i]
            if (S.empty()) {
                System.out.print("_, ");
            } else { //Else print the nearest smaller element
                System.out.print(S.peek() + ", ");
            }

            S.push(arr[i]);
        }
    }
}
