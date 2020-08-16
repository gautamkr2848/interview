package com.interview.stack;

import java.util.Stack;

public class MaxHistogramArea {

    public void maxArea(){
        int[] histogram = {2, 1, 2, 3, 1};
        Stack<Integer> stk = new Stack<>();
        int max_area = 0;
        int top;
        int area;

        int i = 0;
        while (i < histogram.length){
            if (stk.empty() || histogram[stk.peek()] <= histogram[i]) {
                stk.push(i++);
            } else {
                top = stk.peek();
                stk.pop();
                //area calculation formula
                area = histogram[top] * (stk.empty() ? i : i - stk.peek() - 1);

                if (max_area < area)
                    max_area = area;
            }
        }

        while (!stk.empty()){
            top = stk.peek();
            stk.pop();
            area = histogram[top] * (stk.empty() ? i : i - stk.peek() - 1);

            if (max_area < area)
                max_area = area;
        }
        System.out.println("Max Area : "+max_area);
    }
}
