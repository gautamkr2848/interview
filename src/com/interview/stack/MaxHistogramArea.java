package com.interview.stack;

/*
Find the previous and the next smaller element for every element of the histogram, as this would help to calculate the
length of the subarray in which this current element is the minimum element. So we can create a rectangle of size
(current element * length of the subarray) using this element. Take the maximum of all such rectangles.

maxArea = height * (Nearest Smaller to Right index - Nearest Samller to Left index - 1)

        { 6, 2, 5, 4, 5, 1, 6 }
NSR       1, 5, 3, 5, 5, 7, 7
NSL     -1, -1, 1, 1, 3, -1, 5
Area    6, 10, 5, 12, 5, 7, 6
 */

public class MaxHistogramArea {

    public void maxArea_2(){
        int[] a = { 6, 2, 5, 4, 5, 1, 6 };
        int area = Integer.MIN_VALUE;
        int n = a.length;

        for(int i=0; i<n; i++){
            int left = i;
            int right = i;

            while(left >=0 && a[i] <= a[left])
                left--;

            while (right < n && a[i] <= a[right])
                right++;

            int tmp = (right - left - 1) * a[i];
            area = Math.max(area, tmp);
        }
    }

    //Nearest smaller element left side
    //Nearest smaller element right side
    public void maxArea(){
        int[] a = { 6, 2, 5, 4, 5, 1, 6 };

        //int[] nsr = nearestSmallerToRight(histogram);
        //int[] nsl = nearestSmallerToLeft(histogram);

        int[] nsr = {1, 5, 3, 5, 5, 7, 7};
        int[] nsl = {-1, -1, 1, 1, 3, -1, 5};

        int area = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            int val = (nsr[i] - nsl[i] - 1) * a[i];
            if(val > area)
                area = val;
        }
        System.out.print("Max area is " + area);
    }
}
