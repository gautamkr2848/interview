package com.interview.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*1) Create an empty stack.
  2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
      a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
      b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of
         the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as
         smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and
         ‘right index’ is ‘i’ (current index).
  3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.*/


//maxArea = height * (Nearest Smaller to Right index - Nearest Samller to Left index - 1)

/*
        { 6, 2, 5, 4, 5, 1, 6 }
NSR       1, 5, 3, 5, 5, 7, 7
NSL     -1, -1, 1, 1, 3, -1, 5
Area    6, 10, 5, 12, 5, 7, 6
 */

public class f_MaxHistogramArea {

    public void maxArea(){
        int[] histogram = { 6, 2, 5, 4, 5, 1, 6 };

        //int[] nsr = nearestSmallerToRight(histogram);
        //int[] nsl = nearestSmallerToLeft(histogram);

        int[] nsr = {1, 5, 3, 5, 5, 7, 7};
        int[] nsl = {-1, -1, 1, 1, 3, -1, 5};

        int area = Integer.MIN_VALUE;
        for(int i=0; i<histogram.length; i++){
            int val = histogram[i] * (nsr[i] - nsl[i] - 1);
            if(val > area)
                area = val;
        }
        System.out.print("Max area is " + area);
    }

    public void maxHistogram_2(){
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        Stack<Integer> s = new Stack<>();

        int max_area = 0;

        int i = 0;
        while (i < hist.length) {
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);
            else {
                max_area = calculateArea(s, hist, i, max_area);
            }
        }

        while (!s.empty())
            max_area = calculateArea(s, hist, i, max_area);

        System.out.println(max_area);
    }

    private int calculateArea(Stack<Integer> s, int[] hist, int pos, int max_area){
        int top = s.pop();
        int area = hist[top] * (s.empty() ? pos : pos - s.peek() - 1);
        return max_area < area ? area : max_area;
    }
}
