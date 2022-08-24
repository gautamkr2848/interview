package com.interview.stack;

import java.util.Stack;

public class StackSorting {

    public void stackSorting(){
        Stack<Integer> input = new Stack<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        Stack<Integer> tmp = new Stack<>();

        while (!input.empty()){
            int value = input.pop();
            while(!tmp.isEmpty() && tmp.peek() > value)
                input.push(tmp.pop());

            tmp.push(value);
        }

        //print temp stack
    }
}
