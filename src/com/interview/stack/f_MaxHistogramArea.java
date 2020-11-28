package com.interview.stack;

import java.util.Stack;

/*1) Create an empty stack.
  2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
      a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
      b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of
         the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as
         smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and
         ‘right index’ is ‘i’ (current index).
  3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.*/

public class f_MaxHistogramArea {

    public void maxArea(){
        int[] histogram = { 6, 2, 5, 4, 5, 1, 6 };
        Stack<Integer> stk = new Stack<>(); //used for index only
        int max_area = 0;
        int top;
        int area;

        int i = 0;
        while (i < histogram.length){
            if (stk.empty() || histogram[stk.peek()] <= histogram[i]) {
                stk.push(i++);
            } else {
                top = stk.pop();
                //area calculation formula
                area = histogram[top] * (stk.empty() ? i : i - stk.peek() - 1);

                if (max_area < area)
                    max_area = area;
            }
        }

        while (!stk.empty()){
            top = stk.pop();
            area = histogram[top] * (stk.empty() ? i : i - stk.peek() - 1);

            if (max_area < area)
                max_area = area;
        }
        System.out.println("Max Area : "+max_area);
    }
}
