package com.interview.stack;

//  1   3   2   4   =>      -1  -1  3   -1

import java.util.Stack;

public class a_NearestGreaterNumbersOnLeft {

    public void nearestGreaterNumbersOnLeft(){
        int[] a = {1, 3, 2, 4};
        System.out.print( "-1, ");
        int n = a.length;

        for(int i=1; i<n; i++){
            int j;
            for(j=i-1; j>=0; j--){
                if(a[j] > a[i]){
                    System.out.print(a[j] + ", ");
                    break;
                }
            }

            if(j == -1)
                System.out.print("-1, ");
        }
    }

    public void b_NearestGreaterNumbersOnLeft_2(){
        int[] a = {1, 3, 2, 4};
        int n = a.length;
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            while (!s.empty() && s.peek() <= a[i])
                s.pop();

            // If all elements in S were less than arr[i]
            if (s.empty()) {
                System.out.print("-1, ");
            } else { //Else print the nearest smaller element
                System.out.print(s.peek() + ", ");
            }

            s.push(a[i]);
        }
    }
}
