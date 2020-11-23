package com.interview.stack;

//  1   3   2   4   =>      3   4   4   -1

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class a_NextLargestElement_NGR {

    public void a_NextLargestElement_NGR(){
        int[] arr = {1, 3, 2, 4};

        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
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
        Collections.reverse(v);
        Iterator i = v.iterator();
        while (i.hasNext())
            System.out.print(i.next());
    }
}
