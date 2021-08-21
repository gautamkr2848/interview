package com.interview.slidingWindow;

public class FirstNegativeInWindow {

    public void firstNegativeInWindow(){
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int n = arr.length;
        int k = 3;

        int firstNegativeIndex = 0;
        int firstNegativeElement;

        for(int i = k - 1; i < n; i++) {

            // Skip out of window and positive elements
            while (firstNegativeIndex < i  &&
                    (firstNegativeIndex <= i - k || arr[firstNegativeIndex] > 0))
                firstNegativeIndex ++;

            if (arr[firstNegativeIndex] < 0)
                firstNegativeElement = arr[firstNegativeIndex];
            else
                firstNegativeElement = 0;

            System.out.print(firstNegativeElement + " ");
        }
    }
}
