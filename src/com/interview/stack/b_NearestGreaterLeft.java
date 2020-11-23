package com.interview.stack;

//  1   3   2   4   =>      -1  -1  3   -1

import java.util.Stack;
import java.util.Vector;

public class b_NearestGreaterLeft {

    public void b_NearestGreaterLeft(){
        int[] arr = {1, 3, 2, 4};

        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<arr.length-1; i++){
            if(s.empty())
                v.add(-1);
            else if(s.peek() > arr[i])
                v.add(s.peek());
            else if(s.peek() <= arr[i]){
                while (!s.empty() && s.peek() <= arr[i])
                    s.pop();
                if(s.empty())
                    v.add(-1);
                else
                    v.add(s.peek());
            }
            s.push(arr[i]);
        }
    }
}
